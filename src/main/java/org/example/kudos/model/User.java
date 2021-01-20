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
    private ArrayList<String> team;

    private ArrayList<String> nicknames;

    public User(String id, @NotBlank() String name, @NotBlank() ArrayList<String> team, ArrayList<String> nicknames) {
        this.id = id;
        this.name = name;
        this.team = team;
        this.nicknames = nicknames;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public ArrayList<String> getTeam() { return team; }
    public void setTeam(ArrayList<String> team) { this.team = team; }
    public ArrayList<String> getNicknames() { return nicknames; }
    public void setNicknames(ArrayList<String> nicknames) { this.nicknames = nicknames; }
}
