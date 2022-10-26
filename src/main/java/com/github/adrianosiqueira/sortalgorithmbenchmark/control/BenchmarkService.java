package com.github.adrianosiqueira.sortalgorithmbenchmark.control;

import com.github.adrianosiqueira.sortalgorithmbenchmark.algorithms.SortAlgorithm;
import com.github.adrianosiqueira.sortalgorithmbenchmark.model.Result;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BenchmarkService<T> extends Service<List<Result>> {

    private final List<SortAlgorithm<T>> algorithms;
    private final T[]                    array;
    private final Comparator<T>          comparator;


    public BenchmarkService(List<SortAlgorithm<T>> algorithms, T[] array, Comparator<T> comparator) {
        this.algorithms = algorithms;
        this.array      = array;
        this.comparator = comparator;
    }


    @Override
    protected Task<List<Result>> createTask() {
        return new TaskImpl();
    }


    private class TaskImpl extends Task<List<Result>> {
        @Override
        protected List<Result> call() {
            List<Result> results = new ArrayList<>();

            for (int i = 0; i < algorithms.size(); i++) {
                SortAlgorithm<T> algorithm = algorithms.get(i);

                updateMessage(algorithm.getClass().getSimpleName());
                updateProgress((i + 1), algorithms.size());

                Result result = algorithm.benchmark(array, comparator);
                results.add(result);
            }

            return results;
        }
    }
}
