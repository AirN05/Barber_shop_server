package com.server.controller;


import com.server.entity.Employee;
import com.server.entity.Schedule;
import com.server.service.EmpService;
import com.server.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    private final int BEGIN_WORK_DAY=11;
    private final int END_WORK_DAY=13;

    @Autowired
    private EmpService empService;
    @Autowired
    private ScheduleService scheduleService;

    @RequestMapping(value="/get",method = RequestMethod.GET)
    @ResponseBody
    public List<Schedule> get(){
        List<Schedule> result=new ArrayList<Schedule>();
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd  HH:mm");
        String time = format.format(cal.getTime());
        Date dateToday=new Date();

        try {
            dateToday = format.parse(time);
        }catch (ParseException e){
            System.out.print("not converted");
        }
        List<Schedule> list=scheduleService.gettAll();
        for (int i=0;i<list.size();i++){
            if (list.get(i).getDate().after(dateToday)) {
                result.add(list.get(i));
            }
        }
        return result;
    }

    @RequestMapping(value="/set",method = RequestMethod.POST)
    @ResponseBody
    public void set(@RequestBody Schedule schedule){
        scheduleService.save(schedule);
    }

    @RequestMapping(value="/delete",method = RequestMethod.POST)
    @ResponseBody
    public void deleteOne(@RequestBody Long id){
        scheduleService.remove(id);

    }

    @RequestMapping(value="/generate",method = RequestMethod.GET)
    @ResponseBody
    public void generate(){
        int countDay=2;
        List<Employee> listEmp=empService.gettAll();

        for (int i=0;i<listEmp.size();i++){

            Date today = Calendar.getInstance().getTime();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
            String timeToday = dateFormat.format(today);
            //каждый день
            for (int j=0;j<countDay;j++){
                   //каждый час
                for (int k=BEGIN_WORK_DAY; k<=END_WORK_DAY; k++){
                    String currentDay=timeToday + " " + k + ":00";
                    Date date=new Date();
                    try {
                        DateFormat format = new SimpleDateFormat("yyyy.MM.dd HH:mm");
                        date = format.parse(currentDay);
                    }catch (ParseException e){
                        System.out.print("not converted");
                    }
                    Schedule schedule=new Schedule();
                    schedule.setReserve(0);
                    schedule.setId_res(0);
                    schedule.setId_emp(listEmp.get(i).getId_emp());
                    schedule.setDate(date);
                    scheduleService.save(schedule);
                }
                //увеличиваем день
                Calendar c = Calendar.getInstance();
                c.setTime(today);
                c.add(Calendar.DATE, 1);
                today = c.getTime();
                timeToday = dateFormat.format(today);
            }

        }

    }


    @RequestMapping(value="/delPeriod",method = RequestMethod.GET)
    @ResponseBody
    public void deletePeriod(Date dateFrom, Date dateTo){
        List<Schedule> list=scheduleService.gettAll();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
        Date currentDate=dateFrom;

        while(currentDate.before(dateTo)){
            for (int i=0;i<list.size();i++) {
              String timeItem = dateFormat.format(list.get(i).getDate());
              String currentTime=dateFormat.format(currentDate);
              if (timeItem.equals(currentTime)){
                  scheduleService.remove(list.get(i).getId_schedule());
              }
            }

            Calendar c = Calendar.getInstance();
            c.setTime(currentDate);
            c.add(Calendar.DATE, 1);
            currentDate = c.getTime();
        }

    }
}

