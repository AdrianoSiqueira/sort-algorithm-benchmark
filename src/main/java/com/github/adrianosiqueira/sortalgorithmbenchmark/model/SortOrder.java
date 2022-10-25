package com.github.adrianosiqueira.sortalgorithmbenchmark.model;

import java.util.Comparator;

@SuppressWarnings("rawtypes")
public enum SortOrder {
    ASCENDING(Comparator.naturalOrder()),
    DESCENDING(Comparator.reverseOrder());

    private final Comparator comparator;

    SortOrder(Comparator<?> comparator) {
        this.comparator = comparator;
    }

    public Comparator getComparator() {
        return comparator;
    }
}
