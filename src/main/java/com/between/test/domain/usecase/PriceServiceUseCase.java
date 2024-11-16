package com.between.test.domain.usecase;


import com.between.test.domain.model.Price;

public interface PriceServiceUseCase {
	Price find(Price priceRequest);
}
