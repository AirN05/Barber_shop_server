package com.server.controller;

import com.server.CreaterImage;
import com.server.IPaddress;
import com.server.entity.Home;
import com.server.Lists.ListImage;
import com.server.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;



@RestController
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private HomeService service;

    @RequestMapping(value="/get",method = RequestMethod.GET)
    @ResponseBody
    public ListImage getAllImages(){
        List<Home> list=service.gettAll();
        ListImage listImage=new ListImage();

        for (int i=0;i<list.size();i++){
            list.get(i).setImage(IPaddress.IPPORT.toString()+list.get(i).getImage());
        }
        listImage.setLast(list);
        return listImage;
    }


    @RequestMapping(value="/get/{name}",method = RequestMethod.GET)
    @ResponseBody
    private void getImage(@PathVariable("name") String searchName,HttpServletResponse response)throws IOException {

        searchName=searchName+".jpg";
        String path="images/home/"+searchName;
        byte[] image=CreaterImage.getImageByte(searchName,path);
        response.setContentLength((int) image.length);
        ServletOutputStream outStream = response.getOutputStream();
        outStream.write(image);
        outStream.close();
}

    @RequestMapping(value="/get",method = RequestMethod.POST)
    @ResponseBody
    private Home saveImage(@RequestBody Home home_image) {
        return service.save(home_image);
    }

    @RequestMapping(value="/get/{id}",method = RequestMethod.POST)
    @ResponseBody
    private void deleteImage(@PathVariable("id") long searchID) {
        service.remove(searchID);
    }
}
