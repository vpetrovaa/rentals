package com.solvd.rentals.web.dto;

import lombok.Data;

@Data
public class RentalAggregateDto {

    private String id;
    private Long revision;
    private String username;
    private String email;
    private String carNumber;
    private String status;

}
