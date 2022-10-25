package app.algorithms;

import java.util.Comparator;

public class QuickSort<T> implements SortAlgorithm<T> {

    private Comparator<T> comparator;

    private int partition(T[] array, int startIndex, int endIndex) {
        T   pivot = array[startIndex];
        int i     = startIndex;

        for (int j = startIndex + 1; j <= endIndex; j++) {
            if (comparator.compare(array[j], pivot) < 0) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i, startIndex);
        return i;
    }

    private void sort(T[] array, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int pivot = partition(array, startIndex, endIndex);

            sort(array, startIndex, pivot);
            sort(array, pivot + 1, endIndex);
        }
    }

    @Override
    public long sort(T[] array, Comparator<T> comparator) {
        this.comparator = comparator;

        long start = System.currentTimeMillis();
        sort(array, 0, array.length - 1);
        return System.currentTimeMillis() - start;
    }
}
