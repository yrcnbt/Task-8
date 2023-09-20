package com.example.task8.controller;

import com.example.task8.Service.UserService;
import com.example.task8.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/index")
    public String index(ModelMap model) {
        model.addAttribute("users", userService.getListUser());
        return "index";
    }

    @DeleteMapping(value = "/{id}/remove")
    public String remove(@PathVariable("id") Long id) {
        userService.removeUser(userService.getUserById(id));
        return "redirect:/users/index";
    }

    @PostMapping
    public String add(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users/index";
    }

    @GetMapping(value = "/add")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "add";
    }

    @GetMapping(value = "/{id}/edit")
    public String edit(ModelMap model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.getUserById(id));
        return "update";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
        userService.updateUser(id, user);
        return "redirect:/users/index";
    }

    @Autowired
    public void setUs(UserService userService) {
        this.userService = userService;
    }
}
