package com.github.adrianosiqueira.sortalgorithmbenchmark.model;

import com.github.adrianosiqueira.sortalgorithmbenchmark.algorithms.SortAlgorithm;

import java.util.Arrays;

@SuppressWarnings("rawtypes")
public class Result {

    private Class<? extends SortAlgorithm> algorithm;
    private Time                           completionTime;
    private Object[]                       array;


    public Result() {
    }


    public Class<? extends SortAlgorithm> getAlgorithm() {
        return algorithm;
    }

    public Object[] getArray() {
        return array;
    }

    public Time getCompletionTime() {
        return completionTime;
    }

    public void setAlgorithm(Class<? extends SortAlgorithm> algorithm) {
        this.algorithm = algorithm;
    }

    public void setArray(Object[] array) {
        this.array = array;
    }

    public void setCompletionTime(Time completionTime) {
        this.completionTime = completionTime;
    }

    @Override
    public String toString() {
        return "Result{" +
               "algorithm=" + algorithm.getSimpleName() +
               ", completionTime=" + completionTime +
               ", array=" + Arrays.toString(array) +
               '}';
    }
}
