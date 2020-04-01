package Controller;

import Model.User;
import Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class TestController {

    @Autowired
    private UserRepository userRepository;

    public TestController() {
        super();
    }

    @PostMapping
    public void createUser(@RequestBody User user)
    {
        userRepository.save(new User(user.getName(),user.getUser(),user.getId(),user.getEmail(),user.getPassword()));
    }

    @GetMapping
    public List<User> getUsers()
    {
        return userRepository.findAll();
    }


}
