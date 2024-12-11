package christmas.domain;

import christmas.enums.ErrorMessage;
import christmas.exception.CustomException;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class VisitDay {
    private static final int VISIT_DAY_MIN = 1;
    private static final int VISIT_DAY_MAX = 31;
    private static final int CHRISTMAS_D_DAY_START = 1;
    private static final int CHRISTMAS_D_DAY_END = 25;
    private static final int CHRISTMAS_D_DAY_DISCOUNT = 1000;
    private static final int CHRISTMAS_D_DAY_DISCOUNT_PER_DAY = 100;
    private static final int WEEK_DAYS_DISCOUNT = 2023;
    private static final int WEEKEND_START = 5;
    private static final int WEEKEND_END = 6;
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

    public int calculateDDayEvent() {
        if (isApplicableDDay()) {
            return CHRISTMAS_D_DAY_DISCOUNT + (CHRISTMAS_D_DAY_DISCOUNT_PER_DAY * (day - CHRISTMAS_D_DAY_START));
        }
        return 0;
    }

    public int calculateWeekDaysEvent(final int dessertCount) {
        if (isWeekDays()) {
            return dessertCount * WEEK_DAYS_DISCOUNT;
        }
        return 0;
    }

    private boolean isApplicableDDay() {
        return CHRISTMAS_D_DAY_START <= day && day <= CHRISTMAS_D_DAY_END;
    }

    private boolean isWeekDays() {
        int todayOfTheWeek = getDayOfTheWeek();
        return todayOfTheWeek < WEEKEND_START || WEEKEND_END < todayOfTheWeek;
    }

    private int getDayOfTheWeek() {
        return LocalDate.of(2023, 12, day)
                .getDayOfWeek()
                .getValue();
    }

    public int getVisitDay() {
        return day;
    }
}
