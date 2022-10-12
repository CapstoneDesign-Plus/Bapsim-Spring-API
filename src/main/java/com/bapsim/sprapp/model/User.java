package com.bapsim.sprapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(value = "users")
@AllArgsConstructor
@Getter
public class User {
    @Id
    private String email;
    private String username;
    private String password;
    private boolean certificated;
    private int uclass;
    private int point;
    private List<String> tickets;
    @CreatedDate
    private LocalDateTime createdAt;

    public UserDTO toUserDTO() {
        return new UserDTO(
                this.email,
                this.username,
                this.uclass,
                this.point,
                this.tickets
        );
    }
}
