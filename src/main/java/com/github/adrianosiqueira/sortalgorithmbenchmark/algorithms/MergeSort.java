package com.github.adrianosiqueira.sortalgorithmbenchmark.algorithms;

import java.util.Comparator;

@SuppressWarnings("unchecked")
public class MergeSort<T> extends SortAlgorithm<T> {

    private Comparator<T> comparator;

    @Override
    public void sort(T[] array, Comparator<T> comparator) {
        this.comparator = comparator;

        sort(array, 0, array.length - 1);
    }

    private void merge(T[] array, int startIndex, int middleIndex, int endIndex) {
        int sizeLeft  = middleIndex - startIndex + 1;
        int sizeRight = endIndex - middleIndex;

        Object[] left  = new Object[sizeLeft];
        Object[] right = new Object[sizeRight];

        System.arraycopy(array, startIndex, left, 0, sizeLeft);
        System.arraycopy(array, middleIndex + 1, right, 0, sizeRight);

        int indexLeft  = 0;
        int indexRight = 0;
        int indexArray = startIndex;

        while (indexLeft < sizeLeft && indexRight < sizeRight) {
            if (comparator.compare((T) left[indexLeft], (T) right[indexRight]) <= 0) {
                array[indexArray] = (T) left[indexLeft];
                indexLeft++;
            } else {
                array[indexArray] = (T) right[indexRight];
                indexRight++;
            }

            indexArray++;
        }

        while (indexLeft < sizeLeft) {
            array[indexArray] = (T) left[indexLeft];
            indexLeft++;
            indexArray++;
        }

        while (indexRight < sizeRight) {
            array[indexArray] = (T) right[indexRight];
            indexRight++;
            indexArray++;
        }
    }

    private void sort(T[] array, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int middleIndex = (startIndex + endIndex) / 2;

            sort(array, startIndex, middleIndex);
            sort(array, middleIndex + 1, endIndex);

            merge(array, startIndex, middleIndex, endIndex);
        }
    }
}
