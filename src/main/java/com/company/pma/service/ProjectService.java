package com.company.pma.service;

import com.company.pma.dto.StageRecord;
import com.company.pma.entity.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectService {

    Project save(Project project);

    List<Project> findAll();

    Optional<Project> findById(Long id);

    void deleteById(Long id);

    List<StageRecord> getProjectStageRecord();
}
