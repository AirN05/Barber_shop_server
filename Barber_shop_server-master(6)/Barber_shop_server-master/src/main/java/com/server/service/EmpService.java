package com.server.service;


import com.server.entity.Employee;

import java.util.List;

public interface EmpService {

    List<Employee> gettAll();
    Employee getByID(Long id);
    Employee save(Employee emp);
    void remove(Long id);
}
