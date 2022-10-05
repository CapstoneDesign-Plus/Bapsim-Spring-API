package com.bapsim.sprapp.model;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TicketRepository extends MongoRepository<Ticket, Long> {


}
