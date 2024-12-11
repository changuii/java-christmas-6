package christmas.domain;

import christmas.enums.ErrorMessage;
import christmas.exception.CustomException;
import java.time.LocalDate;
import java.util.List;

public class VisitDay {
    private static final int VISIT_DAY_MIN = 1;
    private static final int VISIT_DAY_MAX = 31;
    private static final int CHRISTMAS_D_DAY_START = 1;
    private static final int CHRISTMAS_D_DAY_END = 25;
    private static final int CHRISTMAS_D_DAY_DISCOUNT = 1000;
    private static final int CHRISTMAS_D_DAY_DISCOUNT_PER_DAY = 100;
    private static final int DAY_OF_THE_WEEK_DISCOUNT = 2023;
    private static final int WEEKEND_START = 5;
    private static final int WEEKEND_END = 6;
    private static final int EMPTY_DISCOUNT = 0;
    private static final List<Integer> SPECIAL_DAY_EVENT = List.of(3, 10, 17, 24, 25, 31);
    private static final int SPECIAL_DAY_EVENT_DISCOUNT = 1000;
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
        return EMPTY_DISCOUNT;
    }

    public int calculateWeekDaysEvent(final int dessertCount) {
        if (isWeekDays()) {
            return dessertCount * DAY_OF_THE_WEEK_DISCOUNT;
        }
        return EMPTY_DISCOUNT;
    }

    public int calculateWeekendEvent(final int mainCount) {
        if (isWeekend()) {
            return mainCount * DAY_OF_THE_WEEK_DISCOUNT;
        }
        return EMPTY_DISCOUNT;
    }

    public int calculateSpecialEvent() {
        return SPECIAL_DAY_EVENT_DISCOUNT;
    }

    private boolean isApplicableDDay() {
        return CHRISTMAS_D_DAY_START <= day && day <= CHRISTMAS_D_DAY_END;
    }

    private boolean isWeekDays() {
        int todayOfTheWeek = getDayOfTheWeek();
        return todayOfTheWeek < WEEKEND_START || WEEKEND_END < todayOfTheWeek;
    }

    private boolean isWeekend() {
        int todayOfTheWeek = getDayOfTheWeek();
        return WEEKEND_START <= todayOfTheWeek && todayOfTheWeek <= WEEKEND_END;
    }

    private boolean isSpecialDay() {
        return SPECIAL_DAY_EVENT.contains(day);
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
