package org.springboot.springsecuritywithjwt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class RegisterEmployeeDto {
    private String employeeName;

    private String employeePassword;

    private String employeeEmail;
}
