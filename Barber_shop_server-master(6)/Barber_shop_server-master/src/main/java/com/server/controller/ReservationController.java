package com.server.controller;

import com.server.IPaddress;
import com.server.Lists.ListClearReservation;
import com.server.Lists.ListEmp;
import com.server.entity.*;
import com.server.service.*;
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
@RequestMapping("/res")
public class ReservationController {

    @Autowired
    private ReservationService resService;
    @Autowired
    private UserService userService;
    @Autowired
    private EmpService empService;
    @Autowired
    private PriceService priceService;
    @Autowired
    private ScheduleService scheduledService;


    @RequestMapping(value = "/getRes", method = RequestMethod.POST)
    @ResponseBody
    private ListClearReservation getRes(@RequestBody User user) {

        //определить текущее время
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd  HH:mm");
        String time = sdf.format(cal.getTime());
        Date dateToday = new Date();
        try {
            DateFormat format = new SimpleDateFormat("yyyy.MM.dd  HH:mm");
            dateToday = format.parse(time);
        } catch (ParseException e) {
            System.out.print("not converted");
        }

        List<ClearReservation> resResult = new ArrayList<ClearReservation>();
        List<Employee> empList = empService.gettAll();
        List<Price> priceList = priceService.gettAll();
        List<User> list = userService.gettAll();
        for (int i = 0; i < list.size(); i++) {
            if ((list.get(i).getEmail().equals(user.getEmail())) && (list.get(i).getPassword().equals(user.getPassword()))) {
                user.setId_user(list.get(i).getId_user());
                break;
            }
        }
        List<Reservation> resList = resService.gettAll();
        for (int i = 0; i < resList.size(); i++) {
            if (resList.get(i).getId_user() == user.getId_user()) {
                //если нашли данную бронь,теперь ее заполняем в resResult
                ClearReservation temp = new ClearReservation();
                if (resList.get(i).getTime().after(dateToday)) {

                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy  HH:mm");
                    String date = dateFormat.format(resList.get(i).getTime());
                    temp.setTime(date);

                    temp.setUser(user);
                    temp.setId_res(resList.get(i).getId_res());
                    for (int j = 0; j < empList.size(); j++) {
                        if (empList.get(j).getId_emp() == resList.get(i).getId_emp()) {
                            temp.setEmp(empList.get(j));
                            break;
                        }
                    }
                    for (int j = 0; j < priceList.size(); j++) {
                        if (priceList.get(j).getId_price() == resList.get(i).getId_price()) {
                            temp.setPrice(priceList.get(j));
                            break;
                        }
                    }
                    resResult.add(temp);
                }
            }
        }
        ListClearReservation last = new ListClearReservation();
        last.setLast(resResult);
        return last;
    }


    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    private List<ClearReservation> getRes() {
        //определить текущее время
//        Calendar cal = Calendar.getInstance();
//        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd  HH:mm");
//        String time = format.format(cal.getTime());
//        Date dateToday = new Date();
//        try {
//            dateToday = format.parse(time);
//        } catch (ParseException e) {
//            System.out.print("not converted");
//        }

        List<ClearReservation> resResult = new ArrayList<ClearReservation>();
        List<Employee> empList = empService.gettAll();
        List<Price> priceList = priceService.gettAll();
        List<User> userList = userService.gettAll();
        List<Reservation> resList = resService.gettAll();
        for (int i = 0; i < resList.size(); i++) {
            //если нашли данную бронь,теперь ее заполняем в resResult
            ClearReservation temp = new ClearReservation();
            //if (resList.get(i).getTime().after(dateToday)) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy  HH:mm");
                String date = dateFormat.format(resList.get(i).getTime());
                temp.setTime(date);
                temp.setId_res(resList.get(i).getId_res());
                for (int j = 0; j < userList.size(); j++) {
                    if (userList.get(j).getId_user() == resList.get(i).getId_user()) {
                        temp.setUser(userList.get(j));
                        break;
                    }
                }
                for (int j = 0; j < empList.size(); j++) {
                    if (empList.get(j).getId_emp() == resList.get(i).getId_emp()) {
                        temp.setEmp(empList.get(j));
                        break;
                    }
                }
                resResult.add(temp);
            }
        //}
        return resResult;
    }



    @RequestMapping(value="/getEmp",method = RequestMethod.POST)
    @ResponseBody
    private ListEmp getEmp(@RequestBody String city){
        List<Employee> empList=empService.gettAll();
        ListEmp list=new ListEmp();
        List<Employee> result=new ArrayList<Employee>();
        for (int i=0;i<empList.size();i++){
            if (empList.get(i).getCity().equals(city)){
                  empList.get(i).setImage(IPaddress.IPPORT.toString()+empList.get(i).getImage());
                  result.add(empList.get(i));
            }
        }
        list.setLast(result);
        return list;
    }

    @RequestMapping(value="/delete",method = RequestMethod.POST)
    @ResponseBody
    private String deleteRes(@RequestBody ReservationID res){
        List<User> list=userService.gettAll();
        for(int i=0;i<list.size();i++){
            if ((list.get(i).getEmail().equals(res.getUser().getEmail()))&&(list.get(i).getPassword().equals(res.getUser().getPassword()))){
                resService.remove(res.getId());
                return "done";
            }
        }
        return "";
    }


