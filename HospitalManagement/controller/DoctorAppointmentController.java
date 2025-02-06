package com.hm.HospitalManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hm.HospitalManagement.Entity.Appointment;
import com.hm.HospitalManagement.Service.AppointmentService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/doctor")
public class DoctorAppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/appointments")
    public String showDoctorAppointments(@RequestParam Long Id, Model model) {
        model.addAttribute("appointments", appointmentService.getAppointmentsByDoctor(Id));
        return "doctor-dashboard";
    }
    
    //Add
//    @GetMapping("/doctor-dashboard")
//	public String showDoctorDashboard(HttpSession session, Model model, HttpServletResponse response) {
//		String DoctorName = (String) session.getAttribute("doctorName");
//
//		if (DoctorName == null) {
//			return "redirect:/doctor/login";
//		}
//		List<Appointment> appoints = AppointmentService.getAppointmentsByDoctor();
//		model.addAttribute("doctors", doctors);
//		return "patient-dashboard";
//	}

    @PostMapping("/updateStatus")
    public String updateAppointmentStatus(@RequestParam Long id, @RequestParam String status) {
        appointmentService.updateAppointmentStatus(id, status);
        return "redirect:/doctor/dashboard";
    }

    @GetMapping("/deleteAppointment")
    public String deleteAppointment(@RequestParam Long id) {
        appointmentService.deleteAppointment(id);
        return "redirect:/doctor/dashboard";
    }
}
