package christmas.dto;

public record EventDto(int dDay, int dayOfTheWeek, boolean isWeekend, int isSpecial, int isGiveFreeGift) {

    public boolean isEmpty() {
        return dDay == 0 && dayOfTheWeek == 0 && !isWeekend && isSpecial != 0 && isGiveFreeGift != 0;
    }
}
