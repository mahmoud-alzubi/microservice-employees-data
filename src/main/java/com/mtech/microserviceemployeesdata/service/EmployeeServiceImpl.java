package com.mtech.microserviceemployeesdata.service;

import com.mtech.microserviceemployeesdata.dao.EmployeeJpaDao;
import com.mtech.microserviceemployeesdata.entity.Employee;
import com.mtech.microserviceemployeesdata.exception.EmployeeNotFoundException;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private EmployeeJpaDao jpaDao;

    ////////////////////////////////////////////////////////////
    @Autowired
    public EmployeeServiceImpl(EmployeeJpaDao jpaDao) {
        this.jpaDao = jpaDao;
    }


    ////////////////////////////////////////////////////////////

    /**
     * @return
     */
    @Override
    public List<Employee> findAll() {
        logger.info("findAll()");
        List<Employee> employees = jpaDao.findAll();
        logger.info("/findAll()");
        return employees;
    }

    ////////////////////////////////////////////////////////////

    /**
     * @param id
     * @return
     */
    @Override
    public Employee findById(Integer id) {
        try {
            logger.info("findById({})", id);
            Optional<Employee> employeeOptional = jpaDao.findById(id);
            if (!employeeOptional.isPresent()) {
                throw new EmployeeNotFoundException("Employee not found!");
            }
            return employeeOptional.get();
        } finally {
            logger.info("/findById({})", id);
        }
    }


    ////////////////////////////////////////////////////////////

    /**
     * @param employee
     * @return
     */
    @Transactional
    @Override
    public Employee save(Employee employee) {
        logger.info("save({})", employee);
        Employee savedEmployee = jpaDao.save(employee);
        logger.info("/save()", employee);
        return savedEmployee;
    }

    ////////////////////////////////////////////////////////////

    /**
     * @param id
     * @return
     */
    @Transactional
    @Override
    public Employee update(Integer id, Employee employee) {
        try {
            logger.info("update({}, {})", id, employee);
            Optional<Employee> employeeOptional = jpaDao.findById(id);
            if (!employeeOptional.isPresent()) {
                throw new EmployeeNotFoundException("Employee not found!");
            }
            employee.setId(id);
            Employee saved = jpaDao.save(employee);
            return saved;

        } finally {
            logger.info("/update({}, {})", id, employee);
        }
    }

    ////////////////////////////////////////////////////////////

    /**
     * @param id
     */
    @Transactional
    @Override
    public void delete(Integer id) {
        try {
            logger.info("delete({})", id);
            Optional<Employee> employeeOptional = jpaDao.findById(id);
            if (!employeeOptional.isPresent()) {
                throw new EmployeeNotFoundException("Employee not found!");
            }

            Employee employee = employeeOptional.get();
            employee.setId(id);
            jpaDao.delete(employee);
        } finally {
            logger.info("/delete({})", id);
        }
    }
}
