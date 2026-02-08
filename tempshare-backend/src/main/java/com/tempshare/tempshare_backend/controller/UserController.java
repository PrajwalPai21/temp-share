package com.tempshare.tempshare_backend.controller;

import com.tempshare.tempshare_backend.model.UserModel;
import com.tempshare.tempshare_backend.repository.UserRepository;
import com.tempshare.tempshare_backend.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserModel> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public UserModel createUser(@RequestBody UserModel userModel) {
        return userService.createUser(userModel);

    }

    @PutMapping("/{id}")
    public UserModel updateUser(
            @PathVariable Long id,
            @RequestBody UserModel userModel ){
        return userService.updateUser(id, userModel);
    }

}
