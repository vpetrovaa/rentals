package com.solvd.rentals.command;

import com.solvd.rentals.aggregate.RentalAggregate;
import com.solvd.rentals.domain.Rental;
import reactor.core.publisher.Mono;

public interface CommandService {

    Mono<RentalAggregate> handle(Rental rental);

    Mono<RentalAggregate> confirm(String id);

    Mono<RentalAggregate> deny(String id);

}
