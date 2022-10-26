package com.github.adrianosiqueira.sortalgorithmbenchmark.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class ArrayFactoryTest {

    private static List<Arguments> getTests() {
        return Arrays.asList(
                Arguments.of(5, ArrayFactory.getAlphabeticShuffled(5)),
                Arguments.of(5, ArrayFactory.getAlphanumericShuffled(5)),
                Arguments.of(5, ArrayFactory.getNumericShuffled(5))
        );
    }

    @ParameterizedTest
    @MethodSource(value = "getTests")
    @DisplayName(value = "Returns the right amount of elements")
    void test(int size, Object[] array) {
        assertThat(array).hasSize(size);
    }
}
