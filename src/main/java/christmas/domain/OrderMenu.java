package christmas.domain;

import christmas.enums.ErrorMessage;
import christmas.enums.Menu;
import christmas.exception.CustomException;
import java.util.Objects;

public class OrderMenu {
    private static final int ORDER_COUNT_MIN = 0;
    private final String name;
    private final int count;

    private OrderMenu(final String name, final int count) {
        validateName(name);
        validateCount(count);
        this.name = name;
        this.count = count;
    }

    public static OrderMenu of(final String name, final int count) {
        return new OrderMenu(name, count);
    }

    private void validateCount(final int count) {
        if (count < ORDER_COUNT_MIN) {
            throw new CustomException(ErrorMessage.ORDER_INVALID);
        }
    }

    private void validateName(final String name) {
        if (!Menu.containsName(name)) {
            throw new CustomException(ErrorMessage.ORDER_INVALID);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        OrderMenu orderMenu = (OrderMenu) o;

        if (count != orderMenu.count) {
            return false;
        }
        return Objects.equals(name, orderMenu.name);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + count;
        return result;
    }
}
