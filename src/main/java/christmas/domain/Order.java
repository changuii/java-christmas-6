package christmas.domain;

import christmas.enums.ErrorMessage;
import christmas.enums.Menu;
import christmas.enums.MenuType;
import christmas.exception.CustomException;
import java.util.Collections;
import java.util.List;

public class Order {
    private static final int ORDER_MENU_COUNT_MAX = 20;
    private static final int FREE_GIFT_PRICE_BOUNDARY = 120_000;
    private static final int FREE_GIFT_DISCOUNT = Menu.calculatePrice("샴페인", 1);
    private static final int FREE_GIFT_EMPTY = 0;
    private static final int EVENT_PRICE_MIN = 10_000;
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

    public int calculateFreeGiftDiscount() {
        if (isApplicableFreeGift() && calculateTotalPrice() >= EVENT_PRICE_MIN) {
            return FREE_GIFT_DISCOUNT;
        }
        return FREE_GIFT_EMPTY;
    }

    private boolean isApplicableFreeGift() {
        return calculateTotalPrice() >= FREE_GIFT_PRICE_BOUNDARY;
    }

    public int getTotalMainCount() {
        return getTotalCountByMenuType(MenuType.MAIN);
    }

    public int getTotalDessertCount() {
        return getTotalCountByMenuType(MenuType.DESSERT);
    }


    private void validate(final List<OrderMenu> orderMenus) {
        validateOrderMenusTotalCountLessThanMax(orderMenus);
        validateOrderMenusNotOnlyDrink(orderMenus);
        validateDuplicationOrderMenus(orderMenus);
    }

    private void validateOrderMenusTotalCountLessThanMax(final List<OrderMenu> orderMenus) {
        if (getTotalCount(orderMenus) > ORDER_MENU_COUNT_MAX) {
            throw new CustomException(ErrorMessage.ORDER_INVALID);
        }
    }

    private void validateOrderMenusNotOnlyDrink(final List<OrderMenu> orderMenus) {
        orderMenus.stream()
                .filter(orderMenu -> !orderMenu.isMenuType(MenuType.DRINK))
                .findAny()
                .orElseThrow(() -> new CustomException(ErrorMessage.ORDER_INVALID));
    }

    private void validateDuplicationOrderMenus(final List<OrderMenu> orderMenus) {
        if (orderMenus.stream().distinct().count() != orderMenus.size()) {
            throw new CustomException(ErrorMessage.ORDER_INVALID);
        }
    }

    private int getTotalCountByMenuType(final MenuType menuType) {
        return orderMenus.stream()
                .filter(orderMenu -> orderMenu.isMenuType(menuType))
                .mapToInt(orderMenu -> orderMenu.getCount())
                .sum();
    }

    private int getTotalCount(final List<OrderMenu> orderMenus) {
        return orderMenus.stream()
                .mapToInt(orderMenu -> orderMenu.getCount())
                .sum();
    }

    public List<OrderMenu> getOrderMenus() {
        return Collections.unmodifiableList(orderMenus);
    }
}
