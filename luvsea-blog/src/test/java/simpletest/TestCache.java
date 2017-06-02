package simpletest;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class TestCache {
	

    CacheManager cacheManager = new CacheManager();  
  
    public void runCache() {  
        Cache cache = cacheManager.getCache("CAHCE_FOR_TOOLSBOX");  
        cache.put(new Element("testKey", "testValue"));  
        for (Object key : cache.getKeys()) {  
            System.out.println("Key:" + key + "，value:" + cache.get(key).getObjectValue());  
        }  
        cacheManager.shutdown();  
    }  
  
    public static void main(String[] args) throws Exception {  
        TestCache cl = new TestCache();  
        cl.runCache();  
    }  

}
