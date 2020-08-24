package org.example.kudos.controller;


import org.example.kudos.model.User;
import org.example.kudos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@CrossOrigin (origins = {"http://localhost:3000", "https://magickudos-frontend.herokuapp.com"})
public class UserController {

    @Autowired
    private UserRepository userRepository;

    public UserController() {
        super();
     }

    @PostMapping()
    public int createUser(@RequestBody User user,HttpServletResponse response)
    {
        if (user.getName() != null && user.getEmail()!= null && user.getPassword()!= null) {
            userRepository.save(user);
            response.setStatus(201);
        }

        else {
            response.setStatus(400); //If at least one field is empty, return bad request
        }

        return response.getStatus();
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

    @PutMapping(path = "/{id}")
    public int updateSingleUser(@PathVariable String id,@RequestBody User user, HttpServletResponse response)
    {
        Optional<User> userOptional = userRepository.findById(id);

        if (!userOptional.isPresent()) {
            response.setStatus(204);
        }

        else{
            user.setId(id);
            userRepository.save(user);
        }
        return response.getStatus();
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
