package com.fiturriz.logging.poc.log4j2.model;

/**
 * Created by frankieic on 2/1/17.
 */
public class Event {

    private String type;

    private long timestamp;

    public Event() {
    }

    public Event(String type, long timestamp) {
        this.type = type;
        this.timestamp = timestamp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
