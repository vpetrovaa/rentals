package com.solvd.rentals.web.controller;

import com.solvd.rentals.aggregate.RentalAggregate;
import com.solvd.rentals.command.CommandService;
import com.solvd.rentals.domain.Rental;
import com.solvd.rentals.query.FindByCarNumberQuery;
import com.solvd.rentals.query.QueryService;
import com.solvd.rentals.web.dto.RentalAggregateDto;
import com.solvd.rentals.web.dto.RentalDto;
import com.solvd.rentals.web.mapper.AggregateMapper;
import com.solvd.rentals.web.mapper.RentalMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/rentals")
@RequiredArgsConstructor
public class RentalController {

    private final RentalMapper rentalMapper;
    private final CommandService commandService;
    private final AggregateMapper aggregateMapper;
    private final QueryService queryService;

    @PostMapping
    public Mono<RentalAggregateDto> create(@RequestBody @Validated RentalDto rentalDto) {
        Rental rentalMapped = rentalMapper.toEntity(rentalDto);
        Mono<RentalAggregate> rental = commandService.handle(rentalMapped);
        return rental.map(aggregateMapper::toDto);
    }

    @PutMapping("/confirm/{id}")
    public void confirm(@PathVariable String id) {
        commandService.confirm(id);
    }

    @PutMapping("/deny/{id}")
    public void deny(@PathVariable String id) {
        commandService.deny(id);
    }

    @GetMapping("/{carNumber}")
    public Mono<String> findByCarNumber(@PathVariable String carNumber) {
        return queryService.handle(new FindByCarNumberQuery(carNumber)).map(r -> r.getUsername());
    }

}
