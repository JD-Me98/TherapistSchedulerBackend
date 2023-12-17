package com.therapy.therapySessionScheduler.service;

import com.therapy.therapySessionScheduler.model.TherapistDesc;

import java.util.List;

public interface TherapistDescService {
    TherapistDesc saveDesc(Long id, TherapistDesc therapistDesc, String specialty);
    List<TherapistDesc> allTherapitstsDescription();

    TherapistDesc getTherapistDescByTherapistId(Long id);

    void updateDesc(Long id,String therapy, TherapistDesc therapistDesc);
}
