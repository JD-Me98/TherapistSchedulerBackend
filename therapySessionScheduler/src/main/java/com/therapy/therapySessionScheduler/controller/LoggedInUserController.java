package com.therapy.therapySessionScheduler.controller;

import com.therapy.therapySessionScheduler.model.LoggedInUser;
import com.therapy.therapySessionScheduler.service.LoggedInUserService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:3000")
public class LoggedInUserController {

    private final LoggedInUserService loggedInUserService;

    public LoggedInUserController(LoggedInUserService loggedInUserService) {
        this.loggedInUserService = loggedInUserService;
    }
    @PostMapping("/login/{id}")
    public void SaveUser(@PathVariable Long id){
        loggedInUserService.loginUser(id);
    }

    @DeleteMapping("/logout/{id}")
    public void logoutUser(@PathVariable Long id){
        loggedInUserService.logoutUser(id);
    }
}
