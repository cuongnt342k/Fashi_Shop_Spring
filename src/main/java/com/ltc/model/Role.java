package com.ltc.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role extends BaseModel{
    @Column(name = "role_name", length = 30, nullable = false)
    private String roleName;

    @ManyToMany(mappedBy = "roles",fetch = FetchType.EAGER)
    @JsonBackReference
    private Set<User> users;

    public Role(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Role() {
    }

    public Role(String roleName, Set<User> users) {
        this.roleName = roleName;
        this.users = users;
    }
}
