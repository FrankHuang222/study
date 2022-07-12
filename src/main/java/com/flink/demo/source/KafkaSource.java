package com.flink.demo.source;

import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class KafkaSource {
    public static void main(String[] args) {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

//        DataStreamSource<String> stream = env.addSource(new FlinkKafkaConsumer<String>(
//                "clicks",
//                new SimpleStringSchema(),
//                properties
//        ));
    }
}
