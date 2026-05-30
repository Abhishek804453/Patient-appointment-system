package patient_scheduler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpSession;
import patient_scheduler.model.Doctor;
import patient_scheduler.service.SchedulerService;

@Controller
public class AdminController {

    private SchedulerService schedulerService;

    public AdminController(SchedulerService schedulerService) {
        this.schedulerService = schedulerService;
    }

    @GetMapping("/admin")
    public String admin(Model model, HttpSession session) {
        String role = (String) session.getAttribute("userRole");
        if (role == null || !role.equals("ADMIN")) {
            return "redirect:/home";
        }

        long activeDoctorCount = schedulerService.getDoctors().stream().filter(Doctor::getIsActive).count();

        model.addAttribute("doctorCount", activeDoctorCount);
        model.addAttribute("doctors", schedulerService.getDoctors());
        model.addAttribute("totalAppointments", schedulerService.getAppointments().size());
        model.addAttribute("bookedAppointments", schedulerService.countBookedAppointments());
        model.addAttribute("cancelledAppointments", schedulerService.countCancelledAppointments());
        model.addAttribute("appointments", schedulerService.getAppointments());
        return "admin";
    }

    @PostMapping("/admin/add-doctor")
    public String addDoctor(@RequestParam String name, @RequestParam String specialty, HttpSession session) {
        String role = (String) session.getAttribute("userRole");
        if (role == null || !role.equals("ADMIN")) {
            return "redirect:/home";
        }
        Doctor doc = new Doctor(name, specialty);
        schedulerService.saveDoctor(doc);
        return "redirect:/admin";
    }

    @GetMapping("/admin/remove-doctor/{id}")
    public String removeDoctor(@PathVariable Long id, HttpSession session) {
        String role = (String) session.getAttribute("userRole");
        if (role == null || !role.equals("ADMIN")) {
            return "redirect:/home";
        }

        schedulerService.softDeleteDoctor(id);
        return "redirect:/admin";
    }
}