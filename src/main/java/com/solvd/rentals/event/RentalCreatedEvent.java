package com.solvd.rentals.event;

public class RentalCreatedEvent extends Event {

    @Override
    public String getName(){
        return "RentalCreated";
    }

}
