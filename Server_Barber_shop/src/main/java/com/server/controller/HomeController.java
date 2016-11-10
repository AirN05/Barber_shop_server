package com.server.controller;

import com.server.entity.Home;
import com.server.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//  "http://172.30.212.221:8085/images/home/card1.jpg"

@RestController
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private HomeService service;

    @RequestMapping(value="/get",method = RequestMethod.GET)
    @ResponseBody
    public List<Home> getAllReminds(){
        List<Home> list=service.gettAll();
        return list;
    }
    @RequestMapping(value="/get/{id}",method = RequestMethod.GET)
    @ResponseBody
    private Home getRemind(@PathVariable("id") long searchID) {
        return service.getByID(searchID);
    }

    @RequestMapping(value="/get",method = RequestMethod.POST)
    @ResponseBody
    private Home saveRemind(@RequestBody Home home_image) {
        return service.save(home_image);
    }

    @RequestMapping(value="/get/{id}",method = RequestMethod.POST)
    @ResponseBody
    private void deleteRemind(@PathVariable("id") long searchID) {
        service.remove(searchID);
    }
}
