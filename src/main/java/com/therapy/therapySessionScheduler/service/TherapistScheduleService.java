package com.therapy.therapySessionScheduler.service;

import com.therapy.therapySessionScheduler.model.TherapistSchedule;

import java.time.LocalDate;
import java.util.List;

public interface TherapistScheduleService {
    TherapistSchedule saveSchedule(Long id, TherapistSchedule therapistSchedule);
    List<TherapistSchedule> getAllSchedules();
    TherapistSchedule getScheduleByDate(LocalDate date);
    List<TherapistSchedule> getScheduleByTherapistId(Long id);

    TherapistSchedule getSchedulerByDateAndTherapistId(LocalDate date, Long id);
    void deleteSchedule(Long id);
}
