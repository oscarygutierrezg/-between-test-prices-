package com.between.test.infrastructure.adapter.output.persistence.repository;

import com.between.test.application.ports.output.PriceRepository;
import com.between.test.domain.model.Price;
import com.between.test.infrastructure.adapter.output.persistence.mapper.PriceEntityMapper;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@Primary
@AllArgsConstructor
public class PriceDboRepository implements PriceRepository {

    private final SpringDataSqlPriceRepository springDataSqlPriceRepository;
    private final PriceEntityMapper priceEntityMapper;

    @Override
    public List<Price> findPrices(LocalDateTime consultatioDate, Price priceRequest) {
        return springDataSqlPriceRepository.findPrices(
                consultatioDate,
                priceRequest.getProductId(),
                priceRequest.getBrandId()
        ).stream()
                .map(priceEntityMapper::toDomain)
                .toList();
    }
}


