package org.example.kudos.model;


import org.springframework.data.annotation.Id;

public class User {
    private String name;
    private String user;
    @Id
    private String id;
    private String email;
    private String password;


    public User(String name, String user, String id, String email, String password) {
        super();
        this.name = name;
        this.user = user;
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
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

}
