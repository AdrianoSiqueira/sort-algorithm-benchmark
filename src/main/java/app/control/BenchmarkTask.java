package app.control;

import app.algorithms.SortAlgorithm;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.concurrent.Task;
import app.model.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BenchmarkTask<T> extends Task<List<Test>> {

    private final List<SortAlgorithm<T>> sortAlgorithms;
    private final T[]                    array;
    private final Comparator<T>     comparator;

    public BenchmarkTask(List<SortAlgorithm<T>> sortAlgorithms, T[] array, Comparator<T> comparator) {
        this.sortAlgorithms = sortAlgorithms;
        this.array          = array;
        this.comparator     = comparator;
    }

    @Override
    protected List<Test> call() {
        List<Test>      testList = new ArrayList<>();
        IntegerProperty index    = new SimpleIntegerProperty(1);

        sortAlgorithms.forEach(sortable -> {
            updateMessage(sortable.getClass().getSimpleName());
            updateProgress(index.intValue(), sortAlgorithms.size());

            index.set(index.get() + 1);
            testList.add(new Test(sortable, sortable.sort(array.clone(), comparator)));
        });

        return testList;
    }
}
