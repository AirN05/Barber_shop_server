package com.server.service;


import com.server.entity.Employee;
import com.server.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService{

    @Autowired
    EmpRepository empRepository;
    public List<Employee> gettAll() {
        return empRepository.findAll();
    }

    public Employee getByID(Long id) {
        return empRepository.findOne(id);
    }

    public Employee save(Employee emp) {
        return empRepository.save(emp);
    }

    public void remove(Long id) {
        empRepository.delete(id);
    }
}
