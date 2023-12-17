package com.therapy.therapySessionScheduler.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Therapist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;
    private String email;
    @JsonIgnore
    @OneToOne(mappedBy = "therapist")
    private TherapistDesc therapistDesc;
    @JsonIgnore
    @OneToMany(mappedBy = "therapist")
    private List<TherapistSchedule> therapistScheduleList;
    @JsonIgnore
    @OneToMany(mappedBy = "therapist")
    private List<Appointment> appointment;
    @JsonIgnore
    @OneToOne(mappedBy = "therapist")
    private LoggedInUser loggedInUser;


}
