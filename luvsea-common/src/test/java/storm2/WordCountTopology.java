package storm2;

import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.StormSubmitter;
import org.apache.storm.kafka.BrokerHosts;
import org.apache.storm.kafka.KafkaSpout;
import org.apache.storm.kafka.SpoutConfig;
import org.apache.storm.kafka.StringScheme;
import org.apache.storm.kafka.ZkHosts;
import org.apache.storm.spout.SchemeAsMultiScheme;
import org.apache.storm.topology.TopologyBuilder;
import org.apache.storm.tuple.Fields;

import storm2.bolt.PrintBolt;
import storm2.bolt.SurfBolt;
import storm2.bolt.WordCountBolt;
import storm2.common.CommonUtil;
import storm2.common.Constants;


/**
 *
 * 调优点1：设置worker数量
 * Worker是运行在工作节点上面，被Supervisor守护进程创建的用来干活的进程。
 * 每个Worker对应于一个给定topology的全部执行任务的一个子集。
 * 反过来说，一个Worker里面不会运行属于不同的topology的执行任务。
 * 数目至少应该大于machines的数目
 *
 * 调优点2：给指定component创建的executor数量。通过setSpout/setBolt的参数来设置。
 * Executor可以理解成一个Worker进程中的工作线程。
 * 一个Executor中只能运行隶属于同一个component（spout/bolt）的task。
 * 一个Worker进程中可以有一个或多个Executor线程。在默认情况下，一个Executor运行一个task。
 *
 * 调优点3：给指定 component 创建的task数量。通过调用setNumTasks()方法来设置。
 * Task则是spout和bolt中具体要干的活了。
 * 一个Executor可以负责1个或多个task。
 * 每个component（spout/bolt）的并发度就是这个component对应的task数量。
 * 同时，task也是各个节点之间进行grouping（partition）的单位。
 * 默认和executor1:1
 * 
 */
public class WordCountTopology {
    public static void main(String[] args) throws InterruptedException {
    	System.out.println("WordCountTopology main start!");

		BrokerHosts brokerHosts = new ZkHosts(CommonUtil.joinHostPort(Constants.hostList, Constants.zkPort));
		//topo 进度记录
		// zkRoot 是哪个zookeeper
		SpoutConfig spoutConfig = new SpoutConfig(brokerHosts, Constants.topic, "", "topo");
		spoutConfig.scheme = new SchemeAsMultiScheme(new StringScheme());
//		spoutConfig.forceFromStart = true; //消息处理失败后重来，这个不是ack完成的吗
		spoutConfig.zkServers = CommonUtil.strToList(Constants.hostList);
		spoutConfig.zkPort = Integer.valueOf(Constants.zkPort);

	    TopologyBuilder builder = new TopologyBuilder();
	    //以kafka作为数据源
        builder.setSpout("RandomSentence", new KafkaSpout(spoutConfig), 20);
        builder.setBolt("SurfBolt", new SurfBolt(), 4).shuffleGrouping("RandomSentence");
//        builder.setBolt("WordNormalizer", new WordNormalizerBolt(), 1).shuffleGrouping("RandomSentence").setNumTasks(1);
//        builder.setBolt("WordCount", new WordCountBolt(), 1).fieldsGrouping("WordNormalizer", new Fields("word")).setNumTasks(1);
//        builder.setBolt("Print", new PrintBolt(), 1).shuffleGrouping("WordCount").setNumTasks(1);

        Config config = new Config();
        config.setDebug(true);
        if (args != null && args.length > 0) {
            config.setNumWorkers(12);
            //这个不是必须
//        	config.put(Config.NIMBUS_HOST, iZbp1d9xxma2x9z2up2jz6Z);
        	try {
	            StormSubmitter.submitTopology(args[0], config, builder.createTopology());
	        	System.out.println("submitTopology success!");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
        } else {
            config.setMaxTaskParallelism(1);
            LocalCluster cluster = new LocalCluster();
            cluster.submitTopology("WordCountTopology", config, builder.createTopology());
        }

    	System.out.println("WordCountTopology main end!");
    }
}