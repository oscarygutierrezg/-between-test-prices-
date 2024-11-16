package unit.com.between.test.application.service;


import com.between.test.application.service.DisambiguatorPriceService;
import com.between.test.domain.model.Price;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import util.PriceUtil;

import java.util.List;
import java.util.NoSuchElementException;


@ExtendWith(MockitoExtension.class)
class DisambiguatorPriceServiceUnitTest {

	@InjectMocks
	private DisambiguatorPriceService disambiguatorPriceService;
	
	private final PriceUtil priceUtil = new PriceUtil();
	

	@Test
	void test_Disambiguate_Should_ReturnPrice_When_Invoked() {

		List<Price> prices = List.of(
				priceUtil.createPrice(),
				priceUtil.createPrice(),
				priceUtil.createPrice());
		
		Price price = disambiguatorPriceService.disambiguate(prices);

		Assertions.assertNotNull(price);
		Assertions.assertNotNull(price.getStartDate());
	}


	@Test
	void test_Disambiguate_Should_ReturnPrice_WithMajorPriority_When_Invoked() {
		Price priceCurrent = priceUtil.createPrice();
		Price priceNot = priceUtil.createPrice();

		priceNot.setPriority(0);
		priceCurrent.setPriority(1);


		List<Price> prices =List.of(
				priceNot,
				priceCurrent);

		Price price = disambiguatorPriceService.disambiguate(prices);

		Assertions.assertNotNull(price);
		Assertions.assertNotNull(price.getStartDate());
		Assertions.assertEquals(price.getAmount(),priceCurrent.getAmount());
	}

	@Test
	void test_Show_Should_ReturnNoSuchElementExceptionWhen_Invoked() {
		NoSuchElementException exception = Assertions.assertThrows(NoSuchElementException.class, () -> {
			disambiguatorPriceService.disambiguate(List.of());
		});

		Assertions.assertNotNull(exception);
	}
}
