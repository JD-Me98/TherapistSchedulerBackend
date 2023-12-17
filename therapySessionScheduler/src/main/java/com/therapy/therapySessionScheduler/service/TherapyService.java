package com.therapy.therapySessionScheduler.service;

import com.therapy.therapySessionScheduler.model.Therapy;

import java.util.List;

public interface TherapyService {
    Therapy saveTherapy(Therapy therapy);
    List<Therapy> therapyList();
    void deleteBySpecialty(String specialty);

    Therapy findTherapyBySpecialty(String specialty);

    Therapy updateTherapy(Therapy therapy);
}
