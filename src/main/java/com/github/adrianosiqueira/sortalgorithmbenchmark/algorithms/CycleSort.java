package com.github.adrianosiqueira.sortalgorithmbenchmark.algorithms;

import java.util.Comparator;

public class CycleSort<T> extends SortAlgorithm<T> {

    @Override
    public void sort(T[] array, Comparator<T> comparator) {
        for (int cycle_start = 0; cycle_start < array.length - 1; cycle_start++) {
            T   item = array[cycle_start];
            int pos  = cycle_start;

            for (int i = cycle_start + 1; i < array.length; i++) {
                if (comparator.compare(array[i], item) < 0) {
                    pos++;
                }
            }

            if (pos == cycle_start) {
                continue;
            }

            while (item == array[pos]) {
                pos++;
            }

            if (pos != cycle_start) {
                T temp = item;
                item       = array[pos];
                array[pos] = temp;
            }

            while (pos != cycle_start) {
                pos = cycle_start;

                for (int i = cycle_start + 1; i < array.length; i++) {
                    if (comparator.compare(array[i], item) < 0) {
                        pos++;
                    }
                }

                while (item == array[pos]) {
                    pos++;
                }

                if (item != array[pos]) {
                    T temp = item;
                    item       = array[pos];
                    array[pos] = temp;
                }
            }
        }
    }
}
