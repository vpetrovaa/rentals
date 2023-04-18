package com.solvd.rentals.query.impl;

import com.solvd.rentals.aggregate.RentalAggregate;
import com.solvd.rentals.query.FindByCarNumberQuery;
import com.solvd.rentals.query.QueryService;
import com.solvd.rentals.repository.RentalRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class QueryServiceImpl implements QueryService {

    private final RentalRepository rentalRepository;

    @Override
    public Mono<RentalAggregate> handle(FindByCarNumberQuery query) {
        log.info("Find name of rental method was called");
        return rentalRepository.findByCarNumber(query.carNumber());
    }

}
