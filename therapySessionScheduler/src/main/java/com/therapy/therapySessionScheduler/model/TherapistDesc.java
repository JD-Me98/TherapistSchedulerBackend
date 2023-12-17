package com.therapy.therapySessionScheduler.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TherapistDescription")
public class TherapistDesc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    @Lob
    @Column(name = "imageData", length = 1000)
    private byte[] imageData;
    private String description;
    private double pricing;
    @OneToOne
    private Therapist therapist;
    @OneToOne
    private Therapy therapy;

}
