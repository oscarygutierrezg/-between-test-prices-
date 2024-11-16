package com.between.test.application.ports.input;


import com.between.test.domain.model.Price;

public interface PriceServiceUseCase {
	Price find(Price priceRequest);
}
