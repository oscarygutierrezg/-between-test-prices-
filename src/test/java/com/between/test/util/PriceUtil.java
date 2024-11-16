package com.between.test.util;

import com.between.test.domain.model.Price;
import com.between.test.infrastructure.adapter.input.rest.dto.model.response.PriceDto;
import com.github.javafaker.Faker;

import java.time.LocalDateTime;

public class PriceUtil {
	
	private Faker faker = new Faker();
	public PriceDto toDto(Price price) {
		return  PriceDto.builder()
				.price(price.getPrice())
				.brandId(price.getBrandId())
				.productId(price.getProductId())
				.curr(price.getCurr())
				.priceList(price.getPriceList())
				.endDate(price.getEndDate())
				.priority(price.getPriority())
				.startDate(price.getStartDate())
				.build();
	}

	public Price createPrice( ) {
		Price price = new Price();
		price.setPrice(faker.number().randomDouble(2,1,999999));
		price.setBrandId(faker.number().randomNumber());
		price.setProductId(faker.number().randomNumber());
		price.setPriceList(faker.number().randomNumber());
		price.setPriority(faker.number().randomNumber());
		price.setCurr(faker.currency().code());
		price.setStartDate(LocalDateTime.now());
		price.setEndDate(LocalDateTime.now());
		return price;
	}

}
