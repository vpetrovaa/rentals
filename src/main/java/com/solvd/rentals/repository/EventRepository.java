package com.solvd.rentals.repository;

import com.solvd.rentals.event.Event;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;

public interface EventRepository extends ReactiveCassandraRepository<Event, String> {

}
