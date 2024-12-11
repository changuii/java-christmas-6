package christmas.enums;

import java.util.Arrays;

public enum Menu {

    // APPETIZER
    BUTTON_MUSHROOM_SOUP("양송이수프", 6000, MenuType.APPETIZER),
    TAPAS("타파스", 5500, MenuType.APPETIZER),
    CAESAR_SALAD("시저샐러드", 8000, MenuType.APPETIZER),

    // MAIN
    T_BONE_STEAK("티본스테이크", 55000, MenuType.MAIN),
    BARBECUE_RIBS("바비큐립", 54000, MenuType.MAIN),
    SEA_FOOD_PASTA("해산물파스타", 35000, MenuType.MAIN),
    CHRISTMAS_PASTA("크리스마스파스타", 25000, MenuType.MAIN),

    // DESSERT
    CHOCO_CAKE("초코케이크", 15000, MenuType.DESSERT),
    ICE_CREAM("아이스크림", 5000, MenuType.DESSERT),

    // DRINK
    ZERO_COKE("제로콜라", 3000, MenuType.DRINK),
    RED_WINE("레드와인", 60000, MenuType.DRINK),
    CHAMPAGNE("샴페인", 25000, MenuType.DRINK);

    private final String name;
    private final int price;
    private final MenuType menuType;

    Menu(final String name, final int price, final MenuType menuType) {
        this.name = name;
        this.price = price;
        this.menuType = menuType;
    }

    public static boolean containsName(final String orderName) {
        return Arrays.stream(values())
                .anyMatch(menu -> menu.name.equals(orderName));
    }

}
