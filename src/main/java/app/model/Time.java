package app.model;

public class Time {

    private long day;
    private long hour;
    private long minute;
    private long second;
    private long millisecond;

    public Time(long millisecond) {
        setTime(millisecond);
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
