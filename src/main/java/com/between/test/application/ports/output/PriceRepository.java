package com.between.test.application.ports.output;

import com.between.test.domain.model.Price;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceRepository {

    List<Price> findPrices(LocalDateTime consultatioDate, Price price);
}
