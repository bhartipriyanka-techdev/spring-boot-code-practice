package org.springboot.springsecuritywithjwt.service;

import org.springboot.springsecuritywithjwt.dto.LoginEmployeeDto;
import org.springboot.springsecuritywithjwt.dto.RegisterEmployeeDto;
import org.springboot.springsecuritywithjwt.entity.Employee;
import org.springboot.springsecuritywithjwt.repository.EmployeeRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Service class for handling authentication and registration operations.
 */
@Service
public class AuthenticationService {
    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    /**
     * Constructor to initialize AuthenticationService with necessary dependencies.
     *
     * @param employeeRepository the repository to manage employee data.
     * @param authenticationManager the manager to handle authentication.
     * @param passwordEncoder the encoder to hash passwords.
     */
    public AuthenticationService(
            EmployeeRepository employeeRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.employeeRepository = employeeRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Registers a new employee.
     *
     * @param input the data transfer object containing registration details.
     * @return the registered employee.
     */
    public Employee signup(RegisterEmployeeDto input) {
        Employee employee = new Employee();
        employee.setEmployeeEmail(input.getEmployeeEmail());
        employee.setEmployeeName(input.getEmployeeName());
        employee.setEmployeePassword(passwordEncoder.encode(input.getEmployeePassword()));
        return employeeRepository.save(employee);
    }

    /**
     * Authenticates an existing employee.
     *
     * @param input the data transfer object containing login details.
     * @return the authenticated employee.
     * @throws RuntimeException if authentication fails or employee not found.
     */
    public Employee authenticate(LoginEmployeeDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmployeeEmail(),
                        input.getEmployeePassword()
                )
        );

        return employeeRepository.findByEmployeeEmail(input.getEmployeeEmail())
                .orElseThrow(RuntimeException::new);
    }
}
