package com.bapsim.sprapp.controller;

import com.bapsim.sprapp.model.User;
import com.bapsim.sprapp.model.UserDTO;
import com.bapsim.sprapp.service.TicketService;
import com.bapsim.sprapp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/user")
@AllArgsConstructor
public class UserController {

    private final TicketService ticketService;
    private final UserService userService;

    // GetMapping

    @GetMapping(value = "/list")
    @ResponseBody
    public List<UserDTO> page(@RequestParam Map<String, String> query){
        int page, per;
        try {
            page = Integer.parseInt(query.get("page"));
            per = Integer.parseInt(query.get("per"));
        }
        catch (NumberFormatException e){
            return Collections.emptyList();
        }
        return userService.getUserPage(page, per);
    }

    @GetMapping(value = "/search")
    @ResponseBody
    //todo: 유저명 또는 가입날짜로 찾기
    public List<UserDTO> search() {
        return null;
    }

    @GetMapping(value = "/history/{email}")
    @ResponseBody
    public Object getHistory(@PathVariable("email") String email) {
        return ticketService.getHistory(email);
    }

    @GetMapping(value = "/{email}")
    @ResponseBody
    public UserDTO getUserByEmail(@PathVariable("email") String email) {
        return userService.getUserDTOByEmail(email);
    }

    // Post Mapping

    @PostMapping(value = "/auth")
    @ResponseBody
    // todo
    public Object auth() {
        return null;
    }

    @PostMapping(value = "/register")
    @ResponseBody
    public int register(@RequestBody Map<String, String> body) {
        String username = body.get("username");
        String password = body.get("password");
        String email = body.get("email");
        boolean result = userService.register(username, password, email);
        return result ? 200 : 400;
    }

    // Put Mapping

    @PutMapping(value = "/username")
    @ResponseBody
    public int changeUsername(@RequestBody Map<String, String> param) {
        String newUsername = param.get("newUsername");
        boolean result = userService.changeUsername("ENCODED EMAIL HERE", newUsername);
        return result ? 200 : 400;
    }

    @PutMapping(value = "/password")
    @ResponseBody
    public int changePassword(@RequestBody Map<String, String> body) {
        String newPassword = body.get("newPassword");
        boolean result = userService.changePassword("ENCODED EMAIL HERE", newPassword);
        return result ? 200 : 400;
    }
}

