package com.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class AdminController {
    @RequestMapping(method= RequestMethod.GET)
    public ModelAndView admin(){
        return new ModelAndView("index");
    }
}