    @RequestMapping(value="/getTime",method = RequestMethod.POST)
    @ResponseBody
    private List<String> getTime(@RequestBody ClearReservation res){
        List<String> time=new ArrayList<String>();
        String chooseTime=res.getTime();
        List<Schedule> scheduleList=scheduledService.gettAll();

        Date dateChoose=new Date();
        try {
            DateFormat format = new SimpleDateFormat("yyyy.MM.dd HH:mm");
            dateChoose = format.parse(chooseTime);
        }catch (ParseException e){
            System.out.print("not converted");
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date dateTomorrow=generateDate(chooseTime);
        if (res.getEmp().getName()!=null) {
            for (int i = 0; i < scheduleList.size(); i++) {
                if ((scheduleList.get(i).getDate().before(dateTomorrow)) && (scheduleList.get(i).getDate().after(dateChoose)) && (scheduleList.get(i).getId_emp() == res.getEmp().getId_emp()) && (scheduleList.get(i).getReserve() == 0)) {

                    time.add(dateFormat.format(scheduleList.get(i).getDate()));
                }
            }
        }else{
            for (int i = 0; i < scheduleList.size(); i++) {
                if ((scheduleList.get(i).getDate().before(dateTomorrow)) && (scheduleList.get(i).getDate().after(dateChoose)) && (scheduleList.get(i).getReserve() == 0)) {
                    String itemDate=dateFormat.format(scheduleList.get(i).getDate());
                    boolean coincidenceDates=false;
                    for (int j=0;j<time.size();j++){
                        if (time.get(j)==itemDate){
                            coincidenceDates=true;
                        }
                    }
                    if (coincidenceDates) {
                        time.add(itemDate);
                    }
                }
            }
        }
         return time;
    }

    public Date generateDate(String date){

        String returnDate=date.substring(0,8);
        String day=date.substring(8,10);
        int dayInt=Integer.parseInt(day);
        dayInt++;
        returnDate+=String.valueOf(dayInt);

        Date dateChoose=new Date();
        try {
            DateFormat format = new SimpleDateFormat("yyyy.MM.dd");
            dateChoose = format.parse(returnDate);
        }catch (ParseException e){
            System.out.print("not converted");
        }
        return dateChoose;
    }


    @RequestMapping(value="/add",method = RequestMethod.POST)
    @ResponseBody
    private String addRes(@RequestBody ClearReservation res){
        Reservation reservation=new Reservation();
        List<User> list=userService.gettAll();
        User user=res.getUser();
        for(int i=0;i<list.size();i++) {
            if ((list.get(i).getEmail().equals(user.getEmail())) && (list.get(i).getPassword().equals(user.getPassword()))) {
                user.setId_user(list.get(i).getId_user());

                reservation.setId_user(user.getId_user());
                reservation.setId_emp(res.getEmp().getId_emp());
                reservation.setId_price(res.getPrice().getId_price());

                Date dateChoose = new Date();
                try {
                    DateFormat format = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
                    dateChoose = format.parse(res.getTime());
                } catch (ParseException e) {
                }

                reservation.setTime(dateChoose);

                List<Schedule> scheduleList = scheduledService.gettAll();

                for (int j = 0; j < scheduleList.size(); j++) {

                    if (scheduleList.get(j).getId_emp() == res.getEmp().getId_emp()) {

                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
                        String timeSchedule = dateFormat.format(scheduleList.get(j).getDate());
                        if (res.getTime().equals(timeSchedule)) {
                            if (scheduleList.get(j).getReserve() == 0) {
                                Schedule schedule = scheduleList.get(j);
                                schedule.setReserve(1);
                                resService.save(reservation);
                                schedule.setId_res(getIDRes(reservation));
                                scheduledService.saveOrUpdate(schedule);
                                return "done";
                            } else {
                                return "";
                            }
                        }
                    }
                }

            }
        }
        return "";
    }

    @RequestMapping(value="/checkEmp",method = RequestMethod.POST)
    @ResponseBody
    private Employee checkEmp(@RequestBody ClearReservation res){
        //проверять по времени, по резерву,по городу сотдрудника
        Employee employee=new Employee();
        Date dateChoose=new Date();
        try {
            DateFormat format = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
            dateChoose = format.parse(res.getTime());
        }catch (ParseException e){
            System.out.print("not converted");
        }
        List<Schedule> scheduleList=scheduledService.gettAll();
        for (int i=0;i<scheduleList.size();i++){
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
            String timeOfList = dateFormat.format(scheduleList.get(i).getDate());
            String timeOfRes=dateFormat.format(res.getTime());
            if ((timeOfList.equals(timeOfRes)) &&(scheduleList.get(i).getReserve()==0)){
                Employee emp=empService.getByID(scheduleList.get(i).getId_emp());
                if (emp.getCity()==res.getEmp().getCity()) {
                    return emp;
                }
            }
        }
        return employee;
    }

    public Long getIDRes(Reservation res){
        Long id=new Long(0);
        List<Reservation> list=resService.gettAll();
        for (int i=0;i<list.size();i++){
            if ((list.get(i).getId_price()==res.getId_price()&& (list.get(i).getId_emp()==res.getId_emp()))
                    && (list.get(i).getId_user()==res.getId_user())){

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
                String timeOfList = dateFormat.format(list.get(i).getTime());
                String timeOfRes=dateFormat.format(res.getTime());
                if (timeOfList.equals(timeOfRes)){
                    id=list.get(i).getId_res();
                }
            }
        }
        return id;
    }
}
