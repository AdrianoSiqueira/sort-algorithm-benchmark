package app.algorithms;

import java.util.Comparator;

public class BubbleSort<T> implements SortAlgorithm<T> {

    @Override
    public long sort(T[] array, Comparator<T> comparator) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (comparator.compare(array[i], array[j]) > 0) {
                    swap(array, i, j);
                }
            }
        }

        return System.currentTimeMillis() - start;
    }
}
