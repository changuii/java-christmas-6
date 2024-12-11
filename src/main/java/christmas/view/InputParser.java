package christmas.view;

import christmas.enums.ErrorMessage;
import christmas.exception.CustomException;

public class InputParser {
    public int parseVisitDay(final String visitDayText) {
        try {
            return Integer.parseInt(visitDayText);
        } catch (NumberFormatException e) {
            throw new CustomException(ErrorMessage.VISIT_DAY_INPUT_INVALID);
        }
    }
}
