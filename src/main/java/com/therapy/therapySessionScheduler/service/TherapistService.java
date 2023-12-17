package com.therapy.therapySessionScheduler.service;

import com.therapy.therapySessionScheduler.model.Therapist;

import java.util.List;
import java.util.Optional;

public interface TherapistService {
    Therapist saveTherapist(Therapist therapist);
    List<Therapist> getAllTherapists();
    void deleteTherapist(String username);
    Therapist getTherapistByUsername(String username);
    Therapist getTherapistById(Long id);
//    Therapist saveTherapistT(String username,String specialty);
    Therapist login(String username, String Password);
}
