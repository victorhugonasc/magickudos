package org.example.kudos.model;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;

public class Team {
    @Id
    private String id;

    @NotBlank()
    private String name;

    private ArrayList<String> nicknames;

    private boolean visible;

    public Team(String id, @NotBlank() String name, ArrayList<String> nicknames) {
        this.id = id;
        this.name = name;
        this.nicknames = nicknames;
        this.visible = true;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public ArrayList<String> getNicknames() { return nicknames; }
    public void setNicknames(ArrayList<String> nicknames) { this.nicknames = nicknames; }
    public boolean isVisible() { return visible; }
    public void setVisible(boolean visible) { this.visible = visible; }
}
