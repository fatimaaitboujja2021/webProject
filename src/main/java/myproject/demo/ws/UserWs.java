package myproject.demo.ws;


import myproject.demo.bean.User;
import myproject.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Chu/userWs")

public class UserWs {
    @Autowired
    private UserService userService;
    @GetMapping("/matricule/{matricule}")

    public User findByMatricule(String matricule) {
        return userService.findByMatricule(matricule);
    }

    @DeleteMapping("/username/{username}")
    public int deleteByUsername(@PathVariable String username) {
        return userService.deleteByUsername(username);
    }
    @PostMapping("/")
    public int save(@RequestBody User user) {
        return userService.save(user);
    }
    @PutMapping("/")

    public User update(@RequestBody User user) {
        return userService.update(user);
    }
    @PostMapping("/delete-multiple-by-username")
    public int deleteByUsername(@RequestBody List<User> users) {
        return userService.deleteByUsername(users);
    }
@GetMapping("/")
    public List<User> findAll() {
        return userService.findAll();
    }
}
