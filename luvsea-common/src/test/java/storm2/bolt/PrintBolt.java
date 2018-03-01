package storm2.bolt;

import org.apache.storm.topology.BasicOutputCollector;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseBasicBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;

import storm2.common.Constants;


@SuppressWarnings("serial")
public class PrintBolt extends BaseBasicBolt {
    long count = 0;
    long startTime = System.currentTimeMillis();

    public void execute(Tuple input, BasicOutputCollector collector) {
    	if (count == 0) {
	    	System.out.println("PrintBolt run success. first msg is [" + input.getString(0) + "]");
		}
    	count++;
    	this.consoleLog();
    }

    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declare(new Fields("word"));
    }

	private void consoleLog() {
        if ((count % Constants.sumCount) == 0) {
        	long sumTime = System.currentTimeMillis();
        	System.out.println("[RESULT]count=[" + count + "], time=[" + (sumTime - startTime) + "]");
        }
	}
}
