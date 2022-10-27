package com.github.adrianosiqueira.sortalgorithmbenchmark.util;

import javafx.util.StringConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class IntegerStringConverterTest {

    private StringConverter<Integer> converter = new IntegerStringConverter();


    private static List<Arguments> getFromStringExceptionTests() {
        return Arrays.asList(
                Arguments.of(null, NumberFormatException.class),
                Arguments.of("", NumberFormatException.class),
                Arguments.of("a", NumberFormatException.class)
        );
    }

    private static List<Arguments> getFromStringResultTests() {
        return Arrays.asList(
                Arguments.of("1", 1),
                Arguments.of("-1", -1),
                Arguments.of("01", 1)
        );
    }

    private static List<Arguments> getToStringResultTests() {
        return Arrays.asList(
                Arguments.of(1, "1"),
                Arguments.of(-1, "-1"),
                Arguments.of(null, "")
        );
    }


    @ParameterizedTest
    @MethodSource(value = "getFromStringResultTests")
    void fromString(String input, Integer output) {
        assertThatCode(() -> converter.fromString(input))
                .doesNotThrowAnyException();

        assertThat(converter.fromString(input))
                .isEqualTo(output);
    }

    @ParameterizedTest
    @MethodSource(value = "getFromStringExceptionTests")
    void fromString(String input, Class<? extends Throwable> exception) {
        assertThatCode(() -> converter.fromString(input))
                .isInstanceOf(exception);
    }

    @ParameterizedTest
    @MethodSource(value = "getToStringResultTests")
    void toString(Integer input, String output) {
        assertThatCode(() -> converter.toString(input))
                .doesNotThrowAnyException();

        assertThat(converter.toString(input))
                .isEqualTo(output);
    }
}
