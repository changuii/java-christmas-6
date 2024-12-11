package christmas.view;

import christmas.dto.EventDto;
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

    public void printFreeGift(final int isGiveFreeGift) {
        printLineBreak();
        print(OutputMessage.FREE_GIFT);
        if (isGiveFreeGift != 0) {
            print(OutputMessage.FREE_GIFT_NAME);
        } else {
            print(OutputMessage.EMPTY);
        }
    }

    public void printEventResult(final EventDto eventDto) {
        printLineBreak();
        print(OutputMessage.EVENT_RESULT);
        if (eventDto.isEmpty()) {
            print(OutputMessage.EMPTY);
            return;
        }
        printDDayEvent(eventDto.dDay());
        printDayOfTheWeekEvent(eventDto.dayOfTheWeek(), eventDto.isWeekend());
        printSpecialDayEvent(eventDto.specialDiscount());
        printFreeGiftEvent(eventDto.freeGiftDiscount());
    }

    private void printDDayEvent(final int dDayDiscount) {
        print(OutputMessage.D_DAY_EVENT, dDayDiscount);
    }

    private void printDayOfTheWeekEvent(final int dayOfTheWeekDiscount, final boolean isWeekend) {
        if (isWeekend) {
            print(OutputMessage.WEEKEND_DAY_EVENT, dayOfTheWeekDiscount);
            return;
        }
        print(OutputMessage.WEEK_DAYS_EVENT, dayOfTheWeekDiscount);
    }

    private void printSpecialDayEvent(final int specialDiscount) {
        if (specialDiscount != 0) {
            print(OutputMessage.SPECIAL_DAY_EVENT, specialDiscount);
        }
    }

    private void printFreeGiftEvent(final int freeGiftDiscount) {
        if (freeGiftDiscount != 0) {
            print(OutputMessage.FREE_GIFT_EVENT, freeGiftDiscount);
        }
    }

    public void printTotalEventDiscount(final EventDto eventDto){
        printLineBreak();
        print(OutputMessage.TOTAL_EVENT);
        if(eventDto.getTotalDiscount() != 0){
            print(OutputMessage.TOTAL_EVENT_DISCOUNT, eventDto.getTotalDiscount());
            return;
        }
        print(OutputMessage.TOTAL_EVENT_DISCOUNT_EMPTY);
    }

    public void printAppliedEventTotalPrice(final int appliedEventTotalPrice){
        printLineBreak();
        print(OutputMessage.APPLIED_EVENT_TOTAL_PRICE);
        print(OutputMessage.TOTAL_PRICE_FORMAT, appliedEventTotalPrice);
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
