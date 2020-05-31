package com.company.pma.service;

import com.company.pma.dto.EmployeeProject;
import com.company.pma.entity.Employee;
import com.company.pma.entity.Project;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Employee save(Employee employee);
    void saveAll(List<Employee> employees);

    List<Employee> findAll();

    Optional<Employee> findById(Long id);
    List<Employee> findAllById(List<Long> ids);

    void deleteById(Long id);

    List<EmployeeProject> getEmployeeProjects();





}
