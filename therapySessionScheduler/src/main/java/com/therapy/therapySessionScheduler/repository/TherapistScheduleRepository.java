package com.therapy.therapySessionScheduler.repository;

import com.therapy.therapySessionScheduler.model.TherapistSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TherapistScheduleRepository extends JpaRepository<TherapistSchedule, Long> {
    TherapistSchedule findByDate(LocalDate date);

    TherapistSchedule findTherapistScheduleByDateAndTherapistId(LocalDate date, Long id);
    List<TherapistSchedule> findAllByTherapistId(Long id);
}
