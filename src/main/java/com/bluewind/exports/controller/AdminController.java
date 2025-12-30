package com.bluewind.exports.controller;

import com.bluewind.exports.repository.EnquiryRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Value;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Value("${admin.username}")
    private String adminUser;

    @Value("${admin.password}")
    private String adminPass;

    @Autowired
    private EnquiryRepository enquiryRepository;

    // ================== LOGIN PAGE ==================
    @GetMapping("/login")
    public String loginPage() {
        return "admin/login";
    }

    // ================== LOGIN ACTION ==================




    @PostMapping("/login")
    public String doLogin(
            @RequestParam String username,
            @RequestParam String password,
            HttpSession session) {

        if (adminUser.equals(username) && adminPass.equals(password)) {
            session.setAttribute("ADMIN", true);
            return "redirect:/admin/enquiries";
        }

        return "redirect:/admin/login?error";
    }

    // ================== VIEW ENQUIRIES ==================
    @GetMapping("/enquiries")
    public String viewEnquiries(Model model, HttpSession session) {

        if (session.getAttribute("ADMIN") == null) {
            return "redirect:/admin/login";
        }

        model.addAttribute(
                "enquiries",
                enquiryRepository.findAllByOrderByCreatedAtDesc()
        );

        return "admin/enquiries";
    }

    // ================== DELETE ENQUIRY ==================
    @GetMapping("/delete/{id}")
    public String deleteEnquiry(
            @PathVariable Long id,
            HttpSession session) {

        if (session.getAttribute("ADMIN") == null) {
            return "redirect:/admin/login";
        }

        enquiryRepository.deleteById(id);
        return "redirect:/admin/enquiries";
    }

    // ================== LOGOUT ==================
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/admin/login";
    }
}
