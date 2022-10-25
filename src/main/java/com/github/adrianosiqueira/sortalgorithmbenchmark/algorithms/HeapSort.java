package com.github.adrianosiqueira.sortalgorithmbenchmark.algorithms;

import java.util.Comparator;

public class HeapSort<T> extends SortAlgorithm<T> {

    private Comparator<T> comparator;

    @Override
    public void sort(T[] array, Comparator<T> comparator) {
        this.comparator = comparator;

        for (int i = array.length / 2 - 1; i >= 0; i--) {
            heapify(array, array.length, i);
        }

        for (int i = array.length - 1; i > 0; i--) {
            swap(array, 0, i);
            heapify(array, i, 0);
        }
    }

    private void heapify(T[] array, int size, int rootIndex) {
        int largestIndex = rootIndex;
        int l            = 2 * rootIndex + 1;
        int r            = 2 * rootIndex + 2;

        if (l < size && comparator.compare(array[l], array[largestIndex]) > 0) {
            largestIndex = l;
        }

        if (r < size && comparator.compare(array[r], array[largestIndex]) > 0) {
            largestIndex = r;
        }

        if (largestIndex != rootIndex) {
            swap(array, rootIndex, largestIndex);
            heapify(array, size, largestIndex);
        }
    }
}
