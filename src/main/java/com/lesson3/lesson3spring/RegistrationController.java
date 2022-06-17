package com.lesson3.lesson3spring;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegistrationController {
    private UserRepository userRepo;
    private PasswordEncoder passwordEncoder;
//    private RoleRepository roleRepository;
    public RegistrationController(
            UserRepository userRepo, PasswordEncoder passwordEncoder /*, RoleRepository roleRepository*/) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        //this.roleRepository = roleRepository;
    }
    @GetMapping
    public String registerForm() {
        return "registration";
    }
    @PostMapping
    //@Transactional
    public String processRegistration(RegistrationForm form) {
        User user = form.toUser(passwordEncoder);
        user.addRole(new Role(1,  "ROLE_USER"));
        userRepo.save(user);

        return "redirect:/login";
    }
}


