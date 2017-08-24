package testdata;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
     * @author Edison Chou
     * @version 1.0
     * @param KEYIN
     *            →k1 表示每一行的起始位置（偏移量offset）
     * @param VALUEIN
     *            →v1 表示每一行的文本内容
     * @param KEYOUT
     *            →k2 表示每一行中的每个单词
     * @param VALUEOUT
     *            →v2 表示每一行中的每个单词的出现次数，固定值为1
     */
    public class MyMapper extends   Mapper<LongWritable, Text, Text, LongWritable> {
        protected void map(LongWritable key, Text value,
                Mapper<LongWritable, Text, Text, LongWritable>.Context context)
                throws java.io.IOException, InterruptedException {
            String[] spilted = value.toString().split(" ");
            for (String word : spilted) {
                context.write(new Text(word), new LongWritable(1L));
            }
        };
    }