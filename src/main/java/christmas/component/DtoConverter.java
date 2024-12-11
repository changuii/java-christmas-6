package christmas.component;

import christmas.domain.Order;
import christmas.domain.OrderMenu;
import christmas.dto.MenuDto;
import java.util.List;
import java.util.stream.Collectors;

public class DtoConverter {

    public Order menuDtosToOrder(final List<MenuDto> menuDtos) {
        return Order.from(menuDtosToOrderMenus(menuDtos));
    }

    private List<OrderMenu> menuDtosToOrderMenus(final List<MenuDto> menuDtos) {
        return menuDtos.stream()
                .map(menu -> OrderMenu.of(menu.name(), menu.count()))
                .collect(Collectors.toList());
    }
}
