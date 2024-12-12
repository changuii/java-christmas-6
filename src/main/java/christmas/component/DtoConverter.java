package christmas.component;

import christmas.domain.Order;
import christmas.domain.OrderMenu;
import christmas.domain.VisitDay;
import christmas.dto.EventDto;
import christmas.dto.OrderDto;
import christmas.dto.OrderVisitDto;
import java.util.List;
import java.util.stream.Collectors;

public class DtoConverter {

    public Order orderDtosToOrder(final List<OrderDto> orderDtos) {
        return Order.from(orderDtosToOrderMenus(orderDtos));
    }

    public OrderVisitDto convertToOrderVisitDto(final Order order, final VisitDay visitDay) {
        return new OrderVisitDto(
                visitDay.getVisitDay(),
                orderToOrderDtos(order),
                order.calculateTotalPrice()
        );
    }

    private List<OrderDto> orderToOrderDtos(final Order order) {
        return order.getOrderMenus().stream()
                .map(this::orderMenuToOrderDto)
                .collect(Collectors.toList());
    }

    public EventDto convertToEvnetDto(final Order order, final VisitDay visitDay) {
        return new EventDto(
                visitDay.calculateDDayEvent(),
                calculateDayOfTheWeekDiscount(visitDay, order),
                visitDay.isWeekend(),
                visitDay.calculateSpecialDayEvent(),
                order.calculateFreeGiftDiscount(),
                order.calculateTotalPrice()
        );
    }

    private int calculateDayOfTheWeekDiscount(final VisitDay visitDay, final Order order) {
        if (visitDay.isWeekend()) {
            return visitDay.calculateWeekendEvent(order.getTotalMainCount());
        }
        return visitDay.calculateWeekDaysEvent(order.getTotalDessertCount());
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
