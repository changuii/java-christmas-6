package christmas.handler;

import christmas.exception.CustomException;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class RetryHandler {
    public <T> T retryUntilNotException(final Supplier<T> logic, final Consumer<CustomException> exceptionCallback) {
        while (true) {
            try {
                return logic.get();
            } catch (final CustomException e) {
                exceptionCallback.accept(e);
            }
        }
    }
}
