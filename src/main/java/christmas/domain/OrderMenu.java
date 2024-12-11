package christmas.domain;

import christmas.enums.ErrorMessage;
import christmas.enums.Menu;
import christmas.exception.CustomException;

public class OrderMenu {
    private final String name;
    private final int count;

    private OrderMenu(final String name, final int count) {
        validateName(name);
        this.name = name;
        this.count = count;
    }

    public static OrderMenu of(final String name, final int count) {
        return new OrderMenu(name, count);
    }

    private void validateName(final String name) {
        if (!Menu.containsName(name)) {
            throw new CustomException(ErrorMessage.MENU_INVALID);
        }
    }

    public boolean isDrink() {
        return Menu.isDrink(name);
    }

    public int calculateTotalPrice() {
        return Menu.calculatePrice(name, count);
    }

    public int getCount() {
        return count;
    }
}
