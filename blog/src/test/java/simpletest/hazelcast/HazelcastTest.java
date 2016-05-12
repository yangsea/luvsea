package simpletest.hazelcast;

import java.util.Collection;
import java.util.Map;

import com.hazelcast.config.Config;
import com.hazelcast.core.DistributedObject;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.hazelcast.core.MapLoader;
import com.hazelcast.core.MapStoreAdapter;

public class HazelcastTest {

    public static void main(String[] args) {
        HazelcastInstance ins = Hazelcast.newHazelcastInstance();
        Map<String, Customer> mapCustomers =  ins.getMap("cusotmers");
        mapCustomers.put("1", new Customer("Joe", 2));
        mapCustomers.put("2", new Customer("Ali", 3));
        mapCustomers.put("3", new Customer("Avi", 4));
         
//        Collection<Customer> colCustomers = mapCustomers.values();
//        for (Customer customer : colCustomers) {
//            // process customer
//            System.out.println(customer.getName());
//        }
        Collection<DistributedObject> dos = ins.getDistributedObjects();
        for (DistributedObject distributedObject : dos) {
            if(dos instanceof IMap){
                System.out.println(distributedObject.getName());
            }
        }

//        Config conf = new Config();
        
                MapStoreAdapter<String, String> mapLoader = new MapStoreAdapter<String, String>();
               String aaa = mapLoader.load("ddd");
               System.out.println(aaa);
    }
}
