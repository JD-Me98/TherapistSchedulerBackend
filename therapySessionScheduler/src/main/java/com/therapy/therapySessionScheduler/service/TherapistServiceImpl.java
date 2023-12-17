package com.therapy.therapySessionScheduler.service;

import com.therapy.therapySessionScheduler.model.Therapist;
import com.therapy.therapySessionScheduler.model.Therapy;
import com.therapy.therapySessionScheduler.repository.TherapistRepository;
import com.therapy.therapySessionScheduler.repository.TherapyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TherapistServiceImpl implements TherapistService{
    private final TherapistRepository therapistRepository;
    private final TherapyRepository therapyRepository;

    @Autowired
    public TherapistServiceImpl(TherapistRepository therapistRepository, TherapyRepository therapyRepository) {
        this.therapistRepository = therapistRepository;
        this.therapyRepository = therapyRepository;
    }


    @Override
    public Therapist saveTherapist(Therapist therapist) {
        return therapistRepository.save(therapist);
    }

    @Override
    public List<Therapist> getAllTherapists() {
        return therapistRepository.findAll();
    }

    @Override
    public void deleteTherapist(String username) {

    }

    @Override
    public Therapist getTherapistByUsername(String username) {
        return therapistRepository.findTherapistByUsername(username).orElse(null);
    }

    @Override
    public Therapist getTherapistById(Long id) {
        return therapistRepository.findTherapistById(id).orElse(null);
    }

//    @Override
//    public Therapist saveTherapistT(String username, String specialty) {
//        Therapist therapist = therapistRepository.findTherapistByUsername(username).orElse(null);
//        Therapy therapy = therapyRepository.getTherapyBySpecialty(specialty);
//        therapist.getTherapy().add(therapy);
//        return therapistRepository.save(therapist);
//    }

    @Override
    public Therapist login(String username, String password) {
        Therapist newTherapist = therapistRepository.findTherapistByUsername(username).orElse(null);
        if( newTherapist!=null){
            if(newTherapist.getUsername().equals(username) && newTherapist.getPassword().equals(password)){
                return newTherapist;
            }else{
                return null;
            }
        }else{
            return null;
        }
    }
}
