package com.bapsim.sprapp.controller;

import com.bapsim.sprapp.model.Ticket;
import com.bapsim.sprapp.service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/ticket")
@AllArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    // Get Mapping

    @GetMapping(value = "/page")
    @ResponseBody
    public Object page() {
        return null;
    }

    @GetMapping(value = "/validate")
    @ResponseBody
    public Object validate() {
        return null;
    }

    @GetMapping(value = "/search")
    @ResponseBody
    public Object search() {
        return null;
    }


    @GetMapping(value = "/get")
    @ResponseBody
    public  Object getTicket() {
        return null;
    }

    // Post Mapping

    @PostMapping(value = "/create")
    @ResponseBody
    public Ticket createTicket(/* @RequestBody Object value */) {

        Ticket ticket = new Ticket(
                (long) -1,
                "me",
                Ticket.TicketClass.A,
                Ticket.TicketState.Normal,
                100,
                null
        );

        return ticketService.insert(ticket);
    }

    // Put Mapping

    @PutMapping(value = "/assign")
    @ResponseBody
    public Object assign() {
        return null;
    }

    @PutMapping(value = "/state")
    @ResponseBody
    public Object changeState() {
        return null;
    }

    // Delete Mapping

    @DeleteMapping(value = "refund")
    @ResponseBody
    public Object refund() {
        return null;
    }
}
