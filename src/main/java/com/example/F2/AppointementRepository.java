package com.example.F2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointementRepository  extends JpaRepository<Appointment, Long> {
    List<Appointment> findByPatient(Patient patient);

}
