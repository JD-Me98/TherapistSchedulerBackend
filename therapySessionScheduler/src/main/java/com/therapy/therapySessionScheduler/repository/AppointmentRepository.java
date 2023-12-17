package com.therapy.therapySessionScheduler.repository;

import com.therapy.therapySessionScheduler.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    Appointment findAppointmentByTrackId(String trackId);

    List<Appointment> findAllByTherapistId(Long id);
}
