package com.telusko.controller;

import com.telusko.model.User;
import com.telusko.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private MyUserDetailsService userDetailsService;


    @PostMapping("/addUser")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        userDetailsService.saveUser(user);
        return ResponseEntity.ok("User registered successfully");
    }


}
