package com.codevergence.demo.masterdata.repository;

import com.codevergence.demo.masterdata.model.dto.EmployeeDto;
import com.codevergence.demo.masterdata.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long>
{
    @Query(nativeQuery = true)
    List<EmployeeDto> getAllEmployee();

    @Query(nativeQuery = true)
    Optional<EmployeeDto> getEmployee(long employeeById);

    @Query(nativeQuery = true)
    List<EmployeeDto> getAllEmployeeByTypeId(long theTypeId);

    @Query(nativeQuery = true)
    List<EmployeeDto> getAllEmployeeByPlacementId(long thePlacementId);

    @Query(nativeQuery = true)
    List<EmployeeDto> getAllEmployeeSearch(long theTypeId, long thePlacementId);

    @Query(nativeQuery = true)
    List<EmployeeDto> getAllEmployeeAdvancedSearch(@Param(value = "theNpk") String theNpk,
                                                   @Param(value = "theName") String theName);

    @Query(nativeQuery = true)
    List<EmployeeDto> getAllEmployeePaginateAsc(@Param(value = "offset") int offset,
                                                @Param(value = "fetch") int fetch);

    @Query(nativeQuery = true)
    List<EmployeeDto> getAllEmployeePaginateDesc(@Param(value = "offset") int offset,
                                                 @Param(value = "fetch") int fetch);

    @Query(nativeQuery = true)
    List<EmployeeDto> getAllEmployeePagingRowAsc(@Param(value = "offset") int offset,
                                                 @Param(value = "fetch") int fetch);
}
