package christmas.view;

import christmas.dto.OrderDto;
import christmas.enums.ErrorMessage;
import christmas.exception.CustomException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {
    private static final String MENUS_DELIMITER = ",";
    private static final String MENU_DELIMITER = "-";
    private static final int MENU_NAME_INDEX = 0;
    private static final int MENU_COUNT_INDEX = 1;


    public int parseVisitDay(final String visitDayText) {
        return parseInt(visitDayText, ErrorMessage.VISIT_DAY_INPUT_INVALID);
    }

    public List<OrderDto> parseOrders(final String ordersText) {
        return Arrays.stream(ordersText.split(MENUS_DELIMITER))
                .map(orderText -> parseOrder(orderText))
                .collect(Collectors.toList());
    }

    private OrderDto parseOrder(final String orderText) {
        String[] menu = orderText.split(MENU_DELIMITER);
        String name = menu[MENU_NAME_INDEX];
        int count = parseInt(menu[MENU_COUNT_INDEX], ErrorMessage.ORDER_INVALID);
        return new OrderDto(name, count);
    }

    private int parseInt(final String textNum, final ErrorMessage errorMessage) {
        try {
            return Integer.parseInt(textNum);
        } catch (final NumberFormatException e) {
            throw new CustomException(errorMessage);
        }
    }
}
