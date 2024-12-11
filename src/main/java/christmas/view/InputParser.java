package christmas.view;

import christmas.dto.MenuDto;
import christmas.enums.ErrorMessage;
import christmas.exception.CustomException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {
    private static final String MENUS_DELIMITER = ",";
    private static final String MENU_DELIMITER = "-";
    private static final int MENU_NAME_INDEX = 0;
    private static final int MENU_COUNT_INDEX = 1;


    public int parseVisitDay(final String visitDayText) {
        return parseInt(visitDayText, ErrorMessage.VISIT_DAY_INPUT_INVALID);
    }

    public List<MenuDto> parseMenus(final String menusText) {
        return Arrays.stream(menusText.split(MENUS_DELIMITER))
                .map(menuText -> parseMenu(menuText))
                .collect(Collectors.toList());
    }

    private MenuDto parseMenu(final String menuText) {
        String[] menu = menuText.split(MENU_DELIMITER);
        String name = menu[MENU_NAME_INDEX];
        int count = parseInt(menu[MENU_COUNT_INDEX], ErrorMessage.MENU_INVALID);
        return new MenuDto(name, count);
    }

    private int parseInt(final String textNum, final ErrorMessage errorMessage) {
        try {
            return Integer.parseInt(textNum);
        } catch (final NumberFormatException e) {
            throw new CustomException(errorMessage);
        }
    }
}
