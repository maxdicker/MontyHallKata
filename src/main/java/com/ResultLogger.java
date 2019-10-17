package com;

public class ResultLogger {
    private int trueCount;
    private int totalResultsRecorded;

    public ResultLogger() {
        this.trueCount = 0;
        this.totalResultsRecorded = 0;
    }

    public void logBoolResult(boolean result) {
        if (result) {
            trueCount++;
        }
        totalResultsRecorded++;
    }

    public double getPercentageOfTrue() {
        return (double)trueCount/totalResultsRecorded*100;
    }
}
