package com.bapsim.sprapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(value = "sequences")
@AllArgsConstructor
@Getter
public class DBSequence {

    @Id
    private String id;

    private Long sequence;

    public void setSequence(Long sequence) {
        this.sequence = sequence;
    }
}
