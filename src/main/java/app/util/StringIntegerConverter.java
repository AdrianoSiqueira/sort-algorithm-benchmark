package app.util;

import javafx.util.StringConverter;

import java.text.NumberFormat;

public class StringIntegerConverter extends StringConverter<Integer> {

    @Override
    public String toString(Integer integer) {
        return integer != null
               ? NumberFormat.getInstance().format(integer.intValue())
               : "";
    }

    @Override
    public Integer fromString(String string) {
        return Integer.parseInt(string);
    }
}
