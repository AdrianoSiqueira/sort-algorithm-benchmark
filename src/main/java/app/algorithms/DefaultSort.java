package app.algorithms;

import java.util.Arrays;
import java.util.Comparator;

public class DefaultSort<T> implements SortAlgorithm<T> {
    @Override
    public long sort(T[] array, Comparator<T> comparator) {
        long start = System.currentTimeMillis();
        Arrays.sort(array, comparator);
        return System.currentTimeMillis() - start;
    }
}
