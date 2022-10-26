package com.github.adrianosiqueira.sortalgorithmbenchmark.util;

import javafx.scene.control.TextFormatter;

import java.util.function.UnaryOperator;

public class TextFormatterChangeValidator implements UnaryOperator<TextFormatter.Change> {

    @Override
    public TextFormatter.Change apply(TextFormatter.Change change) {
        return change.getControlNewText().matches("(-)?\\d+")
               ? change
               : null;
    }
}
