package app.algorithms;

import java.util.Comparator;

public class CocktailSort<T> implements SortAlgorithm<T> {

    @Override
    public long sort(T[] array, Comparator<T> comparator) {
        long start = System.currentTimeMillis();

        boolean swapped    = true;
        int     startIndex = 0;
        int     endIndex   = array.length;

        while (swapped) {
            swapped = false;

            for (int i = startIndex; i < endIndex - 1; ++i) {
                if (comparator.compare(array[i], array[i + 1]) > 0) {
                    swap(array, i, i + 1);
                    swapped = true;
                }
            }

            if (swapped) {
                swapped = false;
                endIndex -= 1;

                for (int i = endIndex - 1; i >= startIndex; i--) {
                    if (comparator.compare(array[i], array[i + 1]) > 0) {
                        swap(array, i, i + 1);
                        swapped = true;
                    }
                }

                startIndex = startIndex + 1;
            }
        }

        return System.currentTimeMillis() - start;
    }
}
