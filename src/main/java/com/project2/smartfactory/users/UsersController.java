package com.project2.smartfactory.users;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping("/users")
@RequiredArgsConstructor
@Controller
public class UsersController {

    private final UsersService usersService;


    @GetMapping("/signup")
    public String singUpUser(UsersForm usersForm) {
        return "users_form";
    }

    @PostMapping("/signup")
    public String signUpUser(@Valid UsersForm usersForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "users_form";
        }

        this.usersService.create(usersForm.getUserId(), usersForm.getPassword(), usersForm.getUsername(), usersForm.getEmail());
        return "index";
    }
    



}
