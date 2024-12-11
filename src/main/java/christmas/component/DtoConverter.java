package christmas.component;

import christmas.domain.Order;
import christmas.domain.OrderMenu;
import christmas.dto.OrderDto;
import java.util.List;
import java.util.stream.Collectors;

public class DtoConverter {

    public Order orderDtosToOrder(final List<OrderDto> orderDtos) {
        return Order.from(orderDtosToOrderMenus(orderDtos));
    }

    public List<OrderDto> orderToOrderDtos(final Order order) {
        return order.getOrderMenus().stream()
                .map(this::orderMenuToOrderDto)
                .collect(Collectors.toList());
    }

    private List<OrderMenu> orderDtosToOrderMenus(final List<OrderDto> orderDtos) {
        return orderDtos.stream()
                .map(menu -> OrderMenu.of(menu.name(), menu.count()))
                .collect(Collectors.toList());
    }

    private OrderDto orderMenuToOrderDto(final OrderMenu orderMenu) {
        return new OrderDto(orderMenu.getName(), orderMenu.getCount());
    }

}
