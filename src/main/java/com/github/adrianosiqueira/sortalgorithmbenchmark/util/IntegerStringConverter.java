package com.github.adrianosiqueira.sortalgorithmbenchmark.util;

import javafx.util.StringConverter;

import java.text.NumberFormat;
import java.util.Optional;

public class IntegerStringConverter extends StringConverter<Integer> {

    @Override
    public Integer fromString(String string) {
        return Integer.parseInt(string);
    }

    @Override
    public String toString(Integer integer) {
        return Optional.ofNullable(integer)
                       .map(NumberFormat.getInstance()::format)
                       .orElse("");
    }
}
