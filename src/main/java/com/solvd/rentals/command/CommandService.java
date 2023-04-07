package com.solvd.rentals.command;

import com.solvd.rentals.aggregate.RentalAggregate;
import com.solvd.rentals.domain.Rental;
import reactor.core.publisher.Mono;

public interface CommandService {

    Mono<RentalAggregate> handle(Rental rental);

}
