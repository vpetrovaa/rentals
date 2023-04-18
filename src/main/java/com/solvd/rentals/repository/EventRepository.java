package com.solvd.rentals.repository;

import com.solvd.rentals.aggregate.RentalAggregate;
import com.solvd.rentals.event.Event;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface EventRepository extends ReactiveMongoRepository<Event, String> {

    Mono<RentalAggregate> findByCarNumber(String carNumber);

}
