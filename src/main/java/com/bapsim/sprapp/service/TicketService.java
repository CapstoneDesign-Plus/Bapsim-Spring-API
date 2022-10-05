package com.bapsim.sprapp.service;

import com.bapsim.sprapp.model.Ticket;
import com.bapsim.sprapp.model.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;

    @Autowired
    private final SequenceGeneratorService sequenceGeneratorService;

    public Ticket insert(Ticket ticket) {
        ticket.setIdentifier(sequenceGeneratorService.generateSequence(Ticket.SEQUENCE_NAME));
        return ticketRepository.insert(ticket);
    }

}
