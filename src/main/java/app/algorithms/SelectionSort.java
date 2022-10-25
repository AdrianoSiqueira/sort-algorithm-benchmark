package app.algorithms;

import java.util.Comparator;

public class SelectionSort<T> implements SortAlgorithm<T> {

    @Override
    public long sort(T[] array, Comparator<T> comparator) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < array.length; j++) {
                if (comparator.compare(array[j], array[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            swap(array, i, minIndex);
        }

        return System.currentTimeMillis() - start;
    }
}
