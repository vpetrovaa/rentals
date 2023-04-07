package com.solvd.rentals.event;

import com.solvd.rentals.command.CreateRentalCommand;

public interface EventService {

    Event create(CreateRentalCommand command);

}
