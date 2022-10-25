package app.algorithms;

import java.util.Comparator;

public class InsertionSort<T> implements SortAlgorithm<T> {

    @Override
    public long sort(T[] array, Comparator<T> comparator) {
        long start = System.currentTimeMillis();

        for (int i = 1; i < array.length; ++i) {
            T   key = array[i];
            int j   = i - 1;

            while (j >= 0 && comparator.compare(array[j], key) > 0) {
                array[j + 1] = array[j];
                j            = j - 1;
            }

            array[j + 1] = key;
        }

        return System.currentTimeMillis() - start;
    }
}
