package com.solvd.rentals.web.mapper;

import com.solvd.rentals.domain.Rental;
import com.solvd.rentals.web.dto.RentalDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RentalMapper {

    Rental toEntity(RentalDto rentalDto);

    RentalDto toDto(Rental rental);

}
