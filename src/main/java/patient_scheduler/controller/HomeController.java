package patient_scheduler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
    @GetMapping("/auth/session-register")
    public String registerSession(@RequestParam String user, @RequestParam String role, HttpSession session) {
        session.setAttribute("currentUser", user);
        session.setAttribute("userRole", role);
        return "redirect:/home";
    }

    @GetMapping("/")
    public String loginPage(HttpSession session) {
        if (session.getAttribute("currentUser") != null) {
            return "redirect:/home";
        }
        return "login";
    }

    @GetMapping("/home")
    public String home(HttpSession session) {
        if (session.getAttribute("currentUser") == null) {
            return "redirect:/";
        }
        return "home";
    }

    @GetMapping("/signup")
    public String signupPage() {
        return "signup";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}