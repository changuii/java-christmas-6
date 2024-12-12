package christmas.dto;

import java.util.List;

public record OrderVisitDto(int visitDay, List<OrderDto> orderDtos, int orderTotalPrice) {
}
