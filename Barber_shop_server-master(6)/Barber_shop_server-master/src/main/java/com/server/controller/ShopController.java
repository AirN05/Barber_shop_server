package com.server.controller;


import com.server.CreaterImage;
import com.server.IPaddress;
import com.server.Lists.ListShop;
import com.server.entity.Shop;
import com.server.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ShopService service;
    //private String ipPort="http://172.30.212.105:8085";

    @RequestMapping(value="/get",method = RequestMethod.GET)
    @ResponseBody
    public ListShop getAllReminds(){
        List<Shop> list=service.gettAll();
        ListShop listShop=new ListShop();

        for (int i=0;i<list.size();i++){
            list.get(i).setImage(IPaddress.IPPORT.toString()+list.get(i).getImage());
        }
        listShop.setLast(list);
        System.out.print("enter get SHOP \n");
        return listShop;
    }

    @RequestMapping(value="/get/{name}",method = RequestMethod.GET)
    @ResponseBody
    private void getImage(@PathVariable("name") String searchName,HttpServletResponse response)throws IOException {

        searchName=searchName+".png";
        String path="images/shop/"+searchName;
        byte[] image= CreaterImage.getImageByte(searchName,path);
        response.setContentLength((int) image.length);
        ServletOutputStream outStream = response.getOutputStream();
        outStream.write(image);
        outStream.close();
    }

    @RequestMapping(value="/get",method = RequestMethod.POST)
    @ResponseBody
    private Shop saveRemind(@RequestBody Shop shop_item) {
        return service.save(shop_item);
    }

    @RequestMapping(value="/get/{id}",method = RequestMethod.POST)
    @ResponseBody
    private void deleteRemind(@PathVariable("id") long searchID) {
        service.remove(searchID);
    }
}
