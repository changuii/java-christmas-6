package christmas.config;

import christmas.controller.ChristmasController;
import christmas.view.InputParser;
import christmas.view.InputValidator;
import christmas.view.InputView;

public abstract class ChristmasConfig {

    public static ChristmasController createController() {
        return new ChristmasController(createInputView());
    }

    private static InputView createInputView() {
        return new InputView(new InputParser(), new InputValidator());
    }
}
