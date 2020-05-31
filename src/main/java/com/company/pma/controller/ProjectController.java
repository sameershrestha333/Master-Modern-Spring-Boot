package com.company.pma.controller;

import com.company.pma.entity.Employee;
import com.company.pma.entity.Project;
import com.company.pma.service.EmployeeService;
import com.company.pma.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/new")
    public String displayProjectForm(Model model) {
        final List<Employee> employeeList = employeeService.findAll();
        model.addAttribute("project", new Project());
        model.addAttribute("employeeList", employeeList);
        return "project/project";
    }


    @PostMapping("/save")
    public String saveProject(Project project) {
        projectService.save(project);

        // use a redirect to prevent duplicate submissions
        return "redirect:/projects/";
    }

    @GetMapping("/")
    public String displayHome(Model model) {
        final List<Project> projects = projectService.findAll();
        model.addAttribute("projects", projects);
        return "project/display-project";
    }


}



