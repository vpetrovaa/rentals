package com.solvd.rentals.command;

import com.solvd.rentals.domain.PurchaseRental;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRentalCommand {

    private String aggregateId;
    private PurchaseRental purchaseRental;

}
