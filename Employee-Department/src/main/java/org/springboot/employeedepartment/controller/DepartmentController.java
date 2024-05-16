package org.springboot.employeedepartment.controller;

import org.springboot.employeedepartment.entity.Department;
import org.springboot.employeedepartment.entity.Employee;
import org.springboot.employeedepartment.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/department/")
public class DepartmentController {
    @Autowired
    private DepartmentRepository departmentRepository;

    @PostMapping
    public Object saveEmployee(@RequestBody Department department){
        return departmentRepository.save(department);
    }

    @GetMapping(value = "/{departmentId}")
    public Department findDepartmentById(@PathVariable(name = "departmentId") int departmentId) {
        Optional<Department> rcvDepartment = departmentRepository.findById(departmentId);
        return rcvDepartment.orElse(null) ;
    }

    @GetMapping()
    public List<Department> findAll(){
        return departmentRepository.findAll();
    }
    @PutMapping(value = "/{departmentId}")
    public Department updateDepartment(@RequestBody Department department){
        Optional<Department> rcvDepartment = departmentRepository.findById(department.getDepartmentId());
        return rcvDepartment.map(dbDepartment -> {
            dbDepartment.setDepartmentName(department.getDepartmentName());
            dbDepartment.setDepartmentLocation(department.getDepartmentLocation());
            return departmentRepository.save(dbDepartment);
        }).orElse(null);
    }
}
