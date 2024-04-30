package pl.portfolio.webapp.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/projects")
public class ProjectsController {
    @GetMapping("/nailSalon")
    public String getNailSalon() {
        log.info("Nail salon selected");
        return "nailSalon";
    }
}
