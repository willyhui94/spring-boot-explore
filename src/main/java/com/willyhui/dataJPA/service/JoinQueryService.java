package com.willyhui.dataJPA.service;

import com.willyhui.dataJPA.dto.DepartmentEmployeeDto;
import com.willyhui.dataJPA.repository.DepartmentRepository;
import com.willyhui.dataJPA.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoinQueryService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    public JoinQueryService(
            DepartmentRepository departmentRepository,
            EmployeeRepository employeeRepository
    ) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    public List<DepartmentEmployeeDto> getDepartmentEmployeesInnerJoin() {
        logger.info("[DJPA-JQS-GDEIJ-I001] get department employees inner join --- START");

        List<DepartmentEmployeeDto> list = departmentRepository.fetchDepartmentEmployeesInnerJoin();

        logger.info("[DJPA-JQS-GDEIJ-I002] get department employees inner join --- END");
        return list;
    }

    public List<DepartmentEmployeeDto> getDepartmentEmployeesLeftJoin() {
        logger.info("[DJPA-JQS-GDELJ-I001] get department employees left join --- START");

        List<DepartmentEmployeeDto> list = departmentRepository.fetchDepartmentEmployeesLeftJoin();

        logger.info("[DJPA-JQS-GDELJ-I002] get department employees left join --- END");
        return list;
    }

    public List<DepartmentEmployeeDto> getDepartmentEmployeesRightJoin() {
        logger.info("[DJPA-JQS-GDERJ-I001] get department employees right join --- START");

        List<DepartmentEmployeeDto> list = departmentRepository.fetchDepartmentEmployeesRightJoin();

        logger.info("[DJPA-JQS-GDERJ-I002] get department employees right join --- END");
        return list;
    }

    public List<DepartmentEmployeeDto> getDepartmentEmployeesCrossJoin() {
        logger.info("[DJPA-JQS-GDECJ-I001] get department employees cross join --- START");

        List<DepartmentEmployeeDto> list = departmentRepository.fetchDepartmentEmployeesCrossJoin();

        logger.info("[DJPA-JQS-GDECJ-I002] get department employees cross join --- END");
        return list;
    }
}
