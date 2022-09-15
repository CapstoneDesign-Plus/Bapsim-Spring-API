package com.bapsim.springweb.controller.user;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController extends  AbstractUserController{

    static class TempResult {
        private String name = "";

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


    @RequestMapping(value = "/get")
    @ResponseBody
    public TempResult getUser() {
        TempResult result = new TempResult();
        result.setName("hell");
        return result;
    }
}
