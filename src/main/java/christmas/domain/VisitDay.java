package christmas.domain;

import christmas.enums.ErrorMessage;
import christmas.exception.CustomException;

public class VisitDay {
    private static final int VISIT_DAY_MIN = 1;
    private static final int VISIT_DAY_MAX = 31;
    private final int day;

    private VisitDay(final int day) {
        validate(day);
        this.day = day;
    }

    public static VisitDay from(final int day) {
        return new VisitDay(day);
    }

    private void validate(final int day) {
        validateVisitDayInRange(day);
    }

    private void validateVisitDayInRange(final int day) {
        if (day < VISIT_DAY_MIN || VISIT_DAY_MAX < day) {
            throw new CustomException(ErrorMessage.VISIT_DAY_INPUT_INVALID);
        }
    }
}
