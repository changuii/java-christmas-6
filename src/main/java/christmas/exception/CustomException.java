package christmas.exception;

import christmas.enums.ErrorMessage;

public class CustomException extends RuntimeException {
    public CustomException(final ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }
}
