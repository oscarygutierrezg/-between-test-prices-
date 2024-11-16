package com.between.test.infrastructure.adapter.output.persistence.mapper;

import com.between.test.domain.model.Price;
import com.between.test.infrastructure.adapter.output.persistence.dbo.PriceEntity;
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

	Price toDomain(PriceEntity userEntity);

	PriceEntity toDbo(Price user);
}
