package pl.portfolio.webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String getMainPage() {
        return "main";
    }

    @GetMapping("/about")
    public String getAboutPage() {
        return "about";
    }

    @GetMapping("/projects")
    public String getProjectsPage() {
        return "projects";
    }

    @GetMapping("/curriculum")
    public String getCurriculumPage() {
        return "cv";
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }
}

