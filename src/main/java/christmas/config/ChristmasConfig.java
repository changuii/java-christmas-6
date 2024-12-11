package christmas.config;

import christmas.component.DtoConverter;
import christmas.controller.ChristmasController;
import christmas.view.InputParser;
import christmas.view.InputValidator;
import christmas.view.InputView;
import christmas.view.OutputView;

public abstract class ChristmasConfig {

    public static ChristmasController createController() {
        return new ChristmasController(createInputView(), new OutputView(), new DtoConverter());
    }

    private static InputView createInputView() {
        return new InputView(new InputParser(), new InputValidator());
    }
}
