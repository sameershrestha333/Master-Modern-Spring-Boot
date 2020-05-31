package com.company.pma.controller;

import com.company.pma.entity.Employee;
import com.company.pma.entity.Project;
import com.company.pma.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/new")
    public String displayEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee/employee";
    }


    @PostMapping("/save")
    public String saveEmployee(Employee employee) {
        employeeService.save(employee);

        // use a redirect to prevent duplicate submissions
        return "redirect:/employees/new";
    }


    @GetMapping("/")
    public String displayHome(Model model) {
        final List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees", employees);
        return "employee/display-employee";
    }

}



