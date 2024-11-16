package com.between.test.unit.application.service;


import com.between.test.application.ports.input.DisambiguatorPriceUseCase;
import com.between.test.application.ports.output.PriceRepository;
import com.between.test.application.service.PriceService;
import com.between.test.domain.model.Price;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import com.between.test.util.PriceUtil;

import java.time.LocalDateTime;
import java.util.List;


@ExtendWith(MockitoExtension.class)
class PriceServiceUnitTest {

	@InjectMocks
	private PriceService priceService;

	@Mock
	private DisambiguatorPriceUseCase disambiguatorPriceService;
	@Mock
	private PriceRepository priceRepository;

	private final PriceUtil priceUtil = new PriceUtil();
	private Faker faker = new Faker();

	@Test
	void test_Disambiguate_Should_ReturnPrice_When_Invoked() {
		// Given
		Mockito.when(priceRepository.findPrices(Mockito.any(LocalDateTime.class), Mockito.any(Price.class))).thenReturn(List.of(
				priceUtil.createPrice(),
				priceUtil.createPrice(),
				priceUtil.createPrice()));
		Mockito.when(disambiguatorPriceService.disambiguate(Mockito.any(List.class))).thenReturn(priceUtil.createPrice());

		var givenPrice = new Price();
		givenPrice.setBrandId(faker.number().randomNumber());
		givenPrice.setProductId(faker.number().randomNumber());

		// When
		Price result = priceService.find(
				LocalDateTime.now(),
				givenPrice
		);

		Assertions.assertNotNull(result);
		Assertions.assertNotNull(result.getStartDate());

		// Then
		Mockito.verify(priceRepository, Mockito.times(1)).findPrices(Mockito.any(LocalDateTime.class), Mockito.any(Price.class));
		Mockito.verify(disambiguatorPriceService, Mockito.times(1)).disambiguate(Mockito.any());
	}
}
