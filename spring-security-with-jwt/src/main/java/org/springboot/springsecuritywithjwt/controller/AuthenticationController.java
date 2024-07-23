package org.springboot.springsecuritywithjwt.controller;

import org.springboot.springsecuritywithjwt.dto.LoginEmployeeDto;
import org.springboot.springsecuritywithjwt.dto.RegisterEmployeeDto;
import org.springboot.springsecuritywithjwt.entity.Employee;
import org.springboot.springsecuritywithjwt.response.LoginResponse;
import org.springboot.springsecuritywithjwt.service.AuthenticationService;
import org.springboot.springsecuritywithjwt.service.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for handling authentication-related requests.
 */
@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    private final JwtService jwtService;
    private final AuthenticationService authenticationService;

    /**
     * Constructor to initialize AuthenticationController with necessary services.
     *
     * @param jwtService the service to handle JWT operations.
     * @param authenticationService the service to handle authentication operations.
     */
    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    /**
     * Endpoint for user registration.
     *
     * @param registerEmployeeDto the data transfer object containing registration details.
     * @return ResponseEntity containing the registered Employee.
     */
    @PostMapping("/signup")
    public ResponseEntity<Employee> register(@RequestBody RegisterEmployeeDto registerEmployeeDto) {
        Employee registeredEmployee = authenticationService.signup(registerEmployeeDto);
        return ResponseEntity.ok(registeredEmployee);
    }

    /**
     * Endpoint for user login.
     *
     * @param loginEmployeeDto the data transfer object containing login details.
     * @return ResponseEntity containing the login response with JWT token and expiration time.
     */
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginEmployeeDto loginEmployeeDto) {
        Employee authenticatedEmployee = authenticationService.authenticate(loginEmployeeDto);
        String jwtToken = jwtService.generateToken(authenticatedEmployee);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }
}
