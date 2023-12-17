package com.therapy.therapySessionScheduler.repository;

import com.therapy.therapySessionScheduler.model.TherapistDesc;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TherapistDescRepository extends JpaRepository<TherapistDesc, Long> {
    Optional<TherapistDesc> findByTherapistId(Long id);
}
