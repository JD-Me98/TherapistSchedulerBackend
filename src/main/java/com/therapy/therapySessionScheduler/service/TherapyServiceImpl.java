package com.therapy.therapySessionScheduler.service;

import com.therapy.therapySessionScheduler.model.Therapy;
import com.therapy.therapySessionScheduler.repository.TherapyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TherapyServiceImpl implements TherapyService{
    private final TherapyRepository therapyRepository;

    @Autowired
    public TherapyServiceImpl(TherapyRepository therapyRepository) {
        this.therapyRepository = therapyRepository;
    }

    @Override
    public Therapy saveTherapy(Therapy therapy) {
        return therapyRepository.save(therapy);
    }

    @Override
    public List<Therapy> therapyList() {
        return therapyRepository.findAll();
    }

    @Override
    public void deleteBySpecialty(String specialty) {
        therapyRepository.deleteBySpecialty(specialty);
    }
    @Override
    public Therapy findTherapyBySpecialty(String specialty) {
        return therapyRepository.getTherapyBySpecialty(specialty);
    }

    @Override
    public Therapy updateTherapy(Therapy therapy) {
        Therapy existingTherapy= therapyRepository.getTherapyBySpecialty(therapy.getSpecialty());
        if(existingTherapy!=null){
            existingTherapy.setSpecialty(therapy.getSpecialty());
            existingTherapy.setDescription(therapy.getDescription());
            existingTherapy.setImg_url(therapy.getImg_url());

            return therapyRepository.save(existingTherapy);
        }else{
            return null;
        }
    }


}
