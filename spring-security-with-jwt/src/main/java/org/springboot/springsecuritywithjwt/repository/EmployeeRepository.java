package org.springboot.springsecuritywithjwt.repository;

import org.springboot.springsecuritywithjwt.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //@Query("SELECT e FROM Employee e WHERE e.employeeEmail = :employeeEmail")

    Optional<Employee> findByEmployeeEmail(String employeeEmail);
}
