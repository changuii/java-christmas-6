package christmas.controller;

import christmas.component.DtoConverter;
import christmas.domain.Order;
import christmas.domain.VisitDay;
import christmas.dto.EventDto;
import christmas.dto.OrderDto;
import christmas.handler.RetryHandler;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.List;

public class ChristmasController {

    private final InputView inputView;
    private final OutputView outputView;
    private final DtoConverter dtoConverter;
    private final RetryHandler retryHandler;

    public ChristmasController(final InputView inputView, final OutputView outputView,
                               final DtoConverter dtoConverter, final RetryHandler retryHandler) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.dtoConverter = dtoConverter;
        this.retryHandler = retryHandler;
    }

    public void run() {
        outputView.printEventIntroduce();
        VisitDay visitDay = retryHandler.retryUntilNotException(this::inputVisitDay, outputView::printErrorMessage);
        Order order = retryHandler.retryUntilNotException(this::inputOrder, outputView::printErrorMessage);
        outputEventPreview(visitDay, order);
    }

    private void outputEventPreview(final VisitDay visitDay, final Order order) {
        outputView.printEventPreviewIntroduce(visitDay.getVisitDay());
        outputView.printOrderMenus(dtoConverter.orderToOrderDtos(order));
        outputView.printTotalPrice(order.calculateTotalPrice());
        outputView.printFreeGift(order.calculateFreeGiftDiscount());
        outputView.printEventResult(makeEventDto(visitDay, order));
    }

    private EventDto makeEventDto(final VisitDay visitDay, final Order order) {
        return new EventDto(
                visitDay.calculateDDayEvent(),
                calculateDayOfTheWeekDiscount(visitDay, order),
                visitDay.isWeekend(),
                visitDay.calculateSpecialDayEvent(),
                order.calculateFreeGiftDiscount()
        );
    }

    private int calculateDayOfTheWeekDiscount(final VisitDay visitDay, final Order order) {
        if (visitDay.isWeekend()) {
            return visitDay.calculateWeekendEvent(order.getTotalMainCount());
        }
        return visitDay.calculateWeekDaysEvent(order.getTotalDessertCount());
    }

    private VisitDay inputVisitDay() {
        outputView.printVisitDayInput();
        int visitDay = inputView.readVisitDay();
        return VisitDay.from(visitDay);
    }

    private Order inputOrder() {
        outputView.printMenusInput();
        List<OrderDto> orderDtos = inputView.readOrders();
        Order order = dtoConverter.orderDtosToOrder(orderDtos);
        return order;
    }

}
