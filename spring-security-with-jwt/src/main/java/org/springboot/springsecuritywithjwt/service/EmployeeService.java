package org.springboot.springsecuritywithjwt.service;

import org.springboot.springsecuritywithjwt.entity.Employee;
import org.springboot.springsecuritywithjwt.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service class for handling operations related to employees.
 */
@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    /**
     * Constructor to initialize EmployeeService with necessary dependencies.
     *
     * @param employeeRepository the repository to manage employee data.
     */
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    /**
     * Retrieves all employees from the repository.
     *
     * @return a list of all employees.
     */
    public List<Employee> allEmployees() {
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAll().forEach(employees::add);
        return employees;
    }
}
