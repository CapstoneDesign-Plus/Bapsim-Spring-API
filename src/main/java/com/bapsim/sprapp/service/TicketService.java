package com.bapsim.sprapp.service;

import com.bapsim.sprapp.model.Ticket;
import com.bapsim.sprapp.model.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    // todo: optimization
    public List<Ticket> getHistory(String email) {
        return ticketRepository.findAll().stream()
                .filter(t -> t.getOwner().equals(email))
                .collect(Collectors.toList());
    }

}
