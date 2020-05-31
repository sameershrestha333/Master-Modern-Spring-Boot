package com.company.pma.controller;

import com.company.pma.dto.EmployeeProject;
import com.company.pma.entity.Employee;
import com.company.pma.entity.Project;
import com.company.pma.service.EmployeeService;
import com.company.pma.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private ProjectService projectService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String displayHome(Model model) {
        final List<Project> projects = projectService.findAll();
        final List<EmployeeProject> employeeProjects = employeeService.getEmployeeProjects();
        model.addAttribute("projects", projects);
        model.addAttribute("employeeProjects", employeeProjects);
        return "main/home";
    }

}



