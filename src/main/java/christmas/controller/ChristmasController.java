package christmas.controller;

import christmas.component.DtoConverter;
import christmas.domain.Order;
import christmas.dto.MenuDto;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.List;

public class ChristmasController {

    private final InputView inputView;
    private final OutputView outputView;
    private final DtoConverter dtoConverter;

    public ChristmasController(final InputView inputView, final OutputView outputView,
                               final DtoConverter dtoConverter) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.dtoConverter = dtoConverter;
    }

    public void run() {
        outputView.printEventIntroduce();
        Order order = inputOrder();
    }

    private Order inputOrder() {
        List<MenuDto> menuDtos = inputView.readMenus();
        Order order = dtoConverter.menuDtosToOrder(menuDtos);
        return order;
    }

}
