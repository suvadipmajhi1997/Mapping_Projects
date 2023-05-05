package com.geekster.Employee.address.repository;

import com.geekster.Employee.address.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao extends JpaRepository<Employee,Long> {
}
