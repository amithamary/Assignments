package com.UST.RailwayKafka.service;

import com.UST.RailwayKafka.entity.Ticket;
import com.UST.RailwayKafka.repository.TicketRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class TicketBookingConsumer {
    private final TicketRepository ticketRepository;

    public TicketBookingConsumer(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @KafkaListener(topics = "ticketTopic", groupId = "ticketGroup")
    public void consumeTicket(Ticket ticket) {
        ticketRepository.save(ticket);
        System.out.println("Ticket saved: " + ticket);
    }
}
