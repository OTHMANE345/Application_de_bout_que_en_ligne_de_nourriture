package com.example.F2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalRecordService {
    @Autowired
    private MedicalRecordRepository medicalRecordRepository;
    public void addMedicalRecord(MedicalRecord medicalRecord) {
        List<Appointment> appointments = medicalRecord.getAppointments();
        if (!appointments.isEmpty()) {
            Appointment firstAppointment = appointments.get(0);
            medicalRecord.setPatient(firstAppointment.getPatient());
            medicalRecord.setDoctor(firstAppointment.getDoctor());
        }
        medicalRecordRepository.save(medicalRecord);
    }
    public List<MedicalRecord> getAllMedicallRecord() {
        return medicalRecordRepository.findAll();
    }

}
