package com.therapy.therapySessionScheduler.repository;

import com.therapy.therapySessionScheduler.model.Therapy;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TherapyRepository extends JpaRepository<Therapy, Long> {
    @Modifying
    @Transactional
    @Query("DELETE FROM Therapy t WHERE t.Specialty = :Specialty")
    void deleteBySpecialty(@Param("Specialty") String specialty);

    @Query("SELECT t FROM Therapy t WHERE t.Specialty = :Specialty")
    Therapy getTherapyBySpecialty(@Param("Specialty") String specialty);
}
