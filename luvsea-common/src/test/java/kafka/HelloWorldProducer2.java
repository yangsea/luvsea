package kafka;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

public class HelloWorldProducer2 {
    public static void main(String[] args) {
//         long events = Long.parseLong(args[0]);
    	long events = 1L;
         Random rnd = new Random();
    
         Properties props = new Properties();
//         props.put("bootstrap.servers", "192.168.137.176:9092,192.168.137.176:9093,192.168.137.176:9094");
         props.put("bootstrap.servers", "47.97.63.1:9092");
         props.put("acks", "all");
         props.put("retries", 0);
         props.put("batch.size", 16384);
         props.put("linger.ms", 1);
         props.put("buffer.memory", 33554432);
         props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
         props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
         //配置partitionner选择策略，可选配置
         props.put("partitioner.class", "kafka.SimplePartitioner2");
    
         Producer<String, String> producer = new KafkaProducer<>(props);
    
         for (long nEvents = 0; nEvents < events; nEvents++) { 
                long runtime = new Date().getTime();  
                String ip = "192.168.2." + rnd.nextInt(255); 
//                 String ip = "47.97.63.1";
                String msg = runtime + ",www.example.com," + ip; 
                ProducerRecord<String, String> data = new ProducerRecord<String, String>("page_visits", ip, msg);
                producer.send(data,
                         new Callback() {
                     public void onCompletion(RecordMetadata metadata, Exception e) {
                         if(e != null) {
                            e.printStackTrace();
                         } else {
                            System.out.println("The offset of the record we just sent is: " + metadata.offset());
                         }
                     }
                 });
         }
         producer.close();
         System.out.println("退出");
    }
}