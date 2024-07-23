package org.springboot.springsecuritywithjwt.controller;

import org.springboot.springsecuritywithjwt.entity.Employee;
import org.springboot.springsecuritywithjwt.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST controller for handling employee-related requests.
 */
@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    /**
     * Constructor to initialize EmployeeController with necessary services.
     *
     * @param employeeService the service to handle employee operations.
     */
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * Endpoint to get the authenticated employee's details.
     *
     * @return ResponseEntity containing the authenticated employee.
     */
    @GetMapping("/me")
    public ResponseEntity<Employee> authenticatedEmployee() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Employee currentEmployee = (Employee) authentication.getPrincipal();
        return ResponseEntity.ok(currentEmployee);
    }

    /**
     * Endpoint to get all employees.
     *
     * @return ResponseEntity containing a list of all employees.
     */
    @GetMapping("/getAllEmployees")
    public ResponseEntity<List<Employee>> allEmployees() {
        List<Employee> employees = employeeService.allEmployees();
        return ResponseEntity.ok(employees);
    }
}
