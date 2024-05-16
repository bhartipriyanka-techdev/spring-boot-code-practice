package org.springboot.employeedepartment.repository;

import org.springboot.employeedepartment.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
