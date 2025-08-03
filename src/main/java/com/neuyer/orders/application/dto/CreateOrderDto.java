package com.neuyer.orders.application.dto;

import java.util.List;

public record CreateOrderDto(
        String userId,
        List<OderItemDto> items
) {
}
