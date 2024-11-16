package com.between.test.unit.application.service;


import com.between.test.application.service.DisambiguatorPriceService;
import com.between.test.domain.model.Price;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import com.between.test.util.PriceUtil;

import java.util.List;
import java.util.NoSuchElementException;


@ExtendWith(MockitoExtension.class)
class DisambiguatorPriceServiceUnitTest {

	@InjectMocks
	private DisambiguatorPriceService disambiguatorPriceService;
	
	private final PriceUtil priceUtil = new PriceUtil();
	

	@Test
	void test_Disambiguate_Should_ReturnPrice_When_Invoked() {
		// Given
		List<Price> givenPrices = List.of(
				priceUtil.createPrice(),
				priceUtil.createPrice(),
				priceUtil.createPrice());

		// When
		Price result = disambiguatorPriceService.disambiguate(givenPrices);

		// Then
		Assertions.assertNotNull(result);
		Assertions.assertNotNull(result.getStartDate());
	}


	@Test
	void test_Disambiguate_Should_ReturnPrice_WithMajorPriority_When_Invoked() {
		// Given
		Price givenPriceCurrent = priceUtil.createPrice();
		Price givenPriceNot = priceUtil.createPrice();
		givenPriceNot.setPriority(0);
		givenPriceCurrent.setPriority(1);
		List<Price> givenPrices =List.of(
				givenPriceNot,
				givenPriceCurrent);

		// When
		Price result = disambiguatorPriceService.disambiguate(givenPrices);

		// Then
		Assertions.assertNotNull(result);
		Assertions.assertNotNull(result.getStartDate());
		Assertions.assertEquals(result.getPrice(),givenPriceCurrent.getPrice());
	}

	@Test
	void test_Show_Should_ReturnNoSuchElementExceptionWhen_Invoked() {
		// When
		NoSuchElementException exception = Assertions.assertThrows(NoSuchElementException.class, () -> {
			disambiguatorPriceService.disambiguate(List.of());
		});

		// Then
		Assertions.assertNotNull(exception);
	}
}
