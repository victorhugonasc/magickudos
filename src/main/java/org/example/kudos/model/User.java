package org.example.kudos.model;


import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;

public class User {
    @Id
    private String id;

    @NotBlank()
    private String name;

    @NotBlank()
    private String email;

    @NotBlank()
    private String password;

    @NotBlank()
    private ArrayList tags;


    public User(String name, String id, String email, String password, ArrayList tags) {
        super();
        this.name = name;
        this.id = id;
        this.email = email;
        this.password = password;
        this.tags = tags;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public ArrayList getTags() { return tags; }
    public void setTags(ArrayList tags) { this.tags = tags; }
}
