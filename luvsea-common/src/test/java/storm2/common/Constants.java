package storm2.common;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Constants implements Serializable {
	//public static String hostList = "192.168.93.128,192.168.93.129,192.168.93.130";
	//public static String hostList = "192.168.93.128";
	public static String hostList = "47.97.63.1";
	//public static String hostList = "192.168.1.179,192.168.1.180,192.168.1.181";
	//public static String hbaseHostList = "192.168.93.128,192.168.93.129,192.168.93.130";
//	public static String hbaseHostList = "192.168.1.40,192.168.1.41,192.168.1.42";
	public static String zkPort = "2181";
	public static String topic = "yanghaiyangtopic123456789";
	public static int putCount = 1000;
	public static int sumCount = 100000;
}