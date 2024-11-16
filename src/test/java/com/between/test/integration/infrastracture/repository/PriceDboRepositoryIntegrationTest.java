package com.between.test.integration.infrastracture.repository;

import com.between.test.infrastructure.adapter.output.persistence.repository.PriceDboRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SqlDbPriceRepositoryIntegrationTest {

    @Autowired
    private PriceDboRepository sqlDbPriceRepository;

    @Test
    void testFindPrices() {
        // Arrange: Crea un objeto PriceRequest con los parámetros de búsqueda
        PriceRequest priceRequest = new PriceRequest(
                LocalDateTime.of(2023, 11, 1, 10, 0), // Fecha específica
                1L, // ID del producto
                1L  // ID de la marca
        );

        // Act: Llama al método findPrices
        List<Price> prices = sqlDbPriceRepository.findPrices(priceRequest);

        // Assert: Verifica que los resultados sean correctos
        assertThat(prices).isNotEmpty();
        assertThat(prices.get(0).getProductId()).isEqualTo(1L);
        assertThat(prices.get(0).getBrandId()).isEqualTo(1L);
    }
}
