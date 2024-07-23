package org.springboot.springsecuritywithjwt.config;

import org.springboot.springsecuritywithjwt.repository.EmployeeRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * This class contains the security configuration for the Spring Boot application, specifically for
 * setting up authentication and user details services.
 */
@Configuration
public class ApplicationConfiguration {
    private final EmployeeRepository employeeRepository;

    /**
     * Constructor to initialize ApplicationConfiguration with EmployeeRepository.
     *
     * @param employeeRepository the repository to retrieve employee data.
     */
    public ApplicationConfiguration(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    /**
     * Defines the UserDetailsService bean that loads user-specific data.
     *
     * @return UserDetailsService implementation.
     */
    @Bean
    UserDetailsService userDetailsService() {
        return employeeName -> employeeRepository.findByEmployeeEmail(employeeName)
                .orElseThrow(() -> new UsernameNotFoundException("Employee not found"));
    }

    /**
     * Defines the BCryptPasswordEncoder bean that encodes passwords.
     *
     * @return an instance of BCryptPasswordEncoder.
     */
    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Defines the AuthenticationManager bean that provides authentication management.
     *
     * @param config the AuthenticationConfiguration to configure the manager.
     * @return an instance of AuthenticationManager.
     * @throws Exception if an error occurs during configuration.
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    /**
     * Defines the AuthenticationProvider bean that provides authentication using DAO-based user details service.
     *
     * @return an instance of AuthenticationProvider.
     */
    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }
}
