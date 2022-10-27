package com.github.adrianosiqueira.sortalgorithmbenchmark.algorithms;

import com.github.adrianosiqueira.sortalgorithmbenchmark.model.Result;
import com.github.adrianosiqueira.sortalgorithmbenchmark.model.SortOrder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SortAlgorithmTest {

    private static List<Arguments> getBenchmarkTests() {
        return Arrays.asList(
                Arguments.of(new Integer[]{3, 2, 1}, SortOrder.ASCENDING, new BubbleSort<>()),
                Arguments.of(new Integer[]{3, 2, 1}, SortOrder.ASCENDING, new CocktailSort<>()),
                Arguments.of(new Integer[]{3, 2, 1}, SortOrder.ASCENDING, new CombSort<>()),
                Arguments.of(new Integer[]{3, 2, 1}, SortOrder.ASCENDING, new CycleSort<>()),
                Arguments.of(new Integer[]{3, 2, 1}, SortOrder.ASCENDING, new DefaultSort<>()),
                Arguments.of(new Integer[]{3, 2, 1}, SortOrder.ASCENDING, new HeapSort<>()),
                Arguments.of(new Integer[]{3, 2, 1}, SortOrder.ASCENDING, new InsertionSort<>()),
                Arguments.of(new Integer[]{3, 2, 1}, SortOrder.ASCENDING, new MergeSort<>()),
                Arguments.of(new Integer[]{3, 2, 1}, SortOrder.ASCENDING, new QuickSort<>()),
                Arguments.of(new Integer[]{3, 2, 1}, SortOrder.ASCENDING, new SelectionSort<>()),
                Arguments.of(new Integer[]{3, 2, 1}, SortOrder.ASCENDING, new ShellSort<>()),
                Arguments.of(new Integer[]{3, 2, 1}, SortOrder.ASCENDING, new TreeSort<>())
        );
    }

    private static List<Arguments> getSortTests() {
        return Arrays.asList(
                Arguments.of(new Integer[]{3, 2, 1}, new Integer[]{1, 2, 3}, SortOrder.ASCENDING, new BubbleSort<>()),
                Arguments.of(new Integer[]{3, 2, 1}, new Integer[]{1, 2, 3}, SortOrder.ASCENDING, new CocktailSort<>()),
                Arguments.of(new Integer[]{3, 2, 1}, new Integer[]{1, 2, 3}, SortOrder.ASCENDING, new CombSort<>()),
                Arguments.of(new Integer[]{3, 2, 1}, new Integer[]{1, 2, 3}, SortOrder.ASCENDING, new CycleSort<>()),
                Arguments.of(new Integer[]{3, 2, 1}, new Integer[]{1, 2, 3}, SortOrder.ASCENDING, new DefaultSort<>()),
                Arguments.of(new Integer[]{3, 2, 1}, new Integer[]{1, 2, 3}, SortOrder.ASCENDING, new HeapSort<>()),
                Arguments.of(new Integer[]{3, 2, 1}, new Integer[]{1, 2, 3}, SortOrder.ASCENDING, new InsertionSort<>()),
                Arguments.of(new Integer[]{3, 2, 1}, new Integer[]{1, 2, 3}, SortOrder.ASCENDING, new MergeSort<>()),
                Arguments.of(new Integer[]{3, 2, 1}, new Integer[]{1, 2, 3}, SortOrder.ASCENDING, new QuickSort<>()),
                Arguments.of(new Integer[]{3, 2, 1}, new Integer[]{1, 2, 3}, SortOrder.ASCENDING, new SelectionSort<>()),
                Arguments.of(new Integer[]{3, 2, 1}, new Integer[]{1, 2, 3}, SortOrder.ASCENDING, new ShellSort<>()),
                Arguments.of(new Integer[]{3, 2, 1}, new Integer[]{1, 2, 3}, SortOrder.ASCENDING, new TreeSort<>())
        );
    }

    @SuppressWarnings("unchecked")
    @ParameterizedTest
    @MethodSource(value = "getBenchmarkTests")
    <T> void benchmark(T[] array, SortOrder order, SortAlgorithm<T> algorithm) {
        Result result = algorithm.benchmark(array, order.getComparator());

        assertThat(result)
                .isNotNull()
                .hasNoNullFieldsOrProperties();
    }

    @Test
    void getAlgorithms() {
        assertThat(SortAlgorithm.getAlgorithms())
                .isNotNull()
                .isNotEmpty()
                .doesNotContainNull();
    }

    @SuppressWarnings("unchecked")
    @ParameterizedTest
    @MethodSource(value = "getSortTests")
    <T> void sort(T[] input, T[] output, SortOrder order, SortAlgorithm<T> algorithm) {
        algorithm.sort(input, order.getComparator());

        assertThat(input)
                .isEqualTo(output)
                .isSortedAccordingTo(order.getComparator());
    }
}
