package app.algorithms;

import java.util.Comparator;

public class ShellSort<T> implements SortAlgorithm<T> {

    @Override
    public long sort(T[] array, Comparator<T> comparator) {
        long start = System.currentTimeMillis();

        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i += 1) {
                T   temp = array[i];
                int j;

                for (j = i; j >= gap && comparator.compare(array[j - gap], temp) > 0; j -= gap) {
                    array[j] = array[j - gap];
                }

                array[j] = temp;
            }
        }

        return System.currentTimeMillis() - start;
    }
}
