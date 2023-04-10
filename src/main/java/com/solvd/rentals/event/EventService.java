package com.solvd.rentals.event;

import com.solvd.rentals.command.ConfirmRentalCommand;
import com.solvd.rentals.command.CreateRentalCommand;
import com.solvd.rentals.command.DenyRentalCommand;

public interface EventService {

    Event create(CreateRentalCommand command);

    Event confirm(ConfirmRentalCommand command);

    Event deny(DenyRentalCommand command);

}
