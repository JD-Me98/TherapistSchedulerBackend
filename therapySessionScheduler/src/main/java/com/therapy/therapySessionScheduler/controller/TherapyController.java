package com.therapy.therapySessionScheduler.controller;

import com.therapy.therapySessionScheduler.model.Therapy;
import com.therapy.therapySessionScheduler.service.TherapyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class TherapyController {
    private TherapyService therapyService;
    @Autowired
    public TherapyController(TherapyService therapyService) {
        this.therapyService = therapyService;
    }
    @PostMapping("/therapy")
    public Therapy saveTherapy(@RequestBody Therapy therapy){
        return therapyService.saveTherapy(therapy);
    }

    @GetMapping("/therapy/categories")
    public List<Therapy> getAllTherapy(){
        return therapyService.therapyList();
    }

    @DeleteMapping("/therapy/delete/{specialty}")
    public void deleteBySpecialty(@PathVariable("specialty") String specialty){
        therapyService.deleteBySpecialty(specialty);
    }

    @GetMapping("/therapy/{specialty}/edit")
    public Therapy editTherapy(@PathVariable("specialty") String Specialty){
        Therapy therapy = therapyService.findTherapyBySpecialty(Specialty);
        return therapy;
    }

    @PutMapping("/therapy/{specialty}/update")
    public Therapy updateTherapy(@PathVariable("specialty") String Specialty, @RequestBody Therapy therapy){

        therapy.setSpecialty(Specialty);

        Therapy updated=therapyService.updateTherapy(therapy);
        if(updated != null){
            return updated;
        }else {
            return null;
        }
    }

}
