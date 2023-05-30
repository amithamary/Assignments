package com.UST.RailwayKafka.controller;


import com.UST.RailwayKafka.entity.Ticket;
import com.UST.RailwayKafka.service.TicketBookingProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    private final TicketBookingProducer ticketProducer;

    public TicketController(TicketBookingProducer ticketProducer) {
        this.ticketProducer = ticketProducer;
    }

    @PostMapping
    public void createTicket(@RequestBody Ticket ticket) {
        ticketProducer.sendTicket(ticket);
        System.out.println("Ticket sent to Kafka: " + ticket);
    }
}
