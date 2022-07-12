package com.flink.demo.wc;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;


public class BatchWordCount {
    public static void main(String[] args) throws Exception {
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

        DataSource<String> source = env.readTextFile("input/batch.txt");

        source.
                flatMap(new FlatMapFunction<String, Tuple2<String,Integer>>() {
                    public void flatMap(String s, Collector<Tuple2<String, Integer>> collector) throws Exception {
                        String[] s1 = s.split(" ");
                        for (String s2 : s1) {
                            collector.collect(Tuple2.of(s2,1));
                        }
                    }
                })
                .groupBy(0)
                .sum(1)
                .print();

    }
}
