package com.between.test.infrastructure.adapter.output.persistence.mapper;

import com.between.test.domain.model.Price;
import com.between.test.infrastructure.adapter.output.persistence.dbo.PriceEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-17T17:55:27-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 21.0.4 (Amazon.com Inc.)"
)
@Component
public class PriceEntityMapperImpl implements PriceEntityMapper {

    @Override
    public Price toDomain(PriceEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        Price price = new Price();

        price.setPriceList( userEntity.getPriceList() );
        price.setProductId( userEntity.getProductId() );
        price.setBrandId( userEntity.getBrandId() );
        price.setPriority( userEntity.getPriority() );
        if ( userEntity.getStartDate() != null ) {
            price.setStartDate( userEntity.getStartDate() );
        }
        if ( userEntity.getEndDate() != null ) {
            price.setEndDate( userEntity.getEndDate() );
        }
        if ( userEntity.getCurr() != null ) {
            price.setCurr( userEntity.getCurr() );
        }
        price.setPrice( userEntity.getPrice() );

        return price;
    }
}
