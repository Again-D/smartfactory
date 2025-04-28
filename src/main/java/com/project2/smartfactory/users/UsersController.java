package com.project2.smartfactory.users;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@RequestMapping("/users")
@RequiredArgsConstructor
@Controller
public class UsersController {

    private final UsersService usersService;


    @PostMapping("/create/{id}")
    public String createUser(@PathVariable("id") Integer id) {

    }



}
