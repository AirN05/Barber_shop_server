package com.server.controller;

import com.server.entity.Remind;
import com.server.service.ReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/hello")
public class MainController {

    @Autowired
    private ReminderService service;

    @RequestMapping(value="/get",method = RequestMethod.GET)
    @ResponseBody
    public List<Remind> getAllReminds(){
        List<Remind> list=service.gettAll();
        return list;
    }
    @RequestMapping(value="/get/{id}",method = RequestMethod.GET)
    @ResponseBody
    private Remind getRemind(@PathVariable("id") long searchID) {
        return service.getByID(searchID);
    }

    @RequestMapping(value="/get",method = RequestMethod.POST)
    @ResponseBody
    private Remind saveRemind(@RequestBody Remind remind) {
        return service.save(remind);
    }

    @RequestMapping(value="/get/{id}",method = RequestMethod.POST)
    @ResponseBody
    private void deleteRemind(@PathVariable("id") long searchID) {
        service.remove(searchID);
    }
}
