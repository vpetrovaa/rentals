package com.solvd.rentals.aggregate;

import com.solvd.rentals.domain.PurchaseRental;
import com.solvd.rentals.event.Event;
import reactor.core.publisher.Mono;

public interface AggregateService {

    void apply(Event event);

    void when(Event event);

    void validateEvent(Event event);

    Mono<RentalAggregate> create(Event event, PurchaseRental purchaseRental);

}
