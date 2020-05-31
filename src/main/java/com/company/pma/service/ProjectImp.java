package com.company.pma.service;

import com.company.pma.dto.StageRecord;
import com.company.pma.entity.Project;
import com.company.pma.repo.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectImp implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Project save(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public List<Project> findAll() {
        return (List<Project>) projectRepository.findAll();
    }

    @Override
    public Optional<Project> findById(Long id) {
        return projectRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        projectRepository.deleteById(id);
    }

    @Override
    public List<StageRecord> getProjectStageRecord() {
        return projectRepository.getProjectStageRecord();
    }
}
