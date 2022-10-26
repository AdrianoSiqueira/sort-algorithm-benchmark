package com.github.adrianosiqueira.sortalgorithmbenchmark.util;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class ArrayFactory {

    private static final int LENGTH = 5;

    private static final char[] LETTER_DICTIONARY = new char[]{
            'A', 'B', 'C', 'D', 'E', 'F',
            'G', 'H', 'I', 'J', 'K', 'L',
            'M', 'N', 'O', 'P', 'Q', 'R',
            'S', 'T', 'U', 'V', 'W', 'X',
            'Y', 'Z'
    };

    private static final char[] LETTER_NUMBER_DICTIONARY = new char[]{
            'A', 'B', 'C', 'D', 'E', 'F',
            'G', 'H', 'I', 'J', 'K', 'L',
            'M', 'N', 'O', 'P', 'Q', 'R',
            'S', 'T', 'U', 'V', 'W', 'X',
            'Y', 'Z', '0', '1', '2', '3',
            '4', '5', '6', '7', '8', '9'
    };

    public static String[] getAlphabeticShuffled(int size) {
        return Stream.generate(() -> getWord(LETTER_DICTIONARY))
                     .limit(size)
                     .toArray(String[]::new);
    }

    public static String[] getAlphanumericShuffled(int size) {
        return Stream.generate(() -> getWord(LETTER_NUMBER_DICTIONARY))
                     .limit(size)
                     .toArray(String[]::new);
    }

    public static Integer[] getNumericShuffled(int size) {
        ThreadLocalRandom random = ThreadLocalRandom.current();

        return Stream.generate(() -> random.nextInt(size + 1))
                     .limit(size)
                     .toArray(Integer[]::new);
    }

    private static String getWord(char[] dictionary) {
        ThreadLocalRandom random = ThreadLocalRandom.current();

        return Stream.generate(() -> random.nextInt(dictionary.length))
                     .limit(LENGTH)
                     .map(i -> dictionary[i])
                     .map(String::valueOf)
                     .reduce(String::concat)
                     .orElse("");
    }
}
