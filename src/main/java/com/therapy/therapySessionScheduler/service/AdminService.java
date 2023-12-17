package com.therapy.therapySessionScheduler.service;

import com.therapy.therapySessionScheduler.model.Admin;

import java.util.List;

public interface AdminService {
    Admin save(Admin admin);
    List<Admin> adminList();

    Admin searchByUsername(String username);

    Admin loginAdmin(String username, String password);
}
