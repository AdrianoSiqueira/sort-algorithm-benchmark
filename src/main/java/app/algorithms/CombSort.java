package app.algorithms;

import java.util.Comparator;

public class CombSort<T> implements SortAlgorithm<T> {

    private int getNextGap(int gap) {
        gap = (gap * 10) / 13;
        return Math.max(gap, 1);
    }

    @Override
    public long sort(T[] array, Comparator<T> comparator) {
        long start = System.currentTimeMillis();

        int     gap     = array.length;
        boolean swapped = true;

        while (gap != 1 || swapped) {
            gap     = getNextGap(gap);
            swapped = false;

            for (int i = 0; i < array.length - gap; i++) {
                if (comparator.compare(array[i], array[i + gap]) > 0) {
                    swap(array, i, i + gap);
                    swapped = true;
                }
            }
        }

        return System.currentTimeMillis() - start;
    }
}
