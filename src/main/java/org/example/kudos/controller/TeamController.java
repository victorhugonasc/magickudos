package org.example.kudos.controller;

import org.example.kudos.model.Team;
import org.example.kudos.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teams")
@CrossOrigin(origins = {"http://localhost:3000", "https://magickudos-frontend.herokuapp.com"})
public class TeamController {
    @Autowired
    private TeamRepository teamRepository;

    public TeamController() {
        super();
    }

    @PostMapping()
    public int createTeam(@RequestBody Team team, HttpServletResponse response)
    {
        if (team.getName() != null) {
            teamRepository.save(team);
            response.setStatus(201);
        }
        else {
            response.setStatus(400);
        }
        return response.getStatus();
    }

    @GetMapping
    public List<Team> getTeams() { return teamRepository.findAll(); }

    @GetMapping(path = "/{id}")
    public Team getSingleTeam(@PathVariable String id, HttpServletResponse response)
    {
        if (teamRepository.findById(id).isPresent())
        {
            return teamRepository.findById(id).get();
        }
        response.setStatus(204);
        return null;
    }

    @PutMapping(path = "/{id}")
    public int addNicknameInSpecificTeam(@PathVariable String id,@RequestBody String nickname, HttpServletResponse response)
    {
        Optional<Team> teamOptional = teamRepository.findById(id);
        if (!teamOptional.isPresent()) {
            response.setStatus(204);
        }
        else{
            Team team = teamOptional.get();
            ArrayList<String> newNickname = team.getNicknames();
            if (newNickname == null) {
                ArrayList<String> firstNickname = new ArrayList();
                firstNickname.add(nickname);
                team.setNicknames(firstNickname);
            }
            else {
                newNickname.add(nickname);
                team.setNicknames(newNickname);
            }
            teamRepository.save(team);
        }
        return response.getStatus();
    }

    @DeleteMapping()
    public void deleteAllTeams()
    {
        teamRepository.deleteAll();
    }

    @DeleteMapping(path = "/{id}")
    public void deleteSingleTeam(@PathVariable String id, HttpServletResponse response) {
        if (teamRepository.findById(id).isPresent())
        {
            teamRepository.delete(teamRepository.findById(id).get());
            return;
        }
        response.setStatus(404);
    }
}
