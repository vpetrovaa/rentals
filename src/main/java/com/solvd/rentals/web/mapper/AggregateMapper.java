package com.solvd.rentals.web.mapper;

import com.solvd.rentals.aggregate.RentalAggregate;
import com.solvd.rentals.web.dto.RentalAggregateDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AggregateMapper {

    RentalAggregate toEntity(RentalAggregateDto aggregateDto);

    RentalAggregateDto toDto(RentalAggregate aggregate);

}
