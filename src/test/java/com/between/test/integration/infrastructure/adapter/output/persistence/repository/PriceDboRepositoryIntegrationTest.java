package com.between.test.integration.infrastructure.adapter.output.persistence.repository;

import com.between.test.domain.model.Price;
import com.between.test.infrastructure.adapter.output.persistence.repository.PriceDboRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PriceDboRepositoryIntegrationTest {

    @Autowired
    private PriceDboRepository priceDboRepository;

    @Test
    void test_shouldFindPricesForGivenDateAndProductAndBrand() {
        // Given
        LocalDateTime givenConsultationDate = LocalDateTime.parse("2020-06-14T10:00:00");
        Price givenPriceRequest = new Price();
        givenPriceRequest.setProductId(35455);
        givenPriceRequest.setBrandId(1);

        // When
        List<Price> results = priceDboRepository.findPrices(givenConsultationDate, givenPriceRequest);

        // Then
        assertThat(results)
                .isNotEmpty()
                .hasSize(1);

        Price price = results.get(0);

        assertThat(price.getPrice())
                .isEqualTo(35.50);
        assertThat(price.getCurr())
                .isEqualTo("EUR");
    }
}
