package storm;

import java.util.Map;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;

import com.luvsea.common.utils.StringUtils;

public class FilterBolt extends BaseRichBolt{
    private OutputCollector collector;

    /**
     * 初始化工作
     */
    public void prepare(Map map, TopologyContext context, OutputCollector collector){
        this.collector = collector;
    }

    /**
    * 执行逻辑，目的是过滤无用的字符串
    */
    public void execute(Tuple input){
        String str = input.getString(0);
        if(StringUtils.isNotBlank(str)){
            String [] lines = str.split("\n");
            for(String line : lines){
                if(StringUtils.isBlank(line) || line.charAt(0) == '#'){
                    continue;
                }
                //发射到下一个bolt
                collector.emit(new Values(line));
            }
            //汇报给storm,该tuple执行成功
            collector.ack(input);
        }else{
            //执行失败
            collector.fail(input);
        }
    }

    /**
    * 申明传入到一个Bolt的字段名称
    */
    public void declareOutputFields(OutputFieldsDeclarer declarer){
        declarer.declare(new Fields("line"));
    }

}