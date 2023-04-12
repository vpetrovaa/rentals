package com.solvd.rentals.event;

public class RentalDeniedEvent extends Event {

    @Override
    public String getName(){
        return "RentalDenied";
    }

}
