package app.model;

import java.util.Comparator;

public enum SortOrder {
    ASCENDING(Comparator.naturalOrder()),
    DESCENDING(Comparator.reverseOrder());

    public final Comparator comparator;

    SortOrder(Comparator<?> comparator) {
        this.comparator = comparator;
    }
}
