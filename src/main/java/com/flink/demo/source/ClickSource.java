package com.flink.demo.source;

import com.flink.demo.entry.Event;
import org.apache.flink.streaming.api.functions.source.SourceFunction;

import java.util.Calendar;
import java.util.Random;

public class ClickSource implements SourceFunction<Event> {
    private Boolean running = true;

    @Override
    public void run(SourceContext<Event> ctx) throws Exception {
        Random random = new Random();

        String[] users = {"Mary", "Alice", "Bob", "Cary"};
        String[] urls = {"./home", "./cart", "./fav", "./prod?id=1", "./prod?id=2"};

        while(running){
            ctx.collect(new Event(
                users[random.nextInt(users.length)],
                urls[random.nextInt(urls.length)],
                Calendar.getInstance().getTimeInMillis()
            ));
        }
        Thread.sleep(1000);

    }

    @Override
    public void cancel() {
        running = false;
    }
}
