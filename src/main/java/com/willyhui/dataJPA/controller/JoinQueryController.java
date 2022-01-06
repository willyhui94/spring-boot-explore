package com.willyhui.dataJPA.controller;

import com.willyhui.dataJPA.dto.DepartmentEmployeeDto;
import com.willyhui.dataJPA.exception.RecordNotFoundException;
import com.willyhui.dataJPA.service.JoinQueryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class JoinQueryController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private final JoinQueryService joinQueryService;

    public JoinQueryController(JoinQueryService joinQueryService) {
        this.joinQueryService = joinQueryService;
    }

    @Operation(summary = "department inner join employee")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "records from department inner join employee",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema = @Schema(implementation = DepartmentEmployeeDto.class))
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "bad request",
                    content = {
                            @Content(
                                    mediaType = MediaType.TEXT_PLAIN_VALUE,
                                    schema = @Schema(implementation = String.class)
                            )
                    }
            )
    })
    @GetMapping(value = "/department/employees/inner")
    public ResponseEntity<List<DepartmentEmployeeDto>> getDepartmentEmployeesInnerJoin(
            @RequestHeader(name = "userId", required = false) String userId
    ) {
        logger.info("[DJPA-JQC-GDEIJ-I001] get department employee inner join --- START");
        if (userId == null) {
            throw new RecordNotFoundException();
        }

        List<DepartmentEmployeeDto> departmentEmployeeDtoList = joinQueryService.getDepartmentEmployeesInnerJoin();

        ResponseEntity responseEntity = new ResponseEntity(
                departmentEmployeeDtoList,
                HttpStatus.OK
        );

        logger.info("[DJPA-JQC-GDEIJ-I002] get department employee inner join --- END");
        return responseEntity;
    }

    @Operation(summary = "department inner left employee")
    @GetMapping(value = "/department/employees/left")
    public ResponseEntity<List<DepartmentEmployeeDto>> getDepartmentEmployeesLeftJoin() {
        logger.info("[DJPA-JQC-GDELJ-I001] get department employee inner left --- START");

        List<DepartmentEmployeeDto> departmentEmployeeDtoList = joinQueryService.getDepartmentEmployeesLeftJoin();

        ResponseEntity responseEntity = new ResponseEntity(
                departmentEmployeeDtoList,
                HttpStatus.OK
        );

        logger.info("[DJPA-JQC-GDELJ-I002] get department employee left join --- END");
        return responseEntity;
    }

    @Operation(summary = "department inner right employee")
    @GetMapping(value = "/department/employees/right")
    public ResponseEntity<List<DepartmentEmployeeDto>> getDepartmentEmployeesRightJoin() {
        logger.info("[DJPA-JQC-GDERJ-I001] get department employee right join --- START");

        List<DepartmentEmployeeDto> departmentEmployeeDtoList = joinQueryService.getDepartmentEmployeesRightJoin();

        ResponseEntity responseEntity = new ResponseEntity(
                departmentEmployeeDtoList,
                HttpStatus.OK
        );

        logger.info("[DJPA-JQC-GDERJ-I002] get department employee right join --- END");
        return responseEntity;
    }

    @Operation(summary = "department inner cross employee")
    @GetMapping(value = "/department/employees/cross")
    public ResponseEntity<List<DepartmentEmployeeDto>> getDepartmentEmployeesCrossJoin() {
        logger.info("[DJPA-JQC-GDECJ-I001] get department employee cross join --- START");

        List<DepartmentEmployeeDto> departmentEmployeeDtoList = joinQueryService.getDepartmentEmployeesCrossJoin();

        ResponseEntity responseEntity = new ResponseEntity(
                departmentEmployeeDtoList,
                HttpStatus.OK
        );

        logger.info("[DJPA-JQC-GDECJ-I002] get department employee cross join --- END");
        return responseEntity;
    }
}
