package com.solvd.rentals.kafka;

import com.solvd.rentals.kafka.property.KfProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.kafka.sender.KafkaSender;
import reactor.kafka.sender.SenderRecord;

@Service
@RequiredArgsConstructor
public class KfProducerImpl implements KfProducer {

    private final KfProperties kfProperties;
    private final KafkaSender<String, String> kafkaSender;

    @Override
    public void send(String message) {
        this.kafkaSender.send(Mono.just(SenderRecord.create(
                        kfProperties.getTopic(),
                        2,
                        System.currentTimeMillis(),
                        kfProperties.getKey(),
                        message,
                        null)))
                .subscribe();
    }

}
