package com.springrestapi.crudapi.services;
import com.springrestapi.crudapi.entity.Student;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentServices {
    private List<Student> students = new ArrayList<>();
    public StudentServiceImpl(){
        students.add(new Student(101,"Priyanka","piya@gmail.com",999999999,"Patna"));
        students.add(new Student(102,"Bharti","pr@gmail.com",89765432,"Jehanabad"));
        students.add(new Student(103,"Khushi","pr@gmail.com",89765432,"Jehanabad"));

    }
    @Override
    public List<Student> getStudents() {
        return students;
    }

    @Override
    public Student getStudent(int id) {
        Student student = null;
        for(Student stu : students){
            if(student.getStudentId() == id){
                stu = student;
                break;
            }
        }

        return student;
    }

    @Override
    public Student addStudent(Student student) {
        students.add(student);
        return student;
    }

    @Override
    public Student updateStudent(int id, Student updatedStudent) {

        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if (student.getStudentId() == id) {
                updatedStudent.setStudentId(id);
                students.set(i, updatedStudent);
                return updatedStudent;
            }
        }
        return null;
    }

    @Override
    public void deleteStudent(int id) {
        students.removeIf(student -> student.getStudentId() == id);

    }

}
