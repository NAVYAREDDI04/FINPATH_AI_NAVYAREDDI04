package com.investbridge.auth.controller;

import com.investbridge.auth.dto.AppointmentRequestDTO;
import com.investbridge.auth.entity.Appointment;
import com.investbridge.auth.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/book")
    public Appointment bookAppointment(Principal principal, @RequestBody AppointmentRequestDTO request) {
        return appointmentService.scheduleAppointment(principal.getName(), request.getMentorId(), request.getScheduledDate());
    }

    @GetMapping("/user/{id}")
    public List<Appointment> getAppointmentsForUser(@PathVariable Long id) {
        return appointmentService.getAppointmentsForUser(id);
    }

    @GetMapping("/{id}")
    public Appointment getAppointment(@PathVariable Long id) {
        return appointmentService.getAppointment(id);
    }
}
