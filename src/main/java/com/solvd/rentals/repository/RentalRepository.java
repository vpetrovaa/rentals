package com.solvd.rentals.repository;

import com.solvd.rentals.aggregate.RentalAggregate;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface RentalRepository extends ReactiveMongoRepository<RentalAggregate, String> {

    Mono<RentalAggregate> findByCarNumber(String carNumber);

}
