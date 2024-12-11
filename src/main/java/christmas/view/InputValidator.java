package christmas.view;

import christmas.dto.OrderDto;
import christmas.enums.ErrorMessage;
import christmas.enums.Menu;
import christmas.exception.CustomException;
import java.util.List;
import java.util.regex.Pattern;

public class InputValidator {
    private static final String VISIT_DAY_REGEX = "^[0-9]{1,2}$";
    private static final Pattern VISIT_DAY_PATTERN = Pattern.compile(VISIT_DAY_REGEX);
    private static final int VISIT_DAY_RANGE_MIN = 1;
    private static final int VISIT_DAY_RANGE_MAX = 31;
    private static final String ORDERS_REGEX = "^([가-힣]*[-][0-9]{1,2},)*([가-힣]*[-][0-9]{1,2})$";
    private static final Pattern ORDERS_PATTERN = Pattern.compile(ORDERS_REGEX);
    private static final int ORDER_COUNT_MIN = 1;
    private static final int ORDER_COUNT_MAX = 20;

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

    public void validateOrderText(final String menus) {
        if (!ORDERS_PATTERN.matcher(menus).matches()) {
            throw new CustomException(ErrorMessage.MENU_INVALID);
        }
    }

    public void validateOrders(final List<OrderDto> orderDtos) {
        orderDtos.forEach(menu -> {
            validateMenuCount(menu);
            validateOrderContainsMenu(menu);
        });

        validateDuplicationMenu(orderDtos);
        validateMenusTotalCountLessThanMax(orderDtos);
        validateMenusContainsNotDrink(orderDtos);
    }

    private void validateMenuCount(final OrderDto orderDto) {
        if (orderDto.count() < ORDER_COUNT_MIN) {
            throw new CustomException(ErrorMessage.MENU_INVALID);
        }
    }

    private void validateDuplicationMenu(final List<OrderDto> orderDtos) {
        if (orderDtos.stream().map(menu -> menu.name()).count() != orderDtos.size()) {
            throw new CustomException(ErrorMessage.MENU_INVALID);
        }
    }

    private void validateMenusTotalCountLessThanMax(final List<OrderDto> orderDtos) {
        if (orderDtos.stream().mapToInt(menu -> menu.count()).sum() > ORDER_COUNT_MAX) {
            throw new CustomException(ErrorMessage.MENU_INVALID);
        }
    }

    private void validateMenusContainsNotDrink(final List<OrderDto> orderDtos) {
        orderDtos.stream()
                .filter(menu -> !Menu.isDrink(menu.name()))
                .findAny()
                .orElseThrow(() -> new CustomException(ErrorMessage.MENU_INVALID));
    }

    private void validateOrderContainsMenu(final OrderDto orderDto) {
        if (!Menu.containsName(orderDto.name())) {
            throw new CustomException(ErrorMessage.MENU_INVALID);
        }
    }

}
