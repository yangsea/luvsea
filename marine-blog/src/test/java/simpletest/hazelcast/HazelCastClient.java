package simpletest.hazelcast;

import java.util.Collection;
import java.util.Map;

import com.hazelcast.core.MapLoader;

public class HazelCastClient implements MapLoader<String, String> {

    @Override
    public String load(String key) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Map<String, String> loadAll(Collection<String> keys) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterable<String> loadAllKeys() {
        // TODO Auto-generated method stub
        return null;
    }

       
    
}
