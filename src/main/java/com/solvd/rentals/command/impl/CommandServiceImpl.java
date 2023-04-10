package com.solvd.rentals.command.impl;

import com.solvd.rentals.aggregate.AggregateService;
import com.solvd.rentals.aggregate.RentalAggregate;
import com.solvd.rentals.command.CommandService;
import com.solvd.rentals.command.ConfirmRentalCommand;
import com.solvd.rentals.command.CreateRentalCommand;
import com.solvd.rentals.command.DenyRentalCommand;
import com.solvd.rentals.domain.PurchaseRental;
import com.solvd.rentals.domain.Rental;
import com.solvd.rentals.event.Event;
import com.solvd.rentals.event.EventService;
import com.solvd.rentals.kafka.KfProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CommandServiceImpl implements CommandService {

    private final EventService eventService;
    private final AggregateService aggregateService;
    private final KfProducer kfProducer;

    @Override
    public Mono<RentalAggregate> handle(Rental rental) {
        PurchaseRental purchaseRental = getPurchaseRental(rental);
        CreateRentalCommand command = new CreateRentalCommand();
        command.setPurchaseRental(purchaseRental);
        String aggregateId = UUID.randomUUID().toString();
        command.setAggregateId(aggregateId);
        Event event = eventService.create(command);
        Mono<RentalAggregate> aggregate = aggregateService.create(event, purchaseRental);
        kfProducer.send(command.getPurchaseRental().getCarNumber() + ", " + aggregateId);
        return aggregate;
    }

    public PurchaseRental getPurchaseRental(Rental rental){
        PurchaseRental purchaseRental = new PurchaseRental();
        purchaseRental.setCarNumber(rental.getCarNumber());
        purchaseRental.setEmail(rental.getEmail());
        purchaseRental.setUsername(rental.getUsername());
        purchaseRental.setStatus(PurchaseRental.Status.CREATED);
        return purchaseRental;
    }

    @Override
    public Mono<RentalAggregate> confirm(String id) {
        ConfirmRentalCommand command = new ConfirmRentalCommand();
        command.setAggregateId(id);
        Event event = eventService.confirm(command);
        return aggregateService.confirm(event);
    }

    @Override
    public Mono<RentalAggregate> deny(String id) {
        DenyRentalCommand command = new DenyRentalCommand();
        command.setAggregateId(id);
        Event event = eventService.deny(command);
        return aggregateService.deny(event);
    }

}
