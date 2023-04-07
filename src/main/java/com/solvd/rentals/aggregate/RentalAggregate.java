package com.solvd.rentals.aggregate;

import com.solvd.rentals.domain.PurchaseRental;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Data
@Table("rentals")
@NoArgsConstructor
@AllArgsConstructor
public class RentalAggregate {

    @PrimaryKey
    private String id;
    private Long revision;
    private String username;
    private String email;
    private String carNumber;
    private PurchaseRental.Status status;

}
