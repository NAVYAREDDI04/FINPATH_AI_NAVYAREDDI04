package com.investbridge.auth.service;

import com.investbridge.auth.entity.Appointment;
import com.investbridge.auth.entity.Distributor;
import com.investbridge.auth.entity.User;
import com.investbridge.auth.repository.AppointmentRepository;
import com.investbridge.auth.repository.DistributorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private DistributorRepository distributorRepository;

    public Appointment scheduleAppointment(String studentEmail, Long mentorId, LocalDateTime scheduledDate) {
        User student = userService.findByEmail(studentEmail);
        if (student == null) {
            return null;
        }
        Distributor mentor = distributorRepository.findById(mentorId).orElse(null);
        if (mentor == null) {
            return null;
        }
        Appointment appointment = new Appointment(student, mentor, scheduledDate, "Pending");
        return appointmentRepository.save(appointment);
    }

    public Appointment getAppointment(Long id) {
        return appointmentRepository.findById(id).orElse(null);
    }

    public List<Appointment> getAppointmentsForUser(Long studentId) {
        return appointmentRepository.findByStudent_Id(studentId);
    }
}
