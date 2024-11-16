package com.between.test.infrastructure.adapter.input.rest.controller.impl;

import com.between.test.application.ports.input.PriceServiceUseCase;
import com.between.test.infrastructure.adapter.input.rest.controller.PriceController;
import com.between.test.infrastructure.adapter.input.rest.dto.model.request.PriceRequest;
import com.between.test.infrastructure.adapter.input.rest.dto.model.response.PriceDto;
import com.between.test.infrastructure.adapter.input.rest.mapper.PriceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;


@RestController
@RequiredArgsConstructor
public class PriceControllerImpl implements PriceController {

    private final PriceServiceUseCase priceService;
    private final PriceMapper priceMapper;

    @Override
    public ResponseEntity<PriceDto> finrCurrentPrice(Long productId, Long brandId, LocalDateTime consultatioDate) {
        var price = priceService.find(
                consultatioDate,
               priceMapper.toDomain(PriceRequest.builder().brandId(brandId).productId(productId).build()));
        return new ResponseEntity<>(
                priceMapper.toDto(price),
                HttpStatus.OK
        );

    }
}
