package com.bapsim.sprapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(value = "tickets")
@AllArgsConstructor
@Getter
public class Ticket {

    public enum TicketState {
        Normal, Waiting, Used, Refunded, Expired
    }

    public enum TicketClass {
        A, B, C
    }

    @Transient
    public static final String SEQUENCE_NAME = "tickets_sequence";

    @Id
    private Long identifier;

    private String owner;

    private TicketClass tclass;

    private TicketState state;

    private int price;

    @CreatedDate
    private LocalDateTime createdAt;



}
