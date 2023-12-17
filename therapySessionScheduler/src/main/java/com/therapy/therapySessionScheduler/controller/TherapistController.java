package com.therapy.therapySessionScheduler.controller;

import com.therapy.therapySessionScheduler.model.LoggedInUser;
import com.therapy.therapySessionScheduler.model.Therapist;
import com.therapy.therapySessionScheduler.service.LoggedInUserService;
import com.therapy.therapySessionScheduler.service.TherapistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class TherapistController {
    private final TherapistService therapistService;
    private final LoggedInUserService loggedInUserService;
    @Autowired
    public TherapistController(TherapistService therapistService, LoggedInUserService loggedInUserService) {
        this.therapistService = therapistService;
        this.loggedInUserService = loggedInUserService;
    }
    @PostMapping("/therapist/sign-up")
    public Therapist saveTherapist(@RequestBody Therapist therapist){
        return therapistService.saveTherapist(therapist);
    }
    @GetMapping("/therapist/therapists")
    public List<Therapist> getTherapists(){
        return therapistService.getAllTherapists();
    }
    @GetMapping("/therapist/username:{username}")
    public Therapist getTherapistByUsername(@PathVariable("username") String username){
        return therapistService.getTherapistByUsername(username);
    }
    @GetMapping("/therapist/{id}")
    public Therapist getTherapistByUsername(@PathVariable("id") Long id){
        return therapistService.getTherapistById(id);
    }

    @GetMapping("therapist/login/{username}/{password}")
    public Therapist authenticateTherapist(@PathVariable String username, @PathVariable String password){
        Therapist authenticatedTherapist=therapistService.login(username, password);
        if(authenticatedTherapist!=null){
            return authenticatedTherapist;
        }else{
            return null;
        }
    }
    @PostMapping("therapist/login/{id}")
    public void loginUser(@PathVariable Long id){
        loggedInUserService.loginUser(id);
    }
    @GetMapping("/therapist/logout/{id}")
    public void logoutUser(@PathVariable Long id){
        loggedInUserService.logoutUser(id);
    }
}
