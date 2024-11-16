package com.between.test.application.ports.input;

import com.between.test.domain.model.Price;

import java.util.List;


public interface DisambiguatorPriceUseCase {
	Price disambiguate(List<Price> prices);
}
