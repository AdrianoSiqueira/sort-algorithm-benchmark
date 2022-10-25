package app.model;

import app.algorithms.SortAlgorithm;

public class Test {

    private String algorithm;
    private Time   time;

    public Test() {
        algorithm = "";
        time      = new Time(0);
    }

    public Test(SortAlgorithm<?> algorithm, long time) {
        this();
        setAlgorithm(algorithm);
        setTime(time);
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(SortAlgorithm<?> algorithm) {
        this.algorithm = algorithm.getClass().getSimpleName();
    }

    public Time getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time.setTime(time);
    }

    @Override
    public String toString() {
        return "Test{" +
               "algorithm='" + algorithm + '\'' +
               ", time=" + time +
               '}';
    }
}
