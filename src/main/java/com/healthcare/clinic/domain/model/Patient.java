package com.healthcare.clinic.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPatient;

    @NotBlank
    private String name;

    @NotBlank
    private String lastName;

    @NotNull
    private Integer age;

    @NotNull
    @Past
    private Date birthday;

    @Email
    @NotBlank
    @Column(unique = true)
    private String email;

    @NotBlank
    private String phoneNumber;

    @Lob
    private String historial;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Treatment> treatments;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Appointment> appointments;
}
