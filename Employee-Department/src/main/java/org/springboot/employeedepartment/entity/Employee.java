package org.springboot.employeedepartment.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;

    @Column(nullable = false)
    private String employeeName;

    @Column(nullable = false)
    private String employeeDesg;

    @Column(nullable = false)
    private double employeeSalary;

    @Column(nullable = false, unique = true)
    private long employeePhone;

    @Column(nullable = false)
    private String employeePassword;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Department> departments;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeDesg() {
        return employeeDesg;
    }

    public void setEmployeeDesg(String employeeDesg) {
        this.employeeDesg = employeeDesg;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public long getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(long employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeePassword() {
        return employeePassword;
    }

    public void setEmployeePassword(String employeePassword) {
        this.employeePassword = employeePassword;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }
}
