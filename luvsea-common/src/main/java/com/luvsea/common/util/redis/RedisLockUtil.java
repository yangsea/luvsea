package com.luvsea.common.util.redis;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.luvsea.common.basic.UtilString;
import com.luvsea.common.util.DateUtil;

/**
 * Redis distributed lock implementation.
 *
 * @author zhengcanrui
 */
public class RedisLockUtil {

    private static Logger logger = LoggerFactory.getLogger(RedisLockUtil.class);

    private static final int DEFAULT_ACQUIRY_RESOLUTION_MILLIS = 100;

    /**
     * Lock key path.
     */
    private String lockKey;

    /**
     * 锁超时时间，防止线程在入锁以后，无限的执行等待
     */
    private int expireMsecs = 60 * 1000;

    /**
     * 锁等待时间，防止线程饥饿
     */
//    private int timeoutMsecs = 10 * 1000;

    private volatile boolean locked = false;

    public RedisLockUtil( String lockKey) {
        this.lockKey = lockKey + "_lock";
    }

    /**
     * @return lock key
     */
    public String getLockKey() {
        return lockKey;
    }

    /**
     * 获得 lock. 实现思路: 主要是使用了redis 的setnx命令,缓存了锁. reids缓存的key是锁的key,所有的共享,
     * value是锁的到期时间(注意:这里把过期时间放在value了,没有时间上设置其超时时间) 执行过程:
     * 1.通过setnx尝试设置某个key的值,成功(当前没有这个锁)则返回,成功获得锁
     * 2.锁已经存在则获取锁的到期时间,和当前时间比较,超时的话,则设置新的值，附加：也就是获得锁。
     *
     * @return true if lock is acquired, false acquire timeouted
     * @throws InterruptedException
     *             in case of thread interruption
     */
    public  synchronized boolean lock() throws InterruptedException {

//        int timeout = 10 * 1000;
        int timeout = expireMsecs;
        while (timeout >= 0) {
            long expires = System.currentTimeMillis() + expireMsecs + 1;
            String expiresStr = String.valueOf(expires); // 锁到期时间
            // 如果为true，拿到锁。
            if (UtilsJedis.setNX(lockKey, expiresStr)) {
                // lock acquired
                locked = true;
                return true;
            }
            // 如果setNx设置失败，则未获取锁。
            String currentValueStr = UtilsJedis.get(lockKey); // redis里的时间
            if (currentValueStr != null && Long.parseLong(currentValueStr) < System.currentTimeMillis()) {
                // 判断是否为空，不为空的情况下，如果被其他线程设置了值，则第二个条件判断是过不去的
                // lock is expired
                String oldValueStr = UtilsJedis.getSet(lockKey, expiresStr);
                // 获取上一个锁到期时间，并设置现在的锁到期时间，
                // 只有一个线程才能获取上一个线上的设置时间，因为jedis.getSet是同步的
                // 上一个时间没有 老的时间，还是等于老的时间
                if (oldValueStr != null && oldValueStr.equals(currentValueStr)) {
                    // 防止误删（覆盖，因为key是相同的）了他人的锁——这里达不到效果，这里值会被覆盖，但是因为什么相差了很少的时间，所以可以接受
                    // [分布式的情况下]:如过这个时候，多个线程恰好都到了这里，但是只有一个线程的设置值和当前值相同，他才有权利获取锁
                    // lock acquired
                    locked = true;
                    return true;
                }
            }
//            timeout -= DEFAULT_ACQUIRY_RESOLUTION_MILLIS;
            /*
             * 延迟100 毫秒, 这里使用随机时间可能会好一点,可以防止饥饿进程的出现,即,当同时到达多个进程,
             * 只会有一个进程获得锁,其他的都用同样的频率进行尝试,后面有来了一些进行,也以同样的频率申请锁,这将可能导致前面来的锁得不到满足.
             * 使用随机的等待时间可以一定程度上保证公平性
             */
            Thread.sleep(DEFAULT_ACQUIRY_RESOLUTION_MILLIS);

        }
        return false;
    }

    /**
     * Acqurired lock release.
     */
    public synchronized void unlock() {
        if (locked) {
            UtilsJedis.del(lockKey);
            locked = false;
        }
    }

    public int getFloor() {

        RedisLockUtil lock = new RedisLockUtil("sanFloor");
        try {
            if (lock.lock()) {
                // 需要加锁的代码
                String floorHight = UtilsJedis.get("FloorHight");
                if(UtilString.isEmpty(floorHight)){
                    UtilsJedis.set("FloorHight","1",0);
                    logger.info(DateUtil.format(new Date(), "yyyy-MM-dd:HH:mm:ss")+"获取第一楼");
                    return 1;
                }else{
                    int floorNum = Integer.valueOf(floorHight)+1;
                    UtilsJedis.set("FloorHight", String.valueOf(floorNum),0);
                    logger.info(DateUtil.format(new Date(), "yyyy-MM-dd:HH:mm:ss")+"获取第：{}楼",floorNum);
                    return floorNum;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 为了让分布式锁的算法更稳键些，持有锁的客户端在解锁之前应该再检查一次自己的锁是否已经超时，
            //再去做DEL操作，因为可能客户端因为某个耗时的操作而挂起，
            // 操作完的时候锁因为超时已经被别人获得，这时就不必解锁了。 ————这里没有做
            //如果没有超时，解锁
            if(isTimeout()){
                lock.unlock();
            }
        }
        logger.info(DateUtil.format(new Date(), "yyyy-MM-dd:HH:mm:ss")+"获取楼层失败");
        return 0;
    }
    
    public boolean isTimeout(){
        
        String currentValueStr = UtilsJedis.get(lockKey); // redis里的时间
        if (currentValueStr != null && Long.parseLong(currentValueStr) < System.currentTimeMillis()) {
            //超时
            return false;
        }else{
            return true; //没有超时
        }
    }
    
    public static void main(String[] args) {
        
        ExecutorService exec = Executors.newFixedThreadPool(100);      
        for(int i = 0; i < 1000; i++) {   
            RedisLockUtil t = new RedisLockUtil();
            exec.execute(t.new httpclient());   
        }   
        exec.shutdown(); 
        
        
    }
    
    class httpclient extends Thread{
        
        @Override
        public void run() {
            RedisLockUtil rlu = new RedisLockUtil("saolou");
            System.out.println(rlu.getFloor());
        }
    }

    public RedisLockUtil() {
        super();
    }

}