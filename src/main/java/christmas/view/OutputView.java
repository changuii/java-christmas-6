package christmas.view;

import christmas.enums.OutputMessage;

public class OutputView {

    public void printEventIntroduce() {
        print(OutputMessage.EVENT_INTRODUCE);
    }

    public void printVisitDayInput() {
        print(OutputMessage.VISIT_DAY_INPUT);
    }

    private void print(final Object message, final Object... values) {
        System.out.println(formatMessage(message.toString(), values));
    }

    private String formatMessage(final Object formatMessage, final Object... values) {
        return String.format(formatMessage.toString(), values);
    }

    private void printLineBreak() {
        System.out.print(System.lineSeparator());
    }
}