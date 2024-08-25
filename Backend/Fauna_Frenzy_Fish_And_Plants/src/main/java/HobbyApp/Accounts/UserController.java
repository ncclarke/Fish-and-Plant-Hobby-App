package HobbyApp.Accounts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    private String success = "{\"message\":\"success\"}";
    private String failure = "{\"message\":\"failure\"}";

    private String failure2 = "{\"message\":\"A user with that name already exists.\"}";

    private String failure4 = "{\"message\":\"failure wrong password\"}";

    private String failure5 = "{\"message\":\"passwords do not match\"}";

    @GetMapping(path = "/users")
    List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping(path = "/users/{id}")
    User getUserById(@PathVariable int id) {
        return userRepository.findById(id);
    }

    @GetMapping(path = "/usersU/{username}")
    User getUserByUsername(@PathVariable String username) {
        return userRepository.findByuserName(username);
    }

    @GetMapping(path = "/login/{userName}")
    String login(@PathVariable String userName, @RequestParam(value = "password", defaultValue = "failed") String message) {
        if (userRepository.findByuserName(userName).getPassword().equals(message)) {
            //return userRepository.findByuserName(userName);
            userRepository.findByuserName(userName).setActive(true);
            userRepository.save(userRepository.findByuserName(userName));
            return success;
        }
        return failure;
        //return userRepository.findByuserName(userName);
    }

    @GetMapping(path = "/logout/{userName}")
    String logout(@PathVariable String userName) {
        userRepository.findByuserName(userName).setActive(false);
        userRepository.save(userRepository.findByuserName(userName));
        return success;
        //return userRepository.findByuserName(userName);
    }

    @PostMapping(path = "/signup")
    String createUser(@RequestBody User user) {
        if (user == null)
            return failure;
        if (userRepository.findByuserName(user.getUserName()) != null) {
            return failure2;
        }
        userRepository.save(user);
        userRepository.save(userRepository.findByuserName(user.getUserName()));
        return success;
    }

    @PutMapping("/users/{id}")
    User updateUser(@PathVariable int id, @RequestBody User request) {
        User user = userRepository.findById(id);
        if (user == null)
            return null;
        userRepository.save(request);
        return userRepository.findById(id);
    }

    @DeleteMapping(path = "/users/{id}")
    String deleteUser(@PathVariable int id) {
        //userRepository.deleteById(id);

        User user = userRepository.findById(id);
        if (user != null) {
            // Delete the person
            userRepository.delete(user);
        }
        return success;
    }

    @DeleteMapping(path = "/usersU/{userName}")
    String deleteUser(@PathVariable String userName) {
        //userRepository.deleteById(userRepository.findByuserName(userName).getId());
        User user = userRepository.findByuserName(userName);
        if (user != null) {
            // Delete the person
            userRepository.delete(user);
        }
        return success;
    }
    




}
