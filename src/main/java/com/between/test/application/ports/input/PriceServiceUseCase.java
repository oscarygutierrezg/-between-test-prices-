package com.between.test.application.ports.input;


import com.between.test.domain.model.Price;

import java.time.LocalDateTime;

public interface PriceServiceUseCase {

	Price find(LocalDateTime consultatioDate, Price priceRequest);
}
