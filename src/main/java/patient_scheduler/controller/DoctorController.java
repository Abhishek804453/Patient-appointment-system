package patient_scheduler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.stream.Collectors;
import java.util.List;

import patient_scheduler.model.Doctor;
import patient_scheduler.service.SchedulerService;

@Controller
public class DoctorController {

    private SchedulerService schedulerService;

    public DoctorController(SchedulerService schedulerService) {
        this.schedulerService = schedulerService;
    }

    @GetMapping("/doctors")
    public String doctors(@RequestParam(required = false) String specialty, Model model) {
        var activeDoctors = schedulerService.searchDoctors(specialty).stream()
                .filter(Doctor::getIsActive)
                .collect(Collectors.toList());

        if (activeDoctors.isEmpty()) {
            model.addAttribute("message", "Currently, no doctors are available for this specialty.");
        }

        model.addAttribute("doctors", activeDoctors);
        model.addAttribute("specialty", specialty);
        return "doctors";
    }

    @GetMapping("/doctor-schedule")
    public String doctorSchedule(@RequestParam(required = false) String doctorName, Model model) {
        var activeDoctors = schedulerService.getDoctors().stream()
                .filter(Doctor::getIsActive)
                .collect(Collectors.toList());

        model.addAttribute("doctors", activeDoctors);
        model.addAttribute("selectedDoctor", doctorName);
        model.addAttribute("hasSelectedDoctor", doctorName != null && !doctorName.isBlank());

        if (doctorName != null && !doctorName.isBlank()) {
            var appointments = schedulerService.getAppointmentsForDoctor(doctorName);
            model.addAttribute("appointments", appointments);

            if (appointments.isEmpty()) {
                model.addAttribute("message", "No appointments found for this doctor.");
            }
        } else {
            model.addAttribute("appointments", List.of());
        }

        return "doctor-schedule";
    }
}