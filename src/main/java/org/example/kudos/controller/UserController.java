package org.example.kudos.controller;


import org.example.kudos.model.User;
import org.example.kudos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin (origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    public UserController() {
        super();
     }

    @PostMapping()
    public User createUser(@RequestBody User user,HttpServletResponse response)
    {
        userRepository.save(new User(user.getName(),user.getUser(),user.getId(),user.getEmail(),user.getPassword()));
        response.setStatus(201);
        return user;
    }

    @GetMapping
    public List<User> getUsers()
    {
        return userRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public User getSingleUser(@PathVariable String id, HttpServletResponse response)
    {

        if (userRepository.findById(id).isPresent())
        {
            return userRepository.findById(id).get();
        }

        response.setStatus(204);
        return null;
    }

    @DeleteMapping()
    public void deleteAllUsers()
    {
        userRepository.deleteAll();
    }

    @DeleteMapping(path = "/{id}")
    public void deleteSingleUser(@PathVariable String id, HttpServletResponse response) {


        if (userRepository.findById(id).isPresent())
        {
            userRepository.delete(userRepository.findById(id).get());
            return;
        }

        response.setStatus(404);
    }
}
