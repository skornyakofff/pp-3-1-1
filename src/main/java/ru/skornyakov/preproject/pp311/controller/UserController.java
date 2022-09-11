package ru.skornyakov.preproject.pp311.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.skornyakov.preproject.pp311.model.User;
import ru.skornyakov.preproject.pp311.service.UserService;

@Controller
@RequestMapping(value = "/")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getAllUser(Model model){
        model.addAttribute("users", userService.getAllUser());
        return "users";
    }

    @GetMapping("/new")
    public String createUser(@ModelAttribute("user") User user) {
        return "/new";
    }

    @PostMapping("/users")
    public String addUser(@ModelAttribute("user") User user) {
        userService.createUser(user);
        return "redirect:/";
    }

    @GetMapping("users/edit/{id}")
    public String updateUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "/edit";
    }

    @PatchMapping("users/edit/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.updateUser(user);
        return "redirect:/";
    }

    @DeleteMapping("users/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUserById(id);
        return "redirect:/";
    }
}
