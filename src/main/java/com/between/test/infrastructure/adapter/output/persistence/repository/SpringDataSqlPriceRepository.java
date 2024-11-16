package com.between.test.infrastructure.adapter.output.persistence.repository;

import com.between.test.infrastructure.adapter.output.persistence.dbo.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SpringDataSqlPriceRepository extends JpaRepository<PriceEntity, Long> {


    @Query(
            value = "SELECT p FROM PriceEntity p WHERE  :now BETWEEN p.startDate AND p.endDate" +
                    " AND p.productId = :productId"+
                    " AND p.brandId = :brandId"
    )
    List<PriceEntity> findPrices(LocalDateTime now, long productId, long brandId);

}
