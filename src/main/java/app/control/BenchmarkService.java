package app.control;

import app.algorithms.SortAlgorithm;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import app.model.Test;

import java.util.Comparator;
import java.util.List;

public class BenchmarkService<T> extends Service<List<Test>> {

    private final List<SortAlgorithm<T>> sortAlgorithms;
    private final T[]                    array;
    private final Comparator<T>     comparator;

    public BenchmarkService(List<SortAlgorithm<T>> sortAlgorithms, T[] array, Comparator<T> comparator) {
        this.sortAlgorithms = sortAlgorithms;
        this.array          = array;
        this.comparator     = comparator;
    }

    @Override
    protected Task<List<Test>> createTask() {
        return new BenchmarkTask<>(sortAlgorithms, array, comparator);
    }
}
