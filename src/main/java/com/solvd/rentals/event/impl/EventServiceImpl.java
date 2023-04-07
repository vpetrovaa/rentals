package com.solvd.rentals.event.impl;

import com.solvd.rentals.command.CreateRentalCommand;
import com.solvd.rentals.event.Event;
import com.solvd.rentals.event.EventService;
import com.solvd.rentals.event.RentalCreatedEvent;
import com.solvd.rentals.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    @Override
    public Event create(CreateRentalCommand command) {
        RentalCreatedEvent event = new RentalCreatedEvent();
        event.setCreatedAt(LocalDateTime.now());
        event.setId(UUID.randomUUID().toString());
        event.setData(command.getPurchaseRental().toString());
        event.setEventType(event.getName());
        event.setCarNumber(command.getPurchaseRental().getCarNumber());
        event.setAggregateId(command.getAggregateId());
        eventRepository.save(event);
        return event;
    }

}
