package com.healthcare.clinic.domain.model;

import com.healthcare.clinic.domain.model.enums.StatusAppointment;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAppointment;

    @ManyToOne
    @Column(name = "id_patient", nullable = false)
    private Patient patient;

    @ManyToOne
    @Column(name = "id_doctor", nullable = false)
    private Doctor doctor;

    @NotNull
    @FutureOrPresent
    private LocalDateTime datetime;

    @NotNull
    @Enumerated(EnumType.STRING)
    private StatusAppointment status;

    @Lob
    private String note;
}
