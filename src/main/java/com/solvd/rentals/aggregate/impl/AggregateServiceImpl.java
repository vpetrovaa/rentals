package com.solvd.rentals.aggregate.impl;

import com.solvd.rentals.aggregate.AggregateService;
import com.solvd.rentals.aggregate.RentalAggregate;
import com.solvd.rentals.domain.PurchaseRental;
import com.solvd.rentals.domain.exception.IllegalEventException;
import com.solvd.rentals.event.Event;
import com.solvd.rentals.repository.RentalRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class AggregateServiceImpl implements AggregateService {

    private final RentalRepository rentalRepository;

    @Override
    public void apply(Event event) {
        validateEvent(event);
        when(event);
    }

    @Override
    public void when(Event event) {
        switch (event.getEventType()) {
            case "RentalCreated" -> log.info("Rental was created");
            default -> throw new IllegalEventException("Exception in " + event.getEventType() + " type");
        }
    }

    @Override
    public void validateEvent(Event event) {
        if (Objects.isNull(event))
            throw new IllegalEventException("Event is null");
    }

    @Override
    public Mono<RentalAggregate> create(Event event, PurchaseRental purchaseRental) {
        apply(event);
        RentalAggregate aggregate = new RentalAggregate();
        aggregate.setId(event.getAggregateId());
        aggregate.setRevision(1L);
        aggregate.setUsername(purchaseRental.getUsername());
        aggregate.setStatus(purchaseRental.getStatus());
        aggregate.setEmail(purchaseRental.getEmail());
        aggregate.setCarNumber(event.getCarNumber());
        return rentalRepository.save(aggregate);
    }

}
