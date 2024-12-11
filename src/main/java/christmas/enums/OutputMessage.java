package christmas.enums;

public enum OutputMessage {

    EVENT_INTRODUCE("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),

    VISIT_DAY_INPUT("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    MENUS_INPUT("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),

    EVENT_PREVIEW_INTRODUCE("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),

    ORDER_MENU("<주문 메뉴>"),
    TOTAL_PRICE("<할인 전 총주문 금액>"),
    TOTAL_PRICE_FORMAT("%,d원"),
    FREE_GIFT("<증정 메뉴>"),
    FREE_GIFT_NAME("샴페인 1개"),
    EVENT_RESULT("<혜택 내역>"),
    D_DAY_EVENT("크리스마스 디데이 할인: -%,d원"),
    WEEK_DAYS_EVENT("평일 할인: -%,d원"),
    WEEKEND_DAY_EVENT("주말 할인: -%,d원"),
    SPECIAL_DAY_EVENT("특별 할인: -%,d원"),
    FREE_GIFT_EVENT("증정 이벤트: -%,d원"),
    TOTAL_EVENT("<총혜택 금액>"),
    TOTAL_EVENT_DISCOUNT("-%,d원"),
    TOTAL_EVENT_DISCOUNT_EMPTY("0원"),
    EMPTY("없음");
    private final String message;

    OutputMessage(final String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}

