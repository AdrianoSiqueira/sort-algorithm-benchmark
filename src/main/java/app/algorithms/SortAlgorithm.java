package app.algorithms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public interface SortAlgorithm<T> {

    long sort(T[] array, Comparator<T> comparator);

    default void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    static <T> List<SortAlgorithm<T>> getSortableList(){
        return Arrays.asList(new BubbleSort<>(),
                             new CocktailSort<>(),
                             new CombSort<>(),
//                             new CycleSort<>(),
                             new DefaultSort<>(),
                             new HeapSort<>(),
                             new InsertionSort<>(),
                             new MergeSort<>(),
                             new QuickSort<>(),
                             new SelectionSort<>(),
                             new ShellSort<>(),
                             new TreeSort<>());
    }
}
