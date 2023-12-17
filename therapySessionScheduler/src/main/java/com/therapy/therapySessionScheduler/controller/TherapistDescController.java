package com.therapy.therapySessionScheduler.controller;

import com.therapy.therapySessionScheduler.model.TherapistDesc;
import com.therapy.therapySessionScheduler.service.TherapistDescService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class TherapistDescController {
    private static final String UPLOAD_DIRECTORY = "src/main/resources/static/images/";
    private TherapistDescService therapistDescService;
    @Autowired
    public TherapistDescController(TherapistDescService therapistDescService) {
        this.therapistDescService = therapistDescService;
    }
    @PostMapping("/{id}/description/{specialty}")
    public TherapistDesc saveTherapyDesc(@PathVariable("id") Long id,
                                         @PathVariable("specialty") String specialty,
                                         @RequestParam("firstName") String firstName,
                                         @RequestParam("lastName") String lastName,
                                         @RequestParam("address") String address,
                                         @RequestParam("imageData") MultipartFile imageData,
                                         @RequestParam("description") String description,
                                         @RequestParam("pricing") double pricing){
        try {
            TherapistDesc therapistDesc = new TherapistDesc();
            therapistDesc.setFirstName(firstName);
            therapistDesc.setLastName(lastName);
            therapistDesc.setAddress(address);
            therapistDesc.setImageData(imageData.getBytes());
            therapistDesc.setDescription(description);
            therapistDesc.setPricing(pricing);
            return therapistDescService.saveDesc(id, therapistDesc, specialty);
        }catch(IOException e){
            return null;
        }

    }

    @GetMapping("/therapist/description")
    public List<TherapistDesc> getTherapistDescription(){
        return therapistDescService.allTherapitstsDescription();
    }

    @GetMapping("/therapist/{id}/description")
    public TherapistDesc getTherapistDescByTherapistId(@PathVariable Long id){
        return therapistDescService.getTherapistDescByTherapistId(id);
    }

    @PatchMapping("/description/update/{id}/{therapy}")
    public void updateDescription(
            @PathVariable Long id,
            @PathVariable("therapy") String therapy,
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("address") String address,
            @RequestParam(value = "imageData", required = false) MultipartFile imageData,
            @RequestParam("description") String description,
            @RequestParam("pricing") double pricing
    ) {
        try {
            // Validate if imageData is present before processing
            byte[] imageBytes = (imageData != null) ? imageData.getBytes() : null;

            TherapistDesc therapistDesc = new TherapistDesc();
            therapistDesc.setFirstName(firstName);
            therapistDesc.setLastName(lastName);
            therapistDesc.setAddress(address);
            therapistDesc.setImageData(imageBytes); // Set image data if available
            therapistDesc.setDescription(description);
            therapistDesc.setPricing(pricing);

            therapistDescService.updateDesc(id, therapy, therapistDesc);
        } catch (IOException e) {
            // Handle IO Exception (file processing)
            e.printStackTrace(); // Log the exception or handle accordingly
        } catch (Exception ex) {
            // Handle other exceptions
            ex.printStackTrace(); // Log the exception or handle accordingly
        }
    }
}
