package com.between.test.application.service;

import com.between.test.application.ports.input.DisambiguatorPriceUseCase;
import com.between.test.application.ports.input.PriceServiceUseCase;
import com.between.test.application.ports.output.PriceRepository;
import com.between.test.domain.model.Price;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class PriceService implements PriceServiceUseCase {

    private DisambiguatorPriceUseCase disambiguatorPriceService;
    private PriceRepository priceRepository;

    @Override
    public Price find(LocalDateTime consultatioDate, Price priceRequest) {
        List<Price> prices = priceRepository.findPrices(consultatioDate, priceRequest);
        return disambiguatorPriceService.disambiguate(prices);
    }
}
