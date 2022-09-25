package com.bapsim.sprapp.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/ticket")
@AllArgsConstructor
public class TicketController {

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
    public Object createTicket() {
        return null;
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
