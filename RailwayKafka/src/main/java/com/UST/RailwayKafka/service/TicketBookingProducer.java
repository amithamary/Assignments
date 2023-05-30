package com.UST.RailwayKafka.service;

import com.UST.RailwayKafka.entity.Ticket;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class TicketBookingProducer {
    private static final String TOPIC_NAME = "ticketTopic";

    private final KafkaTemplate<String, Ticket> kafkaTemplate;

    public TicketBookingProducer(KafkaTemplate<String, Ticket> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendTicket(Ticket ticket) {
        kafkaTemplate.send(TOPIC_NAME, ticket);
    }
}
