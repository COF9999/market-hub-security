package com.markethub.security.genesis_guard.infraestructure.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(unique = true)
    private String name;


    @JsonIgnoreProperties({"roles",
            "handler",
            "hibernateLazyInitializer"
    })
    @ManyToMany(mappedBy = "roles")
    private List<User> users = new ArrayList<>();


    public Role(){

    }
    public Role(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
