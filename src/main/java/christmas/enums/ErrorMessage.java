package christmas.enums;

public enum ErrorMessage {
    VISIT_DAY_INPUT_INVALID("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    MENU_INVALID("유효하지 않은 주문입니다. 다시 입력해 주세요.");

    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX + message;
    }
}
