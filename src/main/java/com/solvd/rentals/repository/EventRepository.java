package com.solvd.rentals.repository;

import com.solvd.rentals.event.Event;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface EventRepository extends ReactiveMongoRepository<Event, String> {

}
