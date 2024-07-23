package org.springboot.springsecuritywithjwt.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee  implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int employeeId;


    @Column(nullable = false)
    private String employeeName;


    @Column(nullable = false)
    private String employeeEmail;

    @Column(nullable = false)
    private String employeePassword;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return employeePassword;
    }

    @Override
    public String getUsername() {
        return employeeEmail;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
