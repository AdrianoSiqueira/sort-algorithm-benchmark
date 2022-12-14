package com.github.adrianosiqueira.sortalgorithmbenchmark.model;

public class Time {

    private long day;
    private long hour;
    private long minute;
    private long second;
    private long millisecond;


    public Time() {}

    public Time(long millisecond) {
        setTime(millisecond);
    }


    public long getDay() {
        return day;
    }

    public long getHour() {
        return hour;
    }

    public long getMillisecond() {
        return millisecond;
    }

    public long getMinute() {
        return minute;
    }

    public long getSecond() {
        return second;
    }

    public void setTime(long millisecond) {
        this.second      = millisecond / 1000;
        this.millisecond = millisecond % 1000;

        this.minute = this.second / 60;
        this.second %= 60;

        this.hour = this.minute / 60;
        this.minute %= 60;

        this.day = this.hour / 24;
        this.hour %= 24;
    }

    @Override
    public String toString() {
        return String.format("%d", day) +
               ":" +
               String.format("%02d", hour) +
               ":" +
               String.format("%02d", minute) +
               ":" +
               String.format("%02d", second) +
               ":" +
               String.format("%03d", millisecond);
    }
}
