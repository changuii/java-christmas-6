package christmas.enums;

public enum OutputMessage {

    EVENT_INTRODUCE("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");

    private final String message;

    OutputMessage(final String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}

