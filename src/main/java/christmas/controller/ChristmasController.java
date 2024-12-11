package christmas.controller;

import christmas.component.DtoConverter;
import christmas.domain.Order;
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
        int visitDay = retryHandler.retryUntilNotException(this::inputVisitDay, outputView::printErrorMessage);
        Order order = retryHandler.retryUntilNotException(this::inputOrder, outputView::printErrorMessage);
    }

    private int inputVisitDay() {
        outputView.printVisitDayInput();
        return inputView.readVisitDay();
    }

    private Order inputOrder() {
        outputView.printMenusInput();
        List<OrderDto> orderDtos = inputView.readOrders();
        Order order = dtoConverter.orderDtosToOrder(orderDtos);
        return order;
    }

}
