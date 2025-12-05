package com.AdventOfCode2025.Models;

public class Range {
    private long min;
    public long getMin() {
        return min;
    }
    public void setMin(long mib) {
        this.min = mib;
    }

    private long max;
    public long getMax() {
        return max;
    }
    public void setMax(long max) {
        this.max = max;
    }

    public Range(long min, long max) {
        this.min = min;
        this.max = max;
    }
}
