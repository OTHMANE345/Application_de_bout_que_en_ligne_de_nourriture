package com.example.F2;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Entity
@Component("medical_records")
@Table(name = "medical_records")

public class MedicalRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    @ManyToOne
    @JoinColumn(name= "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name= "doctor_id")
    private Doctor doctor;
    @OneToMany(mappedBy = "medicalRecord")
    private List<Appointment> appointments;
    private String medicalTests;
    private String medicalProcedures;
    private String currentMedication;

    public MedicalRecord() {
    }

    public MedicalRecord(Long id, Patient patient, String medicalTests, String medicalProcedures, String currentMedication) {
        this.id = id;
        this.patient = patient;
        this.medicalTests = medicalTests;
        this.medicalProcedures = medicalProcedures;
        this.currentMedication = currentMedication;
        this.appointments = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public String getMedicalTests() {
        return medicalTests;
    }

    public void setMedicalTests(String medicalTests) {
        this.medicalTests = medicalTests;
    }

    public String getMedicalProcedures() {
        return medicalProcedures;
    }

    public void setMedicalProcedures(String medicalProcedures) {
        this.medicalProcedures = medicalProcedures;
    }

    public String getCurrentMedication() {
        return currentMedication;
    }

    public void setCurrentMedication(String currentMedication) {
        this.currentMedication = currentMedication;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
