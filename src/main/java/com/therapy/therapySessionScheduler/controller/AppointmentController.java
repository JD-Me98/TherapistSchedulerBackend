package com.therapy.therapySessionScheduler.controller;

import com.therapy.therapySessionScheduler.model.Appointment;
import com.therapy.therapySessionScheduler.service.AppointmentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class AppointmentController {
    private final AppointmentService appointmentService;
    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping("/appointment/{id}/{date}")
    public ResponseEntity<String> saveAppointment(@RequestBody Appointment appointment, @PathVariable("id") Long id, @PathVariable("date") LocalDate date) {
        String trackId = appointmentService.save(appointment, id, date); // Assuming trackId is a String

        return ResponseEntity.status(HttpStatus.CREATED).body("Track ID: " + trackId);
    }
    @GetMapping("/appointment/list")
    public List<Appointment> appointmentList(){
        return appointmentService.showAppointments();
    }

    @GetMapping("/appointment/track/{trackId}")
    public Appointment getAppointment(@PathVariable("trackId") String trackId){
        return appointmentService.getAppointmentByTrackId(trackId);
    }

    @GetMapping("/appointments/{id}/all")
    public List<Appointment> getAppointmentsByTherapist(@PathVariable("id") Long id){
        return appointmentService.showAppointmentsByTherapist(id);
    }

    @PutMapping("/appointment/{id}/update")
    public ResponseEntity<String> updateAppointment(@PathVariable("id") String trackId){
        Appointment appointment=appointmentService.getAppointmentByTrackId(trackId);

        appointment.setStatus("Approved");

        appointmentService.updateAppointment(appointment);

        return ResponseEntity.status(HttpStatus.CREATED).body("Track ID: " + trackId);
    }

}
