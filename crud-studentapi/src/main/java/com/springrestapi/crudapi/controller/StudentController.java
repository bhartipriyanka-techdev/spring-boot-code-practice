package com.springrestapi.crudapi.controller;

import com.springrestapi.crudapi.entity.Student;
import com.springrestapi.crudapi.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentServices studentServices;

    @GetMapping
    public List<Student> getStudents() {
        return studentServices.getStudents();
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id) {
        return studentServices.getStudent(id);
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentServices.addStudent(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student updatedStudent) {
        return studentServices.updateStudent(id, updatedStudent);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentServices.deleteStudent(id);
    }
}