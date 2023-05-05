package com.geekster.Employee.address.controller;
import com.geekster.Employee.address.model.Employee;
import com.geekster.Employee.address.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "employees")

public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping(value = "/getAllEmployees")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        List<Employee> getList=employeeService.getEmployeesDetails();
        return new ResponseEntity<>(getList, HttpStatus.OK);
    }

   @GetMapping(value = "/{id}")

    public ResponseEntity<Employee>GetById(@PathVariable Long id){
        Optional<Employee> details=employeeService.GetEmployeeById(id);
       return details.map(value -> new ResponseEntity<>(value, HttpStatus.FOUND))
               .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
   }

   @PostMapping(value = "/insert")
    public ResponseEntity<Employee> insertEmployee(@Valid @RequestBody Employee employee){
       Employee employeeObj=employeeService.newEmployee(employee);
        return new ResponseEntity<>(employeeObj,HttpStatus.CREATED);
   }

   @PutMapping(value = "/{id}")
    public ResponseEntity<Employee>updateEmployee(@PathVariable Long id, @Valid @RequestBody Employee employee){
        Optional<Employee>exist=employeeService.GetEmployeeById(id);
        if(exist.isPresent()){
            employee.setId(id);
            Employee update=employeeService.updateEmployeeDetailsById(employee);
            return new ResponseEntity<>(update,HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   }

   @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
       Optional<Employee>exist=employeeService.GetEmployeeById(id);
       if(exist.isPresent()){
           employeeService.delete(id);
           return  new ResponseEntity<>(HttpStatus.OK);
       }
       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   }
}
