package com.server.controller;

import com.server.entity.Home;
import com.server.entity.ListImage;
import com.server.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.List;

//  "http://172.30.212.221:8085/home/get/{name}"

@RestController
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private HomeService service;
    private String ipPort="http://172.30.193.119:8085";

    @RequestMapping(value="/listImage",method = RequestMethod.GET)
    @ResponseBody
    public ListImage getAllReminds(){
        List<Home> list=service.gettAll();
        ListImage listImage=new ListImage();

        for (int i=0;i<list.size();i++){
            list.get(i).setImage(ipPort+list.get(i).getImage());
        }

        listImage.setList(list);
        return listImage;
    }
    @RequestMapping(value="/get/{name}",method = RequestMethod.GET)
    @ResponseBody
    private byte[] getRemind(@PathVariable("name") String searchName)throws IOException {

        searchName=searchName+".jpg";
        String path="images/home/"+searchName;
        String workDir = System.getProperty("user.dir");

        File file1 = new File(workDir, path);
        String fullFilename = file1.getAbsolutePath();
        System.out.println("Полный путь к файлу: " + fullFilename);

        File file=new File(fullFilename);
        ByteArrayOutputStream ous = null;
        InputStream ios = null;
        try {
            byte[] buffer = new byte[4096];
            ous = new ByteArrayOutputStream();
            ios = new FileInputStream(file);
            int read = 0;
            while ((read = ios.read(buffer)) != -1) {
                ous.write(buffer, 0, read);
            }
        }finally {
            try {
                if (ous != null)
                    ous.close();
            } catch (IOException e) {
            }

            try {
                if (ios != null)
                    ios.close();
            } catch (IOException e) {
            }
        }

        return ous.toByteArray();
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
