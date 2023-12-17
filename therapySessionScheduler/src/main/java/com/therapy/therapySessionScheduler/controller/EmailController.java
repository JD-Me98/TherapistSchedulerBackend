package com.therapy.therapySessionScheduler.controller;

import com.therapy.therapySessionScheduler.model.Appointment;
import com.therapy.therapySessionScheduler.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@CrossOrigin("http://localhost:3000")
public class EmailController {
    @Autowired
    private EmailSenderService emailSenderService;

    @PostMapping("/sendEmail/{fromMail}/{trackId}")
    public ResponseEntity<String> sendEmail(@RequestBody Appointment appointment, @PathVariable("fromMail") String from,@PathVariable("trackId") String trackId) {
        try {
            String message = "Thank you for working with us. You can track your appointment with this id: " + trackId;
            String body = message;
            String toEmail = appointment.getEmail();
            String fromEmail = from;
            String subject = "Therapist Appointment";

            emailSenderService.senMail(toEmail, fromEmail, subject, body);

            return ResponseEntity.ok("Email sent successfully");
        } catch (Exception e) {
            // Log the exception or handle it accordingly
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send email");
        }
    }
}
