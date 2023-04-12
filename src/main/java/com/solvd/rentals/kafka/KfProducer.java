package com.solvd.rentals.kafka;

public interface KfProducer {

    void send(String carNumber);

}
