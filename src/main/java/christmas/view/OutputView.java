package christmas.view;

import christmas.dto.OrderDto;
import christmas.enums.OutputMessage;
import christmas.exception.CustomException;
import java.util.List;

public class OutputView {

    public void printEventIntroduce() {
        print(OutputMessage.EVENT_INTRODUCE);
    }

    public void printVisitDayInput() {
        print(OutputMessage.VISIT_DAY_INPUT);
    }

    public void printMenusInput() {
        print(OutputMessage.MENUS_INPUT);
    }

    public void printEventPreviewIntroduce(final int visitDay) {
        printLineBreak();
        print(OutputMessage.EVENT_PREVIEW_INTRODUCE, visitDay);
    }

    public void printOrderMenus(final List<OrderDto> orderDto) {
        printLineBreak();
        print(OutputMessage.ORDER_MENU);
        orderDto.forEach(menu -> print(menu.name()));
    }

    public void printTotalPrice(final int totalPrice) {
        printLineBreak();
        print(OutputMessage.TOTAL_PRICE);
        print(OutputMessage.TOTAL_PRICE_FORMAT, totalPrice);
    }

    public void printFreeGift(final boolean isGiveFreeGift) {
        printLineBreak();
        print(OutputMessage.FREE_GIFT);
        if (isGiveFreeGift) {
            print(OutputMessage.FREE_GIFT_NAME);
        } else {
            print(OutputMessage.EMPTY);
        }
    }

    public void printErrorMessage(final CustomException customException) {
        print(customException.getMessage());
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
