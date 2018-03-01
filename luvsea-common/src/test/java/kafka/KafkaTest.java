package kafka;

import java.util.Random;

public class KafkaTest {
	
	public static void main(String[] args) {
		
		
		for (int i = 0; i < 10; i++) {
			IpranAlarm ia = new IpranAlarm();
			ia.setA(new Random().nextInt(255));
			KafkaUtils.sendMsgToKafka(ia);
		}
		
	}

}
