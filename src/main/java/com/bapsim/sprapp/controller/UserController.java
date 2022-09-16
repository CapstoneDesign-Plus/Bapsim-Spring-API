package com.bapsim.sprapp.controller;

import com.bapsim.sprapp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/all")
    @ResponseBody
    public Object getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping(value = "/{email}")
    @ResponseBody
    public UserDTO getUserByEmail(@PathVariable("email") String email) {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(email);
        return userDTO;
    }
}

class UserDTO {
    private String email;

    public void setEmail(String email) {this.email = email;}

    public String getEmail(){
        return this.email;
    }
}
