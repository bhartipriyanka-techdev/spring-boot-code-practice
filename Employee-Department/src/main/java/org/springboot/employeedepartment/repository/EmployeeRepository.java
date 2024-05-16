package org.springboot.employeedepartment.repository;

import org.springboot.employeedepartment.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    /*List<Employee> findByDesg(String designation);

    List<Employee> findByName(String name);*/
}
