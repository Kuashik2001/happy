
  package com.hm.HospitalManagement.Service;
  
  import com.hm.HospitalManagement.Entity.Appointment;
import com.hm.HospitalManagement.Entity.Doctor;
import com.hm.HospitalManagement.Entity.Patient;
import com.hm.HospitalManagement.Repository.AppointmentRepository;
import com.hm.HospitalManagement.Repository.DoctorRepository; 
  import org.springframework.beans.factory.annotation.Autowired; 
  import org.springframework.stereotype.Service;
  
  import java.util.List; 
  import java.util.Optional;
import java.util.stream.Collectors;
  
  @Service 
  public class DoctorService {
  
  @Autowired 
  private DoctorRepository doctorRepository;
  @Autowired
  private AppointmentRepository appointmentRepo;
  
  // Get all doctors
  public List<Doctor> getAllDoctors() { 
	  return doctorRepository.findAll(); }
  
  // Add a new doctor 
  public void addDoctor(Doctor doctor) {
  doctorRepository.save(doctor); }
  
  // Get a doctor by ID 
//  public Doctor getDoctorById(Long id) { Optional<Doctor>
//  optionalDoctor = doctorRepository.findById(id); return
//  optionalDoctor.orElse(null); }  							//old
  public Optional<Doctor> getDoctorById(Long id)
  {
	  return doctorRepository.findById(id);
  }
  
  
  public List<Patient> getPatientsByDoctorId(Long doctorId) {
      List<Appointment> appointments = appointmentRepo.findByDoctorId(doctorId);

      // Extract unique patients from appointments
      
      return appointments.stream()
              .map(Appointment::getPatient)
              .distinct()
              .collect(Collectors.toList());
  }
  
  
  
  
  // Update an existing doctor 
//  public void updateDoctor(Doctor doctor) {
//  doctorRepository.save(doctor); }  //old
  
  public void updateDoctor(Doctor doctor)
  {
	  if(doctorRepository.existsById(doctor.getId()))
	  {
		  doctorRepository.save(doctor);
	  }
  }
  
  // Delete a doctor 
  public void deleteDoctor(Long id) {
  doctorRepository.deleteById(id); } 
  
  //Added
  public Doctor getDoctorByEmail(String email)
  {
	  return doctorRepository.findByEmail(email);
  }
  
  }

  

//  package com.hm.HospitalManagement.Service;
//  
//  import com.hm.HospitalManagement.Entity.Doctor; 
//  import com.hm.HospitalManagement.Repository.DoctorRepository;
//  
//  import org.slf4j.Logger;
//  
//  import org.slf4j.LoggerFactory; 
//  import org.springframework.beans.factory.annotation.Autowired; 
//  import org.springframework.stereotype.Service;
//  
//  import java.util.List;
//  
//  @Service 
//  public class DoctorService { 
//  private static final Logger log = LoggerFactory.getLogger(DoctorService.class);
//  
//  @Autowired 
//  private DoctorRepository doctorRepository;
//  
//  public List<Doctor> getAllDoctors() 
//  { return doctorRepository.findAll();}
//  
//  // Get all doctors from DB (persists across logins) 
//  public List<Doctor> getAllDoctors() { return doctorRepository.findAll(); }
//  
//  // Add a new doctor and persist in DB public 
//  void addDoctor(Doctor doctor) {
//  doctorRepository.save(doctor); // This ensures the data is stored 
//  }
//  
//  // Get doctor by ID 
//  public Doctor getDoctorById(Long id) { return
//  doctorRepository.findById(id).orElse(null); }
//  
//  // Update an existing doctor 
//  public void updateDoctor(Doctor doctor) {
//  doctorRepository.save(doctor); }
//  
//  // Delete a doctor from DB
//  public void deleteDoctor(Long id) {
//  doctorRepository.deleteById(id); } 
//  }
 


	/*
	 * package com.hm.HospitalManagement.Service;
	 * 
	 * import com.hm.HospitalManagement.Entity.Doctor; import
	 * com.hm.HospitalManagement.Repository.DoctorRepository;
	 * 
	 * import jakarta.persistence.criteria.Fetch;
	 * 
	 * import org.springframework.beans.factory.annotation.Autowired; import
	 * org.springframework.stereotype.Service; import java.util.List;
	 * 
	 * @Service public class DoctorService {
	 * 
	 * @Autowired private DoctorRepository doctorRepository;
	 * 
	 * public List<Doctor> getAllDoctors() { return doctorRepository.findAll(); // ✅
	 * } }
	 */