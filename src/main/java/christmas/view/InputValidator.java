package christmas.view;

import christmas.enums.ErrorMessage;
import christmas.exception.CustomException;
import java.util.regex.Pattern;

public class InputValidator {
    private static final String VISIT_DAY_REGEX = "^[0-9]{1,2}$";
    private static final Pattern VISIT_DAY_PATTERN = Pattern.compile(VISIT_DAY_REGEX);
    private static final int VISIT_DAY_RANGE_MIN = 1;
    private static final int VISIT_DAY_RANGE_MAX = 31;

    public void validateVisitDayText(final String visitDay) {
        if (!VISIT_DAY_PATTERN.matcher(visitDay).matches()) {
            throw new CustomException(ErrorMessage.VISIT_DAY_INPUT_INVALID);
        }
    }

    public void validateVisitDay(final int visitDay) {
        if (visitDay < VISIT_DAY_RANGE_MIN || visitDay > VISIT_DAY_RANGE_MAX) {
            throw new CustomException(ErrorMessage.VISIT_DAY_INPUT_INVALID);
        }
    }
}
