package com.bapsim.sprapp.controller;

import com.bapsim.sprapp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping(value = "/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    // GetMapping

    @GetMapping(value = "/page")
    @ResponseBody
    public Object page(){
        return userService.getAllUsers();
    }

    @GetMapping(value = "/search")
    @ResponseBody
    public Object search() {
        return null;
    }

    @GetMapping(value = "/history")
    @ResponseBody
    public Object getHistory() {

        return null;
    }

    @GetMapping(value = "/{email}")
    @ResponseBody
    public UserDTO getUserByEmail(@PathVariable("email") String email) {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(email);
        return userDTO;
    }

    // Post Mapping

    @PostMapping(value = "/auth")
    @ResponseBody
    public Object auth() {
        return null;
    }

    @PostMapping(value = "/register")
    @ResponseBody
    public Object register(@RequestBody Map<String, String> body) {
        String username = body.get("username");
        String password = body.get("password");
        String email = body.get("email");

        boolean result = userService.register(username, password, email);
        return result;
    }

    // Put Mapping

    @PutMapping(value = "/username")
    @ResponseBody
    public Object changeUsername(@RequestParam Map<String, String> param) {
        String newUsername = param.get("newUsername");
        boolean result = userService.changeUsername("ENCODED EMAIL HERE", newUsername);
        return result;
    }

    @PutMapping(value = "/password")
    @ResponseBody
    public Object changePassword(@RequestBody Map<String, String> body) {
        String newPassword = body.get("newPassword");
        boolean result = userService.changePassword("ENCODED EMAIL HERE", newPassword);
        return result;
    }
}

class UserDTO {
    private String email;

    public void setEmail(String email) {this.email = email;}

    public String getEmail(){
        return this.email;
    }
}
