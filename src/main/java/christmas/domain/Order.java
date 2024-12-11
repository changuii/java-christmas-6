package christmas.domain;

import christmas.enums.ErrorMessage;
import christmas.exception.CustomException;
import java.util.List;

public class Order {
    private static final int ORDER_MENU_COUNT_MAX = 20;
    private final List<OrderMenu> orderMenus;

    private Order(final List<OrderMenu> orderMenus) {
        validate(orderMenus);
        this.orderMenus = orderMenus;
    }

    public static Order from(final List<OrderMenu> orderMenus) {
        return new Order(orderMenus);
    }

    public int calculateTotalPrice() {
        return orderMenus.stream()
                .mapToInt(orderMenu -> orderMenu.calculateTotalPrice())
                .sum();
    }


    private void validate(final List<OrderMenu> orderMenus) {
        validateOrderMenusTotalCountLessThanMax(orderMenus);
        validateOrderMenusNotOnlyDrink(orderMenus);
    }

    private void validateOrderMenusTotalCountLessThanMax(final List<OrderMenu> orderMenus) {
        if (getTotalCount(orderMenus) > ORDER_MENU_COUNT_MAX) {
            throw new CustomException(ErrorMessage.MENU_INVALID);
        }
    }

    private void validateOrderMenusNotOnlyDrink(final List<OrderMenu> orderMenus) {
        orderMenus.stream()
                .filter(orderMenu -> !orderMenu.isDrink())
                .findAny()
                .orElseThrow(() -> new CustomException(ErrorMessage.MENU_INVALID));
    }

    private int getTotalCount(final List<OrderMenu> orderMenus) {
        return orderMenus.stream()
                .mapToInt(orderMenu -> orderMenu.getCount())
                .sum();
    }
}
