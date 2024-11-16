package com.between.test.application.service;

import com.between.test.application.ports.input.DisambiguatorPriceUseCase;
import com.between.test.domain.model.Price;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class DisambiguatorPriceService implements DisambiguatorPriceUseCase {

    @Override
    public Price disambiguate(List<Price> prices) {
        return  prices
                .stream()
                .max(Comparator.comparing(Price::getPriority))
                .orElseThrow(NoSuchElementException::new);
    }
}
