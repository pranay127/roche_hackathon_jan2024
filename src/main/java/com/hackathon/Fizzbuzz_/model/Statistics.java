package com.hackathon.Fizzbuzz_.model;


public class Statistics {

    private String mostUsedRequest;
    private int mostUsedRequestCount;

    public Statistics(String mostUsedRequest, int mostUsedRequestCount) {
        this.mostUsedRequest = mostUsedRequest;
        this.mostUsedRequestCount = mostUsedRequestCount;
    }

    public String getMostUsedRequest() {
        return mostUsedRequest;
    }

    public int getMostUsedRequestCount() {
        return mostUsedRequestCount;
    }
}

