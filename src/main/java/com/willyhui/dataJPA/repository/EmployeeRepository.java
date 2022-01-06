package com.willyhui.dataJPA.repository;

import com.willyhui.dataJPA.dto.DepartmentEmployeeDto;
import com.willyhui.dataJPA.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository <Employee, Integer> {

    @Query(
            nativeQuery = true,
            value = "SELECT " +
                        "d.name as employeeDepartment, " +
                        "e.name as employeeName, " +
                        "e.email as employeeEmail, " +
                        "e.address as employeeAddress " +
                    "FROM employee as e " +
                    "INNER JOIN department as d " +
                    "ON d.id = e.dept_id"
    )
    List<DepartmentEmployeeDto> fetchEmployeeDepartmentInnerJoin();
}
