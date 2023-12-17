package com.therapy.therapySessionScheduler.service;

import com.therapy.therapySessionScheduler.model.Therapist;
import com.therapy.therapySessionScheduler.model.TherapistSchedule;
import com.therapy.therapySessionScheduler.repository.TherapistRepository;
import com.therapy.therapySessionScheduler.repository.TherapistScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TherapistScheduleServiceImpl implements TherapistScheduleService{
    private final TherapistScheduleRepository therapistScheduleRepository;
    private final TherapistRepository therapistRepository;
    @Autowired
    public TherapistScheduleServiceImpl(TherapistScheduleRepository therapistScheduleRepository, TherapistRepository therapistRepository) {
        this.therapistScheduleRepository = therapistScheduleRepository;
        this.therapistRepository = therapistRepository;
    }

    @Override
    public TherapistSchedule saveSchedule(Long id, TherapistSchedule therapistSchedule) {
        Optional<Therapist> therapist = therapistRepository.findTherapistById(id);
        if(therapist.isPresent()){
            therapistSchedule.setTherapist(therapist.orElse(null));
            return therapistScheduleRepository.save(therapistSchedule);
        }
        return null;
    }

    @Override
    public List<TherapistSchedule> getAllSchedules() {
        return therapistScheduleRepository.findAll();
    }

    @Override
    public TherapistSchedule getScheduleByDate(LocalDate date) {
        return therapistScheduleRepository.findByDate(date);
    }

    @Override
    public List<TherapistSchedule> getScheduleByTherapistId(Long id) {
        return therapistScheduleRepository.findAllByTherapistId(id);
    }

    @Override
    public TherapistSchedule getSchedulerByDateAndTherapistId(LocalDate date, Long id) {
        return therapistScheduleRepository.findTherapistScheduleByDateAndTherapistId(date,id);
    }

    @Override
    public void deleteSchedule(Long id) {
        therapistScheduleRepository.deleteById(id);
    }
}
