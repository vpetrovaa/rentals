package com.solvd.rentals.domain;

import lombok.Data;

@Data
public class PurchaseRental {

    private String username;
    private String email;
    private String carNumber;
    private Status status;

    public enum Status {
        CREATED, CONFIRMED, DENIED;
    }

}
