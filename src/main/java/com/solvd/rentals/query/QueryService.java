package com.solvd.rentals.query;

import com.solvd.rentals.aggregate.RentalAggregate;
import reactor.core.publisher.Mono;

public interface QueryService {

    Mono<RentalAggregate> handle(FindByCarNumberQuery query);

}
