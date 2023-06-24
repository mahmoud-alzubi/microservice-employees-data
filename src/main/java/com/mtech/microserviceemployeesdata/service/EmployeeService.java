package com.mtech.microserviceemployeesdata.service;

import com.mtech.microserviceemployeesdata.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(Integer integer);

    Employee save(Employee employee);

    Employee update(Integer id, Employee employee);

    void delete(Integer id);

}
