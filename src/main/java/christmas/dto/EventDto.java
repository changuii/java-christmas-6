package christmas.dto;

public record EventDto(int dDay, int dayOfTheWeek, boolean isWeekend, int specialDiscount, int freeGiftDiscount,
                       int totalPrice) {

    public boolean isEmpty() {
        return dDay == 0 && dayOfTheWeek == 0 && !isWeekend && specialDiscount == 0 && freeGiftDiscount == 0;
    }

    public static EventDto empty(final int totalPrice) {
        return new EventDto(0, 0, false, 0, 0, totalPrice);
    }

    public int getTotalDiscount() {
        return dDay + dayOfTheWeek + specialDiscount + freeGiftDiscount;
    }

    private int getTotalDiscountExcludeByFreeGift() {
        return dDay + dayOfTheWeek + specialDiscount;
    }

    public int calculateAppliedTotalPrice() {
        return totalPrice - getTotalDiscountExcludeByFreeGift();
    }
}
