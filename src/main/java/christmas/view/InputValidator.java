package christmas.view;

import christmas.enums.ErrorMessage;
import christmas.exception.CustomException;
import java.util.regex.Pattern;

public class InputValidator {
    private static final String VISIT_DAY_REGEX = "^[0-9]{1,2}$";
    private static final Pattern VISIT_DAY_PATTERN = Pattern.compile(VISIT_DAY_REGEX);
    private static final String ORDERS_REGEX = "^([가-힣]*[-][0-9]{1,2},)*([가-힣]*[-][0-9]{1,2})$";
    private static final Pattern ORDERS_PATTERN = Pattern.compile(ORDERS_REGEX);

    public void validateVisitDayText(final String visitDay) {
        if (!VISIT_DAY_PATTERN.matcher(visitDay).matches()) {
            throw new CustomException(ErrorMessage.VISIT_DAY_INPUT_INVALID);
        }
    }

    public void validateOrderText(final String menus) {
        if (!ORDERS_PATTERN.matcher(menus).matches()) {
            throw new CustomException(ErrorMessage.ORDER_INVALID);
        }
    }

}
