package com.example.F2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointementService {
    @Autowired
    private AppointementRepository appointmentRepository;
    public void saveAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }


    public List<Appointment> getAppointmentByPatientId(Patient patient) {
        return appointmentRepository.findByPatient(patient);
    }
}
