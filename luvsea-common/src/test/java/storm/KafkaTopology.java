//package storm;
//public class KafkaTopology{
//
//    public static void main(String[] args) throws Exception{
//        String zks = PropertiesUtils.getString(KafkaProperties.ZK_HOSTS);
//        String topic = PropertiesUtils.getString(KafkaProperties.TOPIC);
//        String zkRoot = PropertiesUtils.getString(KafkaProperties.ZK_ROOT);
//        String id = PropertiesUtils.getString(KafkaProperties.STORM_ID);
//        BrokerHosts brokerHosts = new ZkHosts(zks);
//        SpoutConfig spoutConfig = new SpoutConfig(brokerHosts,topic,zkRoot,id);
//        spoutConfig.scheme = new SchemeAsMultiScheme(new StringScheme());
//        spoutConfig.zkServers = Arrays.asList(PropertiesUtil.getString(KafkaProperties.ZK_SERVERS).split(","));
//        spoutConfig.zkPort = PropertiesUtil.getInt(KafkaProperties.ZK_PORT);
//        TopologyBuilder builder = new TopologyBuilder();
//        builder.setSpout("kafka-reader",new KafkaSpout(spoutConfig),1);
//        builder.setBolt("filter-bolt",new FilterBolt(),1).shuffleGrouping("kafka-reader");
//        builder.setBolt("input-line",new TransferBolt(),1).shuffleGrouping("reader-input");
//        Config config = new Config();
//        String name = KafkaTopology.class.getSimpleName();
//        config.setNumWorkers(PropertiesUtil.getInt(KafkaProperties.NUM_WORKERS));
//        StormSubmitter.submitTopologyWithProgressBar(name,config,builder.createTopology());
//    }
//}