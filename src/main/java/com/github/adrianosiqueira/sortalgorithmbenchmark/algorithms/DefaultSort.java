package com.github.adrianosiqueira.sortalgorithmbenchmark.algorithms;

import java.util.Arrays;
import java.util.Comparator;

public class DefaultSort<T> extends SortAlgorithm<T> {

    @Override
    public void sort(T[] array, Comparator<T> comparator) {
        Arrays.sort(array, comparator);
    }
}
