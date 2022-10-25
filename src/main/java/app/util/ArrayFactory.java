package app.util;

import java.util.Random;

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

    public static Integer[] getIntegerShuffled(int size) {
        Random    random = new Random();
        Integer[] array  = new Integer[size];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size + 1);
        }

        return array;
    }

    public static String[] getLetterShuffled(int size) {
        String[] array = new String[size];

        for (int i = 0; i < size; i++) {
            array[i] = String.valueOf(getWord(LETTER_DICTIONARY));
        }

        return array;
    }

    public static String[] getLetterNumberShuffled(int size) {
        String[] array = new String[size];

        for (int i = 0; i < size; i++) {
            array[i] = String.valueOf(getWord(LETTER_NUMBER_DICTIONARY));
        }

        return array;
    }

    private static char[] getWord(char[] dictionary) {
        Random random = new Random();
        char[] array  = new char[LENGTH];

        for (int i = 0; i < LENGTH; i++) {
            array[i] = dictionary[random.nextInt(dictionary.length)];
        }

        return array;
    }
}
