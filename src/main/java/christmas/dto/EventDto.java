package christmas.dto;

public record EventDto(int dDay, int dayOfTheWeek, boolean isWeekend, int specialDiscount, int freeGiftDiscount) {

    public boolean isEmpty() {
        return dDay == 0 && dayOfTheWeek == 0 && !isWeekend && specialDiscount == 0 && freeGiftDiscount == 0;
    }

    public int getTotalDiscount() {
        return dDay + dayOfTheWeek + specialDiscount + freeGiftDiscount;
    }

    public int getTotalDiscountExcludeByFreeGift() {
        return dDay + dayOfTheWeek + specialDiscount;
    }
}
