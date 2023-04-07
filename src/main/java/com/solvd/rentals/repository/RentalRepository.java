package com.solvd.rentals.repository;

import com.solvd.rentals.aggregate.RentalAggregate;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;

public interface RentalRepository extends ReactiveCassandraRepository<RentalAggregate, String> {

}
