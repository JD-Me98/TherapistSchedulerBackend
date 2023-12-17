package com.therapy.therapySessionScheduler.service;

import com.therapy.therapySessionScheduler.model.Admin;
import com.therapy.therapySessionScheduler.model.Therapist;
import com.therapy.therapySessionScheduler.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminServiceImpl implements AdminService{
    private final AdminRepository adminRepository;
    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public Admin save(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public List<Admin> adminList() {
        return adminRepository.findAll();
    }

    @Override
    public Admin searchByUsername(String username) {
        return adminRepository.findAdminByUsername(username);
    }

    @Override
    public Admin loginAdmin(String username, String password) {
        Admin admin = adminRepository.findAdminByUsername(username);
        if( admin!=null){
            if(admin.getUsername().equals(username) && admin.getPassword().equals(password)){
                return admin;
            }else{
                return null;
            }
        }else{
            return null;
        }
    }

}
