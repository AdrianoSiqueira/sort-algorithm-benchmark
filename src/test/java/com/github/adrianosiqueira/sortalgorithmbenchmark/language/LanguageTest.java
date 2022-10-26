package com.github.adrianosiqueira.sortalgorithmbenchmark.language;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ResourceBundle;

import static org.assertj.core.api.Assertions.assertThatCode;

class LanguageTest {

    @Test
    @DisplayName(value = "Load properties file")
    void fileLoads() {
        String baseName = "com/github/adrianosiqueira/sortalgorithmbenchmark/language/Language";

        assertThatCode(() -> ResourceBundle.getBundle(baseName))
                .doesNotThrowAnyException();
    }
}
