package christmas.view;

import christmas.dto.MenuDto;
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
        print(OutputMessage.EVENT_PREVIEW_INTRODUCE, visitDay);
    }

    private void printOrderMenus(final List<MenuDto> menuDto) {
        print(OutputMessage.ORDER_MENU);
        menuDto.forEach(menu -> print(menu.name()));
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
