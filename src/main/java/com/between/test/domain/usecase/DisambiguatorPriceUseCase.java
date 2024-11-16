package com.between.test.domain.usecase;

import com.between.test.domain.model.Price;

import java.util.List;


public interface DisambiguatorPriceUseCase {
	Price disambiguate(List<Price> prices);
}
