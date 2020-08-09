package com.codevergence.demo.masterdata.service;

import com.codevergence.demo.masterdata.model.dto.EmployeeAddDto;
import com.codevergence.demo.masterdata.model.dto.EmployeeDto;
import com.codevergence.demo.masterdata.model.entity.Employee;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EmployeeService
{
    List<Employee> getAll();

    List<EmployeeDto> getAllEmployee();

    Optional<EmployeeDto> getById(long id);

    List<EmployeeDto> getEmployeeByTypeId(long typeId);

    List<EmployeeDto> getEmployeeByPlacementId(long placementId);

    List<EmployeeDto> getAllEmployee(@Param(value = "theNpk") String theNpk,
                                     @Param(value = "theName") String theName);

    List<EmployeeDto> getAllEmployee(long theTypeId, long thePlacementId);

    List<EmployeeDto> getAllEmployee(String orderType,
                                     @Param(value = "offset") int offset,
                                     @Param(value = "fetch") int fetch);

    List<EmployeeDto> getAllEmployee(int rpg, int page);

    Employee addEmployee(EmployeeAddDto employeeAddDto);

    Employee editEmployee(long id, EmployeeAddDto employeeAddDto);

    Employee deleteEmployee(long id, String userMail);
}
