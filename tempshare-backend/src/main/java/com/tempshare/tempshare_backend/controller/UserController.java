package com.tempshare.tempshare_backend.controller;

import com.tempshare.tempshare_backend.model.UserModel;
import com.tempshare.tempshare_backend.repository.UserRepository;
import com.tempshare.tempshare_backend.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("localhost:5173")
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

    @GetMapping("/{id}")
    public UserModel getUser(@PathVariable Long id) {
        return userService.getUserById(id);
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

    @DeleteMapping("/{id}")
    public String deleteUserID(@PathVariable Long id){
        userService.deleteUserId(id);
        return "Successfully deleted!";
    }
}
