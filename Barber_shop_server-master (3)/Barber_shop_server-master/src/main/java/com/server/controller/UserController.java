package com.server.controller;


import com.server.entity.User;
import com.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping(value="/check",method = RequestMethod.POST)
    @ResponseBody
    public User getUser(@RequestBody User user) {
        User newUser=new User();
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/barbershop","root","root");
//            Statement st=conn.createStatement();
//            String query="SELECT * FROM user WHERE email="+user.getEmail()+" AND password="+user.getPassword();
//            ResultSet rs=st.executeQuery(query);
//            while(rs.next()){
//                user.setId_user(rs.getLong("id_user"));
//                user.setName(rs.getString("name"));
//                user.setPhone(rs.getString("phone"));
//                user.setPurpose(rs.getString("purpose"));
//                return user;
//
//            }
//        }catch (SQLException e){}
//        catch (ClassNotFoundException e){}


        List<User> list=service.gettAll();
        for(int i=0;i<list.size();i++){
            if ((list.get(i).getEmail().equals(user.getEmail()))&&(list.get(i).getPassword().equals(user.getPassword()))){
                User tempUser=list.get(i);
                return tempUser;
            }
        }
        return newUser;
    }

    @RequestMapping(value="/set",method = RequestMethod.POST)
    @ResponseBody
    public User setUser(@RequestBody User user) {
        User newUser=new User();
        List<User> list=service.gettAll();
        for(int i=0;i<list.size();i++){
            if (list.get(i).getEmail().equals(user.getEmail())){
                return newUser;
            }
        }

        service.save(user);
        newUser=user;
        return newUser;
    }

    @RequestMapping(value="/delete",method = RequestMethod.POST)
    @ResponseBody
    public User deleteUser(@RequestBody User user) {
        List<User> list=service.gettAll();
        User response=new User();
        for(int i=0;i<list.size();i++){
            if (list.get(i).getEmail().equals(user.getEmail())&& (list.get(i).getPassword().equals(user.getPassword()))){
                user.setId_user(list.get(i).getId_user());
                service.remove(user.getId_user());
                return user;
            }
        }
        return response;
    }
    @RequestMapping(value="/change",method = RequestMethod.POST)
    @ResponseBody
    public List<User> changeUser(@RequestBody  List<User> users) {
        List<User> list=service.gettAll();
        for(int i=0;i<list.size();i++){
            if ((list.get(i).getEmail().equals(users.get(0).getEmail()))&& (list.get(i).getPassword().equals(users.get(0).getPassword()))){
                users.get(1).setId_user(list.get(i).getId_user());
                service.save(users.get(1));
                list.clear();
                list.add(users.get(1));
                return list;
            }
        }
        list.clear();
        return list;
    }
}
