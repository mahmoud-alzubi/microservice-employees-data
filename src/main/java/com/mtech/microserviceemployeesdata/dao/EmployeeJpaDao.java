package com.mtech.microserviceemployeesdata.dao;

import com.mtech.microserviceemployeesdata.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeJpaDao {

    List<Employee> findAll();

    Optional<Employee> findById(Integer integer);

    Employee save(Employee employee);

    void delete(Employee employee);


}
