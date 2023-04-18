package com.solvd.rentals.repository;

import com.solvd.rentals.aggregate.RentalAggregate;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface RentalRepository extends ReactiveMongoRepository<RentalAggregate, String> {

}
