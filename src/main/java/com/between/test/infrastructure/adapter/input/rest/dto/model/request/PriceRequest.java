package com.between.test.infrastructure.adapter.input.rest.dto.model.request;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class PriceRequest {
    private LocalDateTime now;
    private long productId;
    private long brandId;
}