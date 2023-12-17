package com.therapy.therapySessionScheduler.controller;


import com.therapy.therapySessionScheduler.model.TherapistSchedule;
import com.therapy.therapySessionScheduler.service.TherapistScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class TherapistScheduleController {
    private final TherapistScheduleService therapistScheduleService;
    @Autowired
    public TherapistScheduleController(TherapistScheduleService therapistScheduleService) {
        this.therapistScheduleService = therapistScheduleService;
    }
    @PostMapping("/schedule/{id}/save")
    public TherapistSchedule saveSchedule(@PathVariable Long id, @RequestBody TherapistSchedule therapistSchedule){
        return therapistScheduleService.saveSchedule(id, therapistSchedule);
    }
    @GetMapping("/schedules")
    public List<TherapistSchedule> getSchedules(){
        return therapistScheduleService.getAllSchedules();
    }

    @GetMapping("/schedule/{date}")
    public TherapistSchedule getScheduleByDate(@PathVariable("date") LocalDate date){
        return therapistScheduleService.getScheduleByDate(date);
    }
    @GetMapping("/therapist/schedule/{id}")
    public List<TherapistSchedule> getScheduleByTherapistId(@PathVariable("id") Long id){
        return therapistScheduleService.getScheduleByTherapistId(id);
    }
    @DeleteMapping("/therapist/schedule/delete/{id}")
    public void deleteSchedule(@PathVariable("id") Long id){
        therapistScheduleService.deleteSchedule(id);
    }

    @GetMapping("/schedule/{date}/{id}")
    public TherapistSchedule getScheduleByDateAndTherapistId(@PathVariable("date") LocalDate date,@PathVariable("id") Long id){
        return therapistScheduleService.getSchedulerByDateAndTherapistId(date,id);
    }
}
