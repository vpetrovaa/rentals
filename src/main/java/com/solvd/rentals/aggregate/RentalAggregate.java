package com.solvd.rentals.aggregate;

import com.solvd.rentals.domain.PurchaseRental;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("rentals")
@NoArgsConstructor
@AllArgsConstructor
public class RentalAggregate {

    @Id
    private String id;
    private Long revision;
    private String username;
    private String email;
    private String carNumber;
    private PurchaseRental.Status status;

}
