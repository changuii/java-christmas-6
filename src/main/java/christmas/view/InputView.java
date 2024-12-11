package christmas.view;

import camp.nextstep.edu.missionutils.Console;

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
        int visitDay = inputParser.parseVisitDay(input);
        inputValidator.validateVisitDay(visitDay);
        return visitDay;
    }

}
