package com.project2.smartfactory.users;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    
    @GetMapping("/list")
    public String usersList(Model model) { 
        List<Users> usersList = this.usersService.getList();
        model.addAttribute("usersList", usersList);
        return "users_list";
    }

    @GetMapping(value = "/list/{id}")
    public String showEditForm(Model model, @PathVariable("id") Integer id) {
        Users user = this.usersService.getUser(id);
        model.addAttribute("user", user);
        return "user_edit";

    }

    @PutMapping("/list/{id}")
    public String updateUser(@PathVariable("id") Integer id, @Valid UsersForm usersForm, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "user_edit";
        }
        this.usersService.updateUser(id,usersForm);
        return "redirect:/users/list";
    }



}
