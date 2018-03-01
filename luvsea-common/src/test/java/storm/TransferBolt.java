package storm;

import java.util.Map;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.tuple.Tuple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

public class TransferBolt extends BaseRichBolt{

    private Logger LOG = LoggerFactory.getLogger(TransferBolt.class);

    private OutputCollector collector;

    public void prepare(Map map, TopologyContext context, OutputCollector collector){
        this.collector = collector;
    }

    public void execute(Tuple input){
        String line = input.getString(0);
//        JSONObject json = JSONObject.toJson(line);
        JSONObject json = JSONObject.parseObject(line);
        //保存到elasticsearch 这里没必要了，直接输出
        System.out.println("直接输出的结果是："+line);
//        BulkRequest bulkRequest = new BulkRequest();
//        IndexRequest indexRequest = new IndexRequest("test","element",json.getString("id")).source(json.getJSONObject("source").toString());
//        bulkRequest.add(indexRequest);
//        BulkResponse response = client.bulk(bulkRequest).actionGet();
//        client.admin().indices().prepareRefresh("test").execute().actionGet();
    }

	@Override
	public void declareOutputFields(OutputFieldsDeclarer arg0) {
		// TODO Auto-generated method stub
		
	}

}