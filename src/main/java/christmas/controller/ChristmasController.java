package christmas.controller;

import christmas.component.DtoConverter;
import christmas.domain.Order;
import christmas.domain.VisitDay;
import christmas.dto.EventDto;
import christmas.dto.OrderDto;
import christmas.dto.OrderVisitDto;
import christmas.enums.EventBadge;
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
        EventDto eventDto = handleNotApplicableEvent(dtoConverter.convertToEvnetDto(order, visitDay));
        outputOrderVisit(dtoConverter.convertToOrderVisitDto(order, visitDay));
        outputEventPreview(eventDto);
    }

    private void outputOrderVisit(final OrderVisitDto orderVisitDto) {
        outputView.printOrderVisit(orderVisitDto);
    }

    private void outputEventPreview(final EventDto eventDto) {
        outputView.printEvent(eventDto);
        outputView.printAppliedEventTotalPrice(eventDto);
        outputView.printEventBadge(EventBadge.matchBadge(eventDto.getTotalDiscount()));
    }

    private EventDto handleNotApplicableEvent(final EventDto eventDto) {
        if (eventDto.totalPrice() >= 10_000) {
            return eventDto;
        }
        return EventDto.empty(eventDto.totalPrice());
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
