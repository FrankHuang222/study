package com.flink.demo.source;

import com.flink.demo.entry.Event;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class SourceCustom {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        env.setParallelism(2);
        DataStreamSource<Event> eventDataStreamSource = env.addSource(new ClickSource());

        eventDataStreamSource.print();

        env.execute();
    }
}
