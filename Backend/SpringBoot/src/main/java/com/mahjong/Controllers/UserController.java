package com.mahjong.springboot;

import org.springframework.strereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.annotation.Resource;

@Controller
@RequestMapping(path="/User")
public class UserController {
    @Resource
    private UserRepository userRepository;

    @PostMapping(path="/Login_n_Signin")
    public String LoginUser(@RequestParam String username, @RequestParam String password) {
        private User user = userRepository.findByUsername(username);
        if (user == null) {
            User n = new User()
            n.setUsername(username);
            n.setPassword(password);
            userRepository.save(n);
            return "Saved";
        } else {
            if (user.getPassword() == password) {
                return "Logged in";
            } else {
                return "Wrong password";
            }
        }
    }
}