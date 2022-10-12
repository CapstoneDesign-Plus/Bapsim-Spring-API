package com.bapsim.sprapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class UserDTO {
    private String email;
    private String username;
    private int uclass;
    private int point;
    private List<String> tickets;
}
