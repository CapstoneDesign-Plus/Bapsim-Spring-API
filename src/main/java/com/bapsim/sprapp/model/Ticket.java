package com.bapsim.sprapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(value = "tickets")
@AllArgsConstructor
@Getter
public class Ticket {

    @Transient
    public static final String SEQUENCE_NAME = "tickets_sequence";

    @Id
    private Long id;




}
