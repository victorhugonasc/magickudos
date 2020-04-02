package org.example.kudos.controller;


import org.example.kudos.model.User;
import org.example.kudos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

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
    public User getSingleUser(@PathVariable String id, HttpServletResponse response)
    {
        for (User user : userList)
        {
            if (user.getId().contentEquals(id))
            {
                return user;
            }
        }
        response.setStatus(204);
        return null;
    }

    @DeleteMapping()
    public void deleteAllUsers()
    {
        userRepository.deleteAll();
        userList.clear();
    }

    @DeleteMapping("/id")
    public void deleteSingleUser(@PathVariable String id, HttpServletResponse response)
    {
        for (User user : userList)
        {
            if (user.getId().contentEquals(id))
            {
                userRepository.delete(user);
                userList.remove(user);
                break;
            }
        }
        response.setStatus(204);
    }
}
