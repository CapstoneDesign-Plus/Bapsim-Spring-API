package com.bapsim.sprapp.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/notice")
@AllArgsConstructor
public class NoticeController {

    // GetMapping

    @GetMapping(value = "/page")
    @ResponseBody
    public Object page(){
        return null;
    }

    @GetMapping(value = "/search")
    @ResponseBody
    public Object search() {
        return null;
    }

    @GetMapping(value = "/{articleId}")
    @ResponseBody
    public Object getArticle() {
        return null;
    }

    // Post Mapping

    @PostMapping(value = "/{articleId}")
    @ResponseBody
    public Object postArticle() {
        return null;
    }

    // Put Mapping

    @PutMapping(value = "/{articleId}")
    @ResponseBody
    public Object updateArticle() {
        return null;
    }

    // Delete Mapping

    @DeleteMapping(value = "/{articleId}")
    @ResponseBody
    public Object removeArticle() {
        return null;
    }
}
