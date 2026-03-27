package com.aarmita.clothcare.controller;

import com.aarmita.clothcare.entity.User;
import com.aarmita.clothcare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    // ── Landing page ──────────────────────────────────────────
    @GetMapping("/")
    public String index() {
        return "index";
    }

    // ── Login ─────────────────────────────────────────────────
    // GET – show form
    @GetMapping("/login")
    public String loginPage(@RequestParam(value = "error", required = false) String error,
                            Model model) {
        if (error != null) {
            model.addAttribute("loginError", "Invalid username or password.");
        }
        return "login";
    }
    // POST /login is handled automatically by Spring Security (see SecurityConfig)

    // ── Signup ────────────────────────────────────────────────
    @GetMapping("/signup")
    public String signupPage() {
        return "signup";
    }

    @PostMapping("/signup")
    public String doSignup(@RequestParam String username,
                           @RequestParam String phoneNo,
                           @RequestParam String password,
                           RedirectAttributes redirectAttributes) {

        if (userService.usernameExists(username)) {
            redirectAttributes.addFlashAttribute("signupError", "Username already taken.");
            return "redirect:/signup";
        }

        User user = new User(username, phoneNo, password);
        userService.addUser(user);  // password is hashed inside service
        return "redirect:/login?registered=true";
    }

    // ── Dashboard ─────────────────────────────────────────────
    @GetMapping("/dashboard")
    public String dashboard(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        if (userDetails == null) {
            return "redirect:/login";
        }

        User user = userService.getUserByUsername(userDetails.getUsername());
        if (user == null) {
            return "redirect:/login";
        }

        model.addAttribute("username", user.getUsername());
        model.addAttribute("memberSince", user.getDateJoined());
        return "dashboard";
    }
}
