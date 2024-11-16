package com.between.test.infrastructure.adapter.input.rest.mapper;

import com.between.test.domain.model.Price;
import com.between.test.infrastructure.adapter.input.rest.dto.model.request.PriceRequest;
import com.between.test.infrastructure.adapter.input.rest.dto.model.response.PriceDto;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;


@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public
interface PriceMapper {

    PriceDto toDto (Price user);

    Price toDomain(PriceRequest userDto);
}
