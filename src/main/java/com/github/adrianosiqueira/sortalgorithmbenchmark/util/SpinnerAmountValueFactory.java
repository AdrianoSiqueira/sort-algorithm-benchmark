package com.github.adrianosiqueira.sortalgorithmbenchmark.util;

import javafx.scene.control.SpinnerValueFactory;

public class SpinnerAmountValueFactory extends SpinnerValueFactory<Integer> {
    private final int max    = 1_000_000;
    private final int min    = 10;
    private final int factor = 10;

    @Override
    public void decrement(int steps) {
        int newValue = getValue() / factor;

        setValue((newValue < min)
                 ? max
                 : newValue);
    }

    @Override
    public void increment(int steps) {
        int newValue = getValue() * factor;

        setValue((newValue > max)
                 ? min
                 : newValue);
    }
}
