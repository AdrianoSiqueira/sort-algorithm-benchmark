package com.github.adrianosiqueira.sortalgorithmbenchmark.language;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ResourceBundle;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LanguageTest {

    @Test
    @DisplayName(value = "Load properties file")
    void fileLoads() {
        assertThatThrownBy(() -> ResourceBundle.getBundle("com/github/adrianosiqueira/sortalgorithmbenchmark/language/Language"))
                .doesNotThrowAnyException();
    }
}
