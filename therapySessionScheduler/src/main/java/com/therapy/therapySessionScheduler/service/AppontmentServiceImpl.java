package com.therapy.therapySessionScheduler.service;

import com.therapy.therapySessionScheduler.model.Appointment;
import com.therapy.therapySessionScheduler.model.Therapist;
import com.therapy.therapySessionScheduler.model.TherapistSchedule;
import com.therapy.therapySessionScheduler.model.Therapy;
import com.therapy.therapySessionScheduler.repository.AppointmentRepository;
import com.therapy.therapySessionScheduler.repository.TherapistRepository;
import com.therapy.therapySessionScheduler.repository.TherapistScheduleRepository;
import com.therapy.therapySessionScheduler.repository.TherapyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class AppontmentServiceImpl implements AppointmentService{

    private final TherapistRepository therapistRepository;
    private final TherapyRepository therapyRepository;
    private final TherapistScheduleRepository therapistScheduleRepository;
    private final AppointmentRepository appointmentRepository;
    @Autowired
    public AppontmentServiceImpl(TherapistRepository therapistRepository, TherapyRepository therapyRepository, TherapistScheduleRepository therapistScheduleRepository, AppointmentRepository appointmentRepository) {
        this.therapistRepository = therapistRepository;
        this.therapyRepository = therapyRepository;
        this.therapistScheduleRepository = therapistScheduleRepository;
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public String save(Appointment appointment, Long id, LocalDate date) {
        Therapist therapist=therapistRepository.findTherapistById(id).orElse(null);
        TherapistSchedule therapistSchedule=therapistScheduleRepository.findTherapistScheduleByDateAndTherapistId(date, id);

        UUID randomUUID = UUID.randomUUID();
        String uuidString = randomUUID.toString();

        appointment.setTrackId(uuidString);
        appointment.setTherapist(therapist);
        appointment.setTherapistSchedule(therapistSchedule);

        appointmentRepository.save(appointment);
        return uuidString;
    }

    @Override
    public List<Appointment> showAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment getAppointmentByTrackId(String trackId) {
        Appointment appointment = appointmentRepository.findAppointmentByTrackId(trackId);

        if (appointment != null) {
            // Fetch associated data (Therapist and TherapistSchedule)
            appointment.getTherapist(); // Ensure this fetches the associated Therapist
            appointment.getTherapistSchedule(); // Ensure this fetches the associated TherapistSchedule
        }

        return appointment;
    }

    @Override
    public List<Appointment> showAppointmentsByTherapist(Long id) {
        return appointmentRepository.findAllByTherapistId(id);
    }

    @Override
    public Appointment updateAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }
}
