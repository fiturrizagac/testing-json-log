package com.fiturriz.logging.poc.logback.model;

/**
 * Created by frankieic on 2/1/17.
 */
public class Data {

    private double amount;

    private String origin;

    private String target;

    public Data() {
    }

    public Data(double amount, String origin, String target) {
        this.amount = amount;
        this.origin = origin;
        this.target = target;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
}
