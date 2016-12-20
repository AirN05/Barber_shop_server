package com.server.controller;

import com.server.Lists.ListPrice;
import com.server.entity.Price;
import com.server.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/price")
public class PriceController {

    @Autowired
    private PriceService service;

    @RequestMapping(value="/get",method = RequestMethod.GET)
    @ResponseBody
    public ListPrice getAllReminds(){
        List<Price> listPrice=service.gettAll();
        ListPrice list=new ListPrice();
        list.setLast(listPrice);
        System.out.print("enter get PRICE \n");
        return list;
    }
    @RequestMapping(value="/get/{id}",method = RequestMethod.GET)
    @ResponseBody
    private Price getRemind(@PathVariable("id") long searchID) {
        return service.getByID(searchID);
    }


    @RequestMapping(value="/get",method = RequestMethod.POST)
    @ResponseBody
    private Price saveRemind(@RequestBody Price remind) {
        return service.save(remind);
    }

    @RequestMapping(value="/get/{id}",method = RequestMethod.POST)
    @ResponseBody
    private void deleteRemind(@PathVariable("id") long searchID) {
        service.remove(searchID);
    }
}
