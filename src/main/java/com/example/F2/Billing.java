package com.example.F2;

import jakarta.persistence.*;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.util.List;

@Entity
@Component("billings")
@DependsOn("patients")
@Table(name = "billings")
public class Billing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @OneToMany(mappedBy = "billing")
    private List<Appointment> appointments;

    private Double totalAmountDue;

    private String paymentStatus;

    public Billing() {
    }
    public Billing(Patient patient, Double totalAmountDue, String paymentStatus) {
        this.patient = patient;
        this.appointments = appointments;
        this.totalAmountDue = totalAmountDue;
        this.paymentStatus = paymentStatus;
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

    public Double getTotalAmountDue() {
        return totalAmountDue;
    }

    public void setTotalAmountDue(Double totalAmountDue) {
        this.totalAmountDue = totalAmountDue;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
