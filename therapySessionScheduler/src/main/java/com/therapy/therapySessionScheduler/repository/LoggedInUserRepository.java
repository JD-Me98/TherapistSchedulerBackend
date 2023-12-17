package com.therapy.therapySessionScheduler.repository;

import com.therapy.therapySessionScheduler.model.LoggedInUser;
import com.therapy.therapySessionScheduler.model.Therapist;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoggedInUserRepository extends JpaRepository<LoggedInUser, Long> {

    Optional<LoggedInUser> findLoggedInUserByTherapist(Therapist therapist);
    @Transactional
    void deleteLoggedInUserByTherapistId(Long id);
    LoggedInUser findLoggedInUserByTherapistId(Long id);
}
