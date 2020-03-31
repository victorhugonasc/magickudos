package Controller;


import Model.User;
import Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    public UserController() {
        super();
    }

    @PostMapping
    public User createUser()
    {
        return new User("Victor","victorhugo","1","v@v.com","123456");
    }

    @GetMapping
    public List<User> getUsers()
    {
        return userRepository.findAll();
    }

}
