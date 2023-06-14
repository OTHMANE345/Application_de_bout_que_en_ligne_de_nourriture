package com.example.F2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepositort doctorRepositort;

    public List<Doctor> getAllDoctors() {
        return doctorRepositort.findAll();
    }
    public void delete_doctor_ById(Long id) {
        Optional<Doctor> optionalBilling = doctorRepositort.findById(id);
        if (optionalBilling.isPresent()) {
            doctorRepositort.delete(optionalBilling.get());
        } else {
            throw new IllegalArgumentException("doctor  with ID " + id + " not found.");
        }
    }
    public Doctor getDoctorById(Long id) {
        Optional<Doctor> optionalBilling = doctorRepositort.findById(id);
        return optionalBilling.orElse(null);
    }
    public Doctor addDoctor(Doctor d) {
        return doctorRepositort.save(d);
    }
}
