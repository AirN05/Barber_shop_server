package com.server.controller;


import com.server.entity.Employee;
import com.server.entity.Schedule;
import com.server.service.EmpService;
import com.server.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class GenerateSchedule {

    @Autowired
    private static EmpService empService;

    @Autowired
    private static ScheduleService scheduleService;

    public static void generationSchedule(){

        List<Employee> listEmp=empService.gettAll();

//        for (int i=0;i<listEmp.size();i++){
//            Schedule schedule=new Schedule();
//            schedule.setReserve(0);
//            schedule.setId_emp(listEmp.get(i).getId_emp());
//
//            Date today = Calendar.getInstance().getTime();
//            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
//            String timeToday = dateFormat.format(today);
//        }



    }
}
