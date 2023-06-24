package com.mtech.microserviceemployeesdata.dao;

import com.mtech.microserviceemployeesdata.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeJpaDaoImpl implements EmployeeJpaDao {

    private Logger logger = LoggerFactory.getLogger(getClass());
    private EntityManager entityManager;

    /////////////////////////////////////////////////////////////

    /**
     * @param entityManager
     */
    @Autowired
    public EmployeeJpaDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /////////////////////////////////////////////////////////////

    /**
     * @return
     */
    @Override
    public List<Employee> findAll() {
        logger.debug("findAll()");
        TypedQuery<Employee> employeeTypedQuery = entityManager.createQuery("FROM Employee", Employee.class);
        List<Employee> employeeList = employeeTypedQuery.getResultList();
        logger.debug("/findAll()");
        return employeeList;
    }

    /////////////////////////////////////////////////////////////

    /**
     * @param id
     * @return
     */
    @Override
    public Optional<Employee> findById(Integer id) {
        logger.debug("findById()");
        Employee employee = entityManager.find(Employee.class, id);
        logger.debug("/findById()");
        return Optional.ofNullable(employee);
    }

    /////////////////////////////////////////////////////////////

    /**
     * @param employee
     * @return
     */
    @Override
    public Employee save(Employee employee) {
        logger.debug("save({})", employee);
        Employee merged = entityManager.merge(employee);
        logger.debug("/save({})", merged);
        return merged;
    }

    /////////////////////////////////////////////////////////////

    /**
     * @param employee
     */
    @Override
    public void delete(Employee employee) {
        logger.debug("delete({})", employee);
        entityManager.remove(employee);
        logger.debug("/delete({})", employee);
    }


}
