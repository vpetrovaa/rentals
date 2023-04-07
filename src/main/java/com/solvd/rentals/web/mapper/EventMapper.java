package com.solvd.rentals.web.mapper;

import com.solvd.rentals.event.Event;
import com.solvd.rentals.web.dto.EventDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EventMapper {

    Event toEntity(EventDto eventDto);

    EventDto toDto(Event event);

}