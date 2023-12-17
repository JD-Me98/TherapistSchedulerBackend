package com.therapy.therapySessionScheduler.service;

import com.therapy.therapySessionScheduler.model.LoggedInUser;
import com.therapy.therapySessionScheduler.model.Therapist;

public interface LoggedInUserService {
    void loginUser(Long id);
    void logoutUser(Long id);

    LoggedInUser getLoggedInUser(Long id);

}
