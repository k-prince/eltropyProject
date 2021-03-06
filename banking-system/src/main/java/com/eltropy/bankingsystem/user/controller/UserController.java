package com.eltropy.bankingsystem.user.controller;

import com.eltropy.bankingsystem.user.entity.User;
import com.eltropy.bankingsystem.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/bankingsystem/user/")
public class UserController
{
    @Autowired
    private UserRepository repo;

    @GetMapping("signup")
    public String signUpForm(Model model){
        model.addAttribute("user", new User());
        return "signup_form";
    }

    @PostMapping("register/admin")
    public String registerAdmin(User user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setRole("ADMIN");
        repo.save(user);
        return "register_success";
    }

    @GetMapping("/list_users")
    public String viewUsersList(Model model){
        List<User> listUsers = repo.findAll();
        model.addAttribute("listUsers", listUsers);
        return "users_list";
    }

}
