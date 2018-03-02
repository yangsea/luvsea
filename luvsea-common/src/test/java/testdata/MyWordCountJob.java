package testdata;

import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.mapreduce.lib.partition.HashPartitioner;

public class MyWordCountJob {

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
    public static class MyMapper extends
            Mapper<LongWritable, Text, Text, LongWritable> {
        protected void map(LongWritable key, Text value,
                Mapper<LongWritable, Text, Text, LongWritable>.Context context)
                throws java.io.IOException, InterruptedException {
            String[] spilted = value.toString().split(" ");
            for (String word : spilted) {
                context.write(new Text(word), new LongWritable(1L));
            }
        };
    }

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
    public static class MyReducer extends
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

    // 输入文件路径
    public static final String INPUT_PATH = "hdfs://hadoop-master:9000/testdir/input/words.txt";
    // 输出文件路径
    public static final String OUTPUT_PATH = "hdfs://hadoop-master:9000/testdir/output/wordcount";

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();

        // 0.0:首先删除输出路径的已有生成文件
        FileSystem fs = FileSystem.get(new URI(INPUT_PATH), conf);
        Path outPath = new Path(OUTPUT_PATH);
        if (fs.exists(outPath)) {
            fs.delete(outPath, true);
        }

        Job job = new Job(conf, "WordCount");
        job.setJarByClass(MyWordCountJob.class);

        // 1.0:指定输入目录
        FileInputFormat.setInputPaths(job, new Path(INPUT_PATH));
        // 1.1:指定对输入数据进行格式化处理的类（可以省略）
        job.setInputFormatClass(TextInputFormat.class);
        // 1.2:指定自定义的Mapper类
        job.setMapperClass(MyMapper.class);
        // 1.3:指定map输出的<K,V>类型（如果<k3,v3>的类型与<k2,v2>的类型一致则可以省略）
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(LongWritable.class);
        // 1.4:分区（可以省略）
        job.setPartitionerClass(HashPartitioner.class);
        // 1.5:设置要运行的Reducer的数量（可以省略）
        job.setNumReduceTasks(1);
        // 1.6:指定自定义的Reducer类
        job.setReducerClass(MyReducer.class);
        // 1.7:指定reduce输出的<K,V>类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);
        // 1.8:指定输出目录
        FileOutputFormat.setOutputPath(job, new Path(OUTPUT_PATH));
        // 1.9:指定对输出数据进行格式化处理的类（可以省略）
        job.setOutputFormatClass(TextOutputFormat.class);
        // 2.0:提交作业
        boolean success = job.waitForCompletion(true);
        if (success) {
            System.out.println("Success");
            System.exit(0);
        } else {
            System.out.println("Failed");
            System.exit(1);
        }
    }

}