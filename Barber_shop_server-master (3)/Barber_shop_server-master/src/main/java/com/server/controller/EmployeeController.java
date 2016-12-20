package com.server.controller;


import com.server.CreaterImage;
import com.server.IPaddress;
import com.server.Lists.ListEmp;
import com.server.entity.Employee;
import com.server.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private EmpService service;

    @RequestMapping(value="/get",method = RequestMethod.GET)
    @ResponseBody
    public ListEmp getAllImages(){
        List<Employee> list=service.gettAll();
        ListEmp listImage=new ListEmp();

        for (int i=0;i<list.size();i++){
            list.get(i).setImage(IPaddress.IPPORT.toString()+list.get(i).getImage());
        }

        listImage.setLast(list);
        return listImage;
    }


    @RequestMapping(value="/get/{name}",method = RequestMethod.GET)
    @ResponseBody
    private void getImage(@PathVariable("name") String searchName, HttpServletResponse response)throws IOException {

        searchName=searchName+".jpg";
        String path="images/emp/"+searchName;
        byte[] image= CreaterImage.getImageByte(searchName,path);
        response.setContentLength((int) image.length);
        ServletOutputStream outStream = response.getOutputStream();
        outStream.write(image);
        outStream.close();
    }

    @RequestMapping(value="/get",method = RequestMethod.POST)
    @ResponseBody
    private Employee saveImage(@RequestBody Employee emp) {
        return service.save(emp);
    }

    @RequestMapping(value="/get/{id}",method = RequestMethod.POST)
    @ResponseBody
    private void deleteImage(@PathVariable("id") long searchID) {
        service.remove(searchID);
    }
}
