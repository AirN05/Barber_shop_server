package com.server.repository;


import com.server.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmpRepository extends JpaRepository<Employee,Long> {
}
