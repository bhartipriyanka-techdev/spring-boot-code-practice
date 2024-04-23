package com.springrestapi.crudapi.services;


import com.springrestapi.crudapi.entity.Student;

import java.util.List;

public interface StudentServices {
    public List<Student> getStudents();
    public  Student getStudent(int id);

    public  Student addStudent(Student student);

    Student updateStudent(int id, Student updatedStudent);

    void deleteStudent(int id);
}
