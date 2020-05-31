package com.company.pma.repo;


import com.company.pma.dto.StageRecord;
import com.company.pma.entity.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

    @Query(nativeQuery = true,value = "SELECT STAGE as label, count(*) as count FROM PROJECT " +
            "GROUP BY STAGE")
    List<StageRecord> getProjectStageRecord();

}
