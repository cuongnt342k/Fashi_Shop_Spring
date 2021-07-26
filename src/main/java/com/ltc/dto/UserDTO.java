package com.ltc.dto;

import com.ltc.model.Role;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Set;

public class UserDTO extends BaseDTO {

    @NotBlank
    private String userName;

    //    @NotBlank
    private String password;

    @NotBlank
    private String email;

    @NotBlank
    private String fullName;

    private String description;

    private Integer status;

    private Set<Role> roles;

    public UserDTO() {
    }

    public UserDTO(String userName, String password, String email, String fullName, String description, Integer status, Set<Role> roles) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.fullName = fullName;
        this.description = description;
        this.status = status;
        this.roles = roles;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String username) {
        this.userName = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
