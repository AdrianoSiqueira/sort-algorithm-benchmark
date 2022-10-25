package com.github.adrianosiqueira.sortalgorithmbenchmark.algorithms;

import com.github.adrianosiqueira.sortalgorithmbenchmark.model.Result;
import com.github.adrianosiqueira.sortalgorithmbenchmark.model.Time;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public abstract class SortAlgorithm<T> {

    public static <T> List<SortAlgorithm<T>> getSortableList() {
        return Arrays.asList(new BubbleSort<>(),
                             new CocktailSort<>(),
                             new CombSort<>(),
//                             new CycleSort<>(),
                             new DefaultSort<>(),
                             new HeapSort<>(),
                             new InsertionSort<>(),
                             new MergeSort<>(),
                             new QuickSort<>(),
                             new SelectionSort<>(),
                             new ShellSort<>(),
                             new TreeSort<>());
    }

    public Result benchmark(T[] array, Comparator<T> comparator) {
        long start = System.currentTimeMillis();
        sort(array, comparator);
        long end = System.currentTimeMillis();

        Result result = new Result();
        result.setAlgorithm(getClass());
        result.setArray(array);
        result.setCompletionTime(new Time(end - start));

        return result;
    }

    public abstract void sort(T[] array, Comparator<T> comparator);

    protected void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
