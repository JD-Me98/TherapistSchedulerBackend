package com.therapy.therapySessionScheduler.controller;

import com.therapy.therapySessionScheduler.model.Admin;
import com.therapy.therapySessionScheduler.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class AdminController {
    private AdminService adminService;
    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }
    @PostMapping("/Admin/save")
    public Admin adminSave(@RequestBody Admin admin){
        return adminService.save(admin);
    }
    @GetMapping("/Admin/admins")
    public List<Admin> adminsList(){
        return adminService.adminList();
    }

    @GetMapping("/admin/login/{username}/{password}")
    public ResponseEntity<String> loginAdmin(@PathVariable("username")String username, @PathVariable("password") String password){

        Admin admin=adminService.loginAdmin(username,password);

        return ResponseEntity.status(HttpStatus.CREATED).body("Login successful" + admin);
    }
}
