package com.github.adrianosiqueira.sortalgorithmbenchmark.algorithms;

import java.util.Comparator;

public class InsertionSort<T> extends SortAlgorithm<T> {

    @Override
    public void sort(T[] array, Comparator<T> comparator) {
        for (int i = 1; i < array.length; ++i) {
            T   key = array[i];
            int j   = i - 1;

            while (j >= 0 && comparator.compare(array[j], key) > 0) {
                array[j + 1] = array[j];
                j            = j - 1;
            }

            array[j + 1] = key;
        }
    }
}
