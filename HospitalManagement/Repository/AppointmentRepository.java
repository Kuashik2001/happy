package com.hm.HospitalManagement.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hm.HospitalManagement.Entity.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByDoctorEmail(String doctorEmail);
    List<Appointment> findByDoctorId(Long Id);
  //  Appointment findByDoctorId1(Long id);
    
    //List<Appointment> findByPatientEmail(String patientEmail); // Added
}
