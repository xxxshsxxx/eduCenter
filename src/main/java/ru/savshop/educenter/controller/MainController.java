package ru.savshop.educenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController  {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String mainPage(){
        return "index";
    }

    @RequestMapping (value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }
}
