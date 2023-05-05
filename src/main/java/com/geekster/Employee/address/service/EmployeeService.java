package com.geekster.Employee.address.service;

import com.geekster.Employee.address.model.Employee;
import com.geekster.Employee.address.repository.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeDao employeeDao;

    public List<Employee> getEmployeesDetails() {
        return employeeDao.findAll();
    }

    public Optional<Employee> GetEmployeeById(Long id) {
        return employeeDao.findById(id);
    }

    public Employee newEmployee(Employee employee) {
        return employeeDao.save(employee);
    }


    public Employee updateEmployeeDetailsById(Employee employee) {
        return employeeDao.save(employee);
    }


    public void delete(Long id) {
        employeeDao.deleteById(id);
    }
}
