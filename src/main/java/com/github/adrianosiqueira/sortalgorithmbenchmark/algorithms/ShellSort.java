package com.github.adrianosiqueira.sortalgorithmbenchmark.algorithms;

import java.util.Comparator;

public class ShellSort<T> extends SortAlgorithm<T> {

    @Override
    public void sort(T[] array, Comparator<T> comparator) {
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i += 1) {
                T   temp = array[i];
                int j;

                for (j = i; j >= gap && comparator.compare(array[j - gap], temp) > 0; j -= gap) {
                    array[j] = array[j - gap];
                }

                array[j] = temp;
            }
        }
    }
}
