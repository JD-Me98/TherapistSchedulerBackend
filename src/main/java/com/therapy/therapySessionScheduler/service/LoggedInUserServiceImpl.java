package com.therapy.therapySessionScheduler.service;

import com.therapy.therapySessionScheduler.model.LoggedInUser;
import com.therapy.therapySessionScheduler.model.Therapist;
import com.therapy.therapySessionScheduler.repository.LoggedInUserRepository;
import com.therapy.therapySessionScheduler.repository.TherapistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class LoggedInUserServiceImpl implements LoggedInUserService{
    private TherapistRepository therapistRepository;
    private LoggedInUserRepository loggedInUserRepository;
    @Autowired
    public LoggedInUserServiceImpl(TherapistRepository therapistRepository, LoggedInUserRepository loggedInUserRepository) {
        this.therapistRepository = therapistRepository;
        this.loggedInUserRepository = loggedInUserRepository;
    }

    @Override
    public void loginUser(Long id) {
        Optional<Therapist> therapist=therapistRepository.findTherapistById(id);
        if(therapist.isPresent()){
            LoggedInUser loggedInUser=new LoggedInUser();
            loggedInUser.setTherapist(therapist.get());
            loggedInUserRepository.save(loggedInUser);
        }
    }

    @Override
    public void logoutUser(Long id) {
        loggedInUserRepository.deleteLoggedInUserByTherapistId(id);
    }

    @Override
    public LoggedInUser getLoggedInUser(Long id) {
        return loggedInUserRepository.findLoggedInUserByTherapistId(id);
    }


}
