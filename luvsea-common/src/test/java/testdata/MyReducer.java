package testdata;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
     * @author Edison Chou
     * @version 1.0
     * @param KEYIN
     *            →k2 表示每一行中的每个单词
     * @param VALUEIN
     *            →v2 表示每一行中的每个单词的出现次数，固定值为1
     * @param KEYOUT
     *            →k3 表示每一行中的每个单词
     * @param VALUEOUT
     *            →v3 表示每一行中的每个单词的出现次数之和
     */
    public class MyReducer extends
            Reducer<Text, LongWritable, Text, LongWritable> {
        protected void reduce(Text key,
                java.lang.Iterable<LongWritable> values,
                Reducer<Text, LongWritable, Text, LongWritable>.Context context)
                throws java.io.IOException, InterruptedException {
            long count = 0L;
            for (LongWritable value : values) {
                count += value.get();
            }
            context.write(key, new LongWritable(count));
        };
        
    }