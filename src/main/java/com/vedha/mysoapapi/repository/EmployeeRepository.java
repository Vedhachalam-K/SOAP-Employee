package com.vedha.mysoapapi.repository;

import com.example.employee.service.Employee;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeRepository {

    private static final Map<String, Employee> emps = new HashMap<>();

    @PostConstruct
    public void init(){
        Employee emp1 = new Employee();
        emp1.setId(1);
        emp1.setFirstname("Suzi");
        emp1.setLastname("Beats");
        emp1.setEmail("suzi@innova.com");
        emp1.setJobtitle("Co-Founder");
        emps.put("1", emp1);
    }

    /*public Employee findEmployee(int id){
        return emps.get(id);
    }*/

    public Employee findEmployee(String id){
        return emps.get(id);
    }
}

