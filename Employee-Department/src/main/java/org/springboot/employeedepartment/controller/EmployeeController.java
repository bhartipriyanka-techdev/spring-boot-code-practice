package org.springboot.employeedepartment.controller;

import org.springboot.employeedepartment.repository.EmployeeRepository;
import org.springboot.employeedepartment.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employee/")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping
    public Object saveEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    @GetMapping(value = "/{employeeId}")
    public Employee findEmployeeById(@PathVariable(name = "employeeId") int employeeId) {
        Optional<Employee> rcvEmployee = employeeRepository.findById(employeeId);
        return rcvEmployee.orElse(null);
    }

    @GetMapping()
    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    @PutMapping(value = "/{employeeId}")
    public Employee updateEmployee(@RequestBody Employee employee){
        Optional<Employee> rcvEmployee = employeeRepository.findById(employee.getEmployeeId());
        return rcvEmployee.map(dbEmployee -> {
            dbEmployee.setEmployeeName(employee.getEmployeeName());
            dbEmployee.setEmployeeDesg(employee.getEmployeeDesg());
            dbEmployee.setEmployeePhone(employee.getEmployeePhone());
            dbEmployee.setEmployeeSalary(employee.getEmployeeSalary());
            dbEmployee.setEmployeePassword(employee.getEmployeePassword());
            return employeeRepository.save(dbEmployee);
        }).orElse(null);
    }

    @DeleteMapping(value = "/{employeeId}")
    public String deleteEmployee(@PathVariable(name = "employeeId")int employeeId){
        Optional<Employee> rcvEmployee = employeeRepository.findById(employeeId);
        if(rcvEmployee.isPresent()){
            employeeRepository.delete(rcvEmployee.get());
            return "Employee deleted Successfully....!";
        } else {
            return "Can't Delete Employee";
        }
    }

   /* @GetMapping(value = "/find-employee-by-desg/{desg}")
    public List<Employee> findEmployeeByDesg(@PathVariable(name = "desg") String employeeDesg){
        return employeeRepository.findByDesg(employeeDesg);
    }

    @GetMapping(value = "/find-employee-by-name/{name}")
    public List<Employee> findEmployeeByName(@PathVariable(name = "name") String employeeName){
        return employeeRepository.findByName(employeeName);
    }*/
}
