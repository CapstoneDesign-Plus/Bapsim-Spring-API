package com.bapsim.sprapp.controller;

import com.bapsim.sprapp.model.User;
import com.bapsim.sprapp.model.UserDTO;
import com.bapsim.sprapp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    // GetMapping

    @GetMapping(value = "/list")
    @ResponseBody
    public List<UserDTO> page(@RequestParam Map<String, String> query){
        return userService.getUserPage(
                Integer.parseInt(query.get("page")),
                Integer.parseInt(query.get("per"))
        );
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
        return userService.getUserDTOByEmail(email);
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

