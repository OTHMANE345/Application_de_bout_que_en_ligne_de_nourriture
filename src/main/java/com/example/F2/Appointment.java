package com.example.F2;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Component("appointments")
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    private String appointmentDateTime;

    private String reasonForAppointment;

    private String prescription;

    private String diagnosis;
    @ManyToOne
    @JoinColumn(name = "billing_id")
    private Billing billing;

    @ManyToOne
    @JoinColumn(name = "medicalRecord_id")
    private MedicalRecord medicalRecord;


    public Appointment() {
    }

    public Appointment(Long id, Patient patient, Doctor doctor, String appointmentDateTime, String reasonForAppointment, String prescription, String diagnosis) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.appointmentDateTime = appointmentDateTime;
        this.reasonForAppointment = reasonForAppointment;
        this.prescription = prescription;
        this.diagnosis = diagnosis;

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

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Billing getBilling() {
        return billing;
    }

    public void setBilling(Billing billing) {
        this.billing = billing;
    }

    public String getAppointmentDateTime() {
        return appointmentDateTime;
    }

    public void setAppointmentDateTime(String appointmentDateTime) {
        this.appointmentDateTime = appointmentDateTime;
    }

    public String getReasonForAppointment() {
        return reasonForAppointment;
    }

    public void setReasonForAppointment(String reasonForAppointment) {
        this.reasonForAppointment = reasonForAppointment;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
}
