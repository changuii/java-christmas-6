package christmas;

import christmas.config.ChristmasConfig;
import christmas.controller.ChristmasController;

public class Application {
    public static void main(String[] args) {
        ChristmasController christmasController = ChristmasConfig.createController();
        christmasController.run();
    }
}
