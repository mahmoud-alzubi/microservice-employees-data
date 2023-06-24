package com.mtech.microserviceemployeesdata.rest;

import com.mtech.microserviceemployeesdata.entity.Employee;
import com.mtech.microserviceemployeesdata.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeRestController {

    private Logger logger = LoggerFactory.getLogger(getClass());
    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    ///////////////////////////////////////////////////////////////////////

    /**
     * @return
     */
    @GetMapping
    ResponseEntity<?> findAll() {
        try {
            logger.info("findAll()");
            List<Employee> employees = employeeService.findAll();
            return new ResponseEntity<>(employees, HttpStatus.OK);
        } finally {
            logger.info("/findAll()");
        }
    }

    ///////////////////////////////////////////////////////////////////////

    /**
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    ResponseEntity<?> findById(@PathVariable("id") Integer id) {
        try {
            logger.info("findById({})", id);
            Employee employee = employeeService.findById(id);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } finally {
            logger.info("/findById({})", id);
        }
    }

    ///////////////////////////////////////////////////////////////////////

    /**
     * @param employee
     * @return
     */
    @PostMapping
    ResponseEntity<?> save(@RequestBody Employee employee) {
        try {
            logger.info("save({})", employee);
            Employee savedEmployee = employeeService.save(employee);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
        } finally {
            logger.info("/save({})", employee);
        }
    }

    ///////////////////////////////////////////////////////////////////////

    /**
     * @param id
     * @return
     */
    @PutMapping("/{id}")
    ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody Employee employee) {
        try {
            logger.info("update({})", id);
            Employee updatedEmployee = employeeService.update(id, employee);
            return ResponseEntity.ok(updatedEmployee);
        } finally {
            logger.info("/update({})", id);
        }
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        try {
            logger.info("delete({})", id);
            employeeService.delete(id);
            return ResponseEntity.ok().build();
        } finally {
            logger.info("/delete({})", id);
        }
    }

}
