package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.dto.OrderDto;
import java.util.List;

public class InputView {

    private final InputParser inputParser;
    private final InputValidator inputValidator;

    public InputView(final InputParser inputParser, final InputValidator inputValidator) {
        this.inputParser = inputParser;
        this.inputValidator = inputValidator;
    }

    public int readVisitDay() {
        String input = Console.readLine();
        inputValidator.validateVisitDayText(input);
        return inputParser.parseVisitDay(input);
    }

    public List<OrderDto> readOrders() {
        String input = Console.readLine();
        inputValidator.validateOrderText(input);
        return inputParser.parseOrders(input);
    }

}
