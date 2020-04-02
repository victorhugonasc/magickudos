package org.example.kudos.controller;


import org.example.kudos.model.User;
import org.example.kudos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    private ArrayList<User> userList= new ArrayList<>();

    public UserController() {
        super();
    }

    @PostMapping()
    public User createUser(@RequestBody User user)
    {
        userRepository.save(new User(user.getName(),user.getUser(),user.getId(),user.getEmail(),user.getPassword()));
        userList.add(user);
        return user;
    }
    @GetMapping
    public List<User> getUsers()
    {
        return userRepository.findAll();
    }

    @GetMapping("/id")
    public User getSingleUser(@PathVariable String id)
    {
        for (User user : userList)
        {
            if (user.getId().contentEquals(id))
            {
                return user;
            }
        }

        return null;
    }

}
