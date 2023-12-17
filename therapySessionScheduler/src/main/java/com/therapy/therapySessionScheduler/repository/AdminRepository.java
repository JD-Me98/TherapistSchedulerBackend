package com.therapy.therapySessionScheduler.repository;

import com.therapy.therapySessionScheduler.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findAdminByUsername(String username);

    void findAdminByUsernameAndPassword(String username, String password);
}
