package com.example.F2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
    public void delete_patient_ById(Long id) {
        Optional<Patient> optionalBilling = patientRepository.findById(id);
        if (optionalBilling.isPresent()) {
            patientRepository.delete(optionalBilling.get());
        } else {
            throw new IllegalArgumentException("patient  with ID " + id + " not found.");
        }
    }

}
