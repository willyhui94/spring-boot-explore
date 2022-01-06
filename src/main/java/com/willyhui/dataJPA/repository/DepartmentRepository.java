package com.willyhui.dataJPA.repository;

import com.willyhui.dataJPA.dto.DepartmentEmployeeDto;
import com.willyhui.dataJPA.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    @Query(
            nativeQuery = true,
            value = "SELECT " +
                        "d.name as employeeDepartment, " +
                        "e.name as employeeName, " +
                        "e.email as employeeEmail, " +
                        "e.address as employeeAddress " +
                    "FROM department as d " +
                    "INNER JOIN employee as e " +
                    "ON d.id = e.dept_id"
    )
    List<DepartmentEmployeeDto> fetchDepartmentEmployeesInnerJoin();

    @Query(
            nativeQuery = true,
            value = "SELECT " +
                        "d.name as employeeDepartment, " +
                        "e.name as employeeName, " +
                        "e.email as employeeEmail, " +
                        "e.address as employeeAddress " +
                    "FROM department as d " +
                    "Left JOIN employee as e " +
                    "ON d.id = e.dept_id"
    )
    List<DepartmentEmployeeDto> fetchDepartmentEmployeesLeftJoin();

    @Query(
            nativeQuery = true,
            value = "SELECT " +
                        "d.name as employeeDepartment, " +
                        "e.name as employeeName, " +
                        "e.email as employeeEmail, " +
                        "e.address as employeeAddress " +
                    "FROM department as d " +
                    "RIGHT JOIN employee as e " +
                    "ON d.id = e.dept_id"
    )
    List<DepartmentEmployeeDto> fetchDepartmentEmployeesRightJoin();

    @Query(
            nativeQuery = true,
            value = "SELECT " +
                        "d.name as employeeDepartment, " +
                        "e.name as employeeName, " +
                        "e.email as employeeEmail, " +
                        "e.address as employeeAddress " +
                    "FROM department as d " +
                    "CROSS JOIN employee as e"
    )
    List<DepartmentEmployeeDto> fetchDepartmentEmployeesCrossJoin();
}
