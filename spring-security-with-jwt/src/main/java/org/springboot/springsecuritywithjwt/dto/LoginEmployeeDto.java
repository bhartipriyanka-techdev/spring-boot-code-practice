package org.springboot.springsecuritywithjwt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginEmployeeDto {
    private String employeeEmail;

    private String employeePassword;

}
