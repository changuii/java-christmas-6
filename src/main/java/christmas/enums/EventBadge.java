package christmas.enums;

import java.util.Arrays;
import java.util.function.Predicate;

public enum EventBadge {
    SANTA("산타", 20_000),
    TREE("트리", 10_000),
    STAR("별", 5_000),
    EMPTY("없음", 0);
    private final String name;
    private final int boundary;

    EventBadge(final String name, final int boundary) {
        this.name = name;
        this.boundary = boundary;
    }

    public static EventBadge matchBadge(final int eventDiscount) {
        return Arrays.stream(values())
                .filter(eventBadge -> eventDiscount >= eventBadge.boundary)
                .findFirst()
                .orElse(EMPTY);
    }

    @Override
    public String toString() {
        return name;
    }
}
