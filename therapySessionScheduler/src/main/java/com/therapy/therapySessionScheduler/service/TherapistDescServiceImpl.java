package com.therapy.therapySessionScheduler.service;

import com.therapy.therapySessionScheduler.model.Therapist;
import com.therapy.therapySessionScheduler.model.TherapistDesc;
import com.therapy.therapySessionScheduler.model.Therapy;
import com.therapy.therapySessionScheduler.repository.TherapistDescRepository;
import com.therapy.therapySessionScheduler.repository.TherapistRepository;
import com.therapy.therapySessionScheduler.repository.TherapyRepository;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TherapistDescServiceImpl implements TherapistDescService {
    private TherapistRepository therapistRepository;
    private TherapistDescRepository therapistDescRepository;

    private TherapyRepository therapyRepository;

    public TherapistDescServiceImpl(TherapistRepository therapistRepository, TherapistDescRepository therapistDescRepository, TherapyRepository therapyRepository) {
        this.therapistRepository = therapistRepository;
        this.therapistDescRepository = therapistDescRepository;
        this.therapyRepository = therapyRepository;
    }

    @Override
    public TherapistDesc saveDesc(Long id, TherapistDesc therapistDesc, String specialty) {
        Therapist therapist = therapistRepository.findTherapistById(id).orElse(null);
        Therapy therapy = therapyRepository.getTherapyBySpecialty(specialty);
        therapistDesc.setTherapist(therapist);
        therapistDesc.setTherapy(therapy);
        return therapistDescRepository.save(therapistDesc);
    }

    @Override
    public List<TherapistDesc> allTherapitstsDescription() {
        return therapistDescRepository.findAll();
    }

    @Override
    public TherapistDesc getTherapistDescByTherapistId(Long id) {
        return therapistDescRepository.findByTherapistId(id).orElse(null);
    }

    @Override
    public void updateDesc(Long id,String specialty, TherapistDesc desc){
        Therapy therapy=therapyRepository.getTherapyBySpecialty(specialty);
        TherapistDesc therapistDesc=therapistDescRepository.findByTherapistId(id).orElse(null);
        therapistDesc.setFirstName(desc.getFirstName());
        therapistDesc.setLastName(desc.getLastName());
        therapistDesc.setAddress(desc.getAddress());
        therapistDesc.setImageData(desc.getImageData());
        therapistDesc.setDescription(desc.getDescription());
        therapistDesc.setPricing(desc.getPricing());
        therapistDesc.setTherapy(therapy);
        therapistDescRepository.save(therapistDesc);
    }


}
