package com.fiturriz.logging.poc.logback.model;

/**
 * Created by frankieic on 2/1/17.
 */
public class LogData {

    private Event event;

    private Data data;

    public LogData() {
    }

    public LogData(final Event event, final Data data) {
        this.event = event;
        this.data = data;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
