package com.between.test.infrastructure.adapter.input.rest.mapper;

import com.between.test.domain.model.Price;
import com.between.test.infrastructure.adapter.input.rest.dto.model.request.PriceRequest;
import com.between.test.infrastructure.adapter.input.rest.dto.model.response.PriceDto;
import com.between.test.infrastructure.adapter.input.rest.dto.model.response.PriceDto.PriceDtoBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-17T17:55:27-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 21.0.4 (Amazon.com Inc.)"
)
@Component
public class PriceMapperImpl implements PriceMapper {

    @Override
    public PriceDto toDto(Price user) {
        if ( user == null ) {
            return null;
        }

        PriceDtoBuilder priceDto = PriceDto.builder();

        priceDto.priceList( user.getPriceList() );
        priceDto.productId( user.getProductId() );
        priceDto.brandId( user.getBrandId() );
        priceDto.priority( user.getPriority() );
        if ( user.getStartDate() != null ) {
            priceDto.startDate( user.getStartDate() );
        }
        if ( user.getEndDate() != null ) {
            priceDto.endDate( user.getEndDate() );
        }
        if ( user.getCurr() != null ) {
            priceDto.curr( user.getCurr() );
        }
        priceDto.price( user.getPrice() );

        return priceDto.build();
    }

    @Override
    public Price toDomain(PriceRequest userDto) {
        if ( userDto == null ) {
            return null;
        }

        Price price = new Price();

        price.setProductId( userDto.getProductId() );
        price.setBrandId( userDto.getBrandId() );

        return price;
    }
}
