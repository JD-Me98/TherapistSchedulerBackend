package com.therapy.therapySessionScheduler.service;

import com.therapy.therapySessionScheduler.model.Appointment;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentService {
    String save(Appointment appointment, Long id, LocalDate date);
    List<Appointment> showAppointments();

    Appointment getAppointmentByTrackId(String trackId);

    List<Appointment> showAppointmentsByTherapist(Long id);

    Appointment updateAppointment(Appointment appointment);
}
