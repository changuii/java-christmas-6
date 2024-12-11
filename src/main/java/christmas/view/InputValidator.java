package christmas.view;

import christmas.dto.MenuDto;
import christmas.enums.ErrorMessage;
import christmas.enums.Menu;
import christmas.exception.CustomException;
import java.util.List;
import java.util.regex.Pattern;

public class InputValidator {
    private static final String VISIT_DAY_REGEX = "^[0-9]{1,2}$";
    private static final Pattern VISIT_DAY_PATTERN = Pattern.compile(VISIT_DAY_REGEX);
    private static final int VISIT_DAY_RANGE_MIN = 1;
    private static final int VISIT_DAY_RANGE_MAX = 31;
    private static final String MENUS_REGEX = "^([가-힣]*[-][0-9]{1,2},)*([가-힣]*[-][0-9]{1,2})$";
    private static final Pattern MENUS_PATTERN = Pattern.compile(MENUS_REGEX);
    private static final int MENU_COUNT_MIN = 1;
    private static final int MENUS_COUNT_MAX = 20;

    public void validateVisitDayText(final String visitDay) {
        if (!VISIT_DAY_PATTERN.matcher(visitDay).matches()) {
            throw new CustomException(ErrorMessage.VISIT_DAY_INPUT_INVALID);
        }
    }

    public void validateVisitDay(final int visitDay) {
        if (visitDay < VISIT_DAY_RANGE_MIN || visitDay > VISIT_DAY_RANGE_MAX) {
            throw new CustomException(ErrorMessage.VISIT_DAY_INPUT_INVALID);
        }
    }

    public void validateMenusText(final String menus) {
        if (!MENUS_PATTERN.matcher(menus).matches()) {
            throw new CustomException(ErrorMessage.MENU_INVALID);
        }
    }

    public void validateMenus(final List<MenuDto> menuDtos) {
        menuDtos.forEach(menu -> {
            validateMenuCount(menu);
            validateOrderContainsMenu(menu);
        });

        validateDuplicationMenu(menuDtos);
        validateMenusTotalCountLessThanMax(menuDtos);
        validateMenusContainsNotDrink(menuDtos);
    }

    private void validateMenuCount(final MenuDto menuDto) {
        if (menuDto.count() < MENU_COUNT_MIN) {
            throw new CustomException(ErrorMessage.MENU_INVALID);
        }
    }

    private void validateDuplicationMenu(final List<MenuDto> menuDtos) {
        if (menuDtos.stream().map(menu -> menu.name()).count() != menuDtos.size()) {
            throw new CustomException(ErrorMessage.MENU_INVALID);
        }
    }

    private void validateMenusTotalCountLessThanMax(final List<MenuDto> menuDtos) {
        if (menuDtos.stream().mapToInt(menu -> menu.count()).sum() > MENUS_COUNT_MAX) {
            throw new CustomException(ErrorMessage.MENU_INVALID);
        }
    }

    private void validateMenusContainsNotDrink(final List<MenuDto> menuDtos) {
        menuDtos.stream()
                .filter(menu -> !Menu.isDrink(menu.name()))
                .findAny()
                .orElseThrow(() -> new CustomException(ErrorMessage.MENU_INVALID));
    }

    private void validateOrderContainsMenu(final MenuDto menuDto) {
        if (!Menu.containsName(menuDto.name())) {
            throw new CustomException(ErrorMessage.MENU_INVALID);
        }
    }

}
