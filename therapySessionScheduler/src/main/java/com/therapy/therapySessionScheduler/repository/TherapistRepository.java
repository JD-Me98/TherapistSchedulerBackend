package com.therapy.therapySessionScheduler.repository;

import com.therapy.therapySessionScheduler.model.Therapist;
import com.therapy.therapySessionScheduler.model.Therapy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TherapistRepository extends JpaRepository<Therapist, Long> {

    Optional<Therapist> findTherapistByUsername(String username);
    Optional<Therapist> findTherapistById(Long id);

}
