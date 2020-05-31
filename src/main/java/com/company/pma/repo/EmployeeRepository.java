package com.company.pma.repo;


import com.company.pma.dto.EmployeeProject;
import com.company.pma.entity.Employee;
import com.company.pma.entity.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {


    @Query(nativeQuery = true,value = "SELECT E.FIRST_NAME as firstName , E.LAST_NAME as lastName , count(PE.EMPLOYEE_ID ) as projectCount FROM EMPLOYEE E " +
            "LEFT JOIN PROJECT_EMPLOYEE  PE ON " +
            "E.EMPLOYEE_ID  = PE .EMPLOYEE_ID " +
            "GROUP BY E.FIRST_NAME ,E.LAST_NAME  ORDER BY 3 DESC")
    List<EmployeeProject> getEmployeeProjects();

}
