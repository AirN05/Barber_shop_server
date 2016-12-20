package com.server.controller;
import com.server.Encrypter;
import com.server.Generator;
import com.server.entity.User;
import com.server.service.SenderEmail;
import com.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sender")
public class SenderEmailController {

    @Autowired
    private UserService service;

    @RequestMapping(value="/comment",method = RequestMethod.POST)
    @ResponseBody
    private String sendComment(@RequestBody String text){
        SenderEmail sslSender = new SenderEmail();
        sslSender.send("Comment",text, "mar-ogorodnikova@yandex.ru");
        return "done";
    }

    @RequestMapping(value="/newPass",method = RequestMethod.POST)
    @ResponseBody
    private String sendPass(@RequestBody User user){
        SenderEmail sslSender = new SenderEmail();
        List<User> list=service.gettAll();
        String result="false";
        User temp=new User();
        for(int i=0;i<list.size();i++){
            if (list.get(i).getEmail().equals(user.getEmail())){
                temp=list.get(i);
                result="done";
            }
        }
        if (result.equals("done")) {
            //изменить пароль у пользователя
            String newPass = Generator.generatePassword();
            String encodePass = Encrypter.encryptPassword(newPass);
            temp.setPassword(encodePass);

            //сохранили в бд
            service.save(temp);

            String text = "Ваш новый пароль: " + newPass + " .Поменять пароль вы можете в личном кабинете.";
            sslSender.send("Изменение пароля в  приложении Underground.", text, user.getEmail());
        }
        return result;
    }
}
