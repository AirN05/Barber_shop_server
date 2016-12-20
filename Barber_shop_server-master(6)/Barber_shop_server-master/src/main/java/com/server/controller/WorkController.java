package com.server.controller;

import com.server.CreaterImage;
import com.server.IPaddress;
import com.server.Lists.ListImage;
import com.server.Lists.ListWork;
import com.server.entity.Work;
import com.server.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/work")
public class WorkController {

    @Autowired
    private WorkService service;

    @RequestMapping(value="/get",method = RequestMethod.GET)
    @ResponseBody
    public ListWork getAllImages(){
        List<Work> list=service.gettAll();
        ListWork listImage=new ListWork();

        for (int i=0;i<list.size();i++){
            list.get(i).setImage(IPaddress.IPPORT.toString()+list.get(i).getImage());
        }

        listImage.setLast(list);
        System.out.print("enter get Work \n");
        return listImage;
    }


    @RequestMapping(value="/get/{name}",method = RequestMethod.GET)
    @ResponseBody
    private void getImage(@PathVariable("name") String searchName, HttpServletResponse response)throws IOException {

        searchName=searchName+".jpg";
        String path="images/work/"+searchName;
        byte[] image= CreaterImage.getImageByte(searchName,path);
        response.setContentLength((int) image.length);
        ServletOutputStream outStream = response.getOutputStream();
        outStream.write(image);
        outStream.close();
    }

    @RequestMapping(value="/get",method = RequestMethod.POST)
    @ResponseBody
    private Work saveImage(@RequestBody Work work_image) {
        return service.save(work_image);
    }

    @RequestMapping(value="/get/{id}",method = RequestMethod.POST)
    @ResponseBody
    private void deleteImage(@PathVariable("id") long searchID) {
        service.remove(searchID);
    }
}
