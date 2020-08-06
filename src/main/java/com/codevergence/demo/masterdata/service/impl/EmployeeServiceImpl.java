package com.codevergence.demo.masterdata.service.impl;

import com.codevergence.demo.masterdata.model.dto.EmployeeAddDto;
import com.codevergence.demo.masterdata.model.dto.EmployeeDto;
import com.codevergence.demo.masterdata.model.entity.Employee;
import com.codevergence.demo.masterdata.model.entity.EmployeeType;
import com.codevergence.demo.masterdata.model.entity.Placement;
import com.codevergence.demo.masterdata.repository.EmployeeRepository;
import com.codevergence.demo.masterdata.repository.EmployeeTypeRepository;
import com.codevergence.demo.masterdata.repository.PlacementRepository;
import com.codevergence.demo.masterdata.service.interf.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService
{
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeTypeRepository employeeTypeRepository;

    @Autowired
    private PlacementRepository placementRepository;

    @Override
    public List<Employee> getAll()
    {
        List<Employee> employeeList = employeeRepository.findAll();
        List<Employee> employees = new ArrayList<Employee>();

        for (int i = 0; i < employeeList.size(); i++)
        {
            if (!employeeList.get(i).isDelete())
            {
                employees.add(employeeList.get(i));
            }
        }

        return employees;
    }

    @Override
    public List<EmployeeDto> getAllEmployee()
    {
        return employeeRepository.getAllEmployee();
    }

    @Override
    public Optional<EmployeeDto> getById(long id) {
        return employeeRepository.getEmployee(id);
    }

    @Override
    public List<EmployeeDto> getEmployeeByTypeId(long typeId) {
        return employeeRepository.getAllEmployeeByTypeId(typeId);
    }

    @Override
    public List<EmployeeDto> getEmployeeByPlacementId(long placementId) {
        return employeeRepository.getAllEmployeeByPlacementId(placementId);
    }

    @Override
    public List<EmployeeDto> getAllEmployee(long theTypeId, long thePlacementId) {
        return employeeRepository.getAllEmployeeSearch(theTypeId, thePlacementId);
    }

    @Override
    public List<EmployeeDto> getAllEmployee(String orderType, int offset, int fetch)
    {
        int theFetch = fetch - offset;

        if (orderType.toLowerCase().equals("desc"))
        {
            return employeeRepository.getAllEmployeePaginateDesc(offset, theFetch);
        }
        else
        {
            return employeeRepository.getAllEmployeePaginateAsc(offset, theFetch);
        }
    }

    @Override
    public List<EmployeeDto> getAllEmployee(int rpg, int page)
    {
        int theStart = (page - 1) * rpg;

        return employeeRepository.getAllEmployeePagingRowAsc(theStart, rpg);
    }

    @Override
    public Employee addEmployee(String userName, EmployeeAddDto employeeAddDto)
    {
        Employee employee = new Employee();
        employee.setCreatedBy(userName);
        employee.setCreatedDate(new Date());
        employee.setDelete(false);
        employee.setNpk(employeeAddDto.getNpk());
        employee.setName(employeeAddDto.getName());
        employee.setOfficeEmail(employeeAddDto.getOfficeEmail());

        Optional<EmployeeType> employeeType = employeeTypeRepository.findById(employeeAddDto.getTypeId());
        Optional<Placement> placement = placementRepository.findById(employeeAddDto.getPlacementId());

        employeeType.ifPresent(employee::setEmployeeType);
        placement.ifPresent(employee::setPlacement);

        return employeeRepository.save(employee);
    }

    @Override
    public Employee editEmployee(String userName, EmployeeAddDto employeeAddDto)
    {
        Employee employee = employeeRepository.findById(employeeAddDto.getId()).get();
        employee.setModifiedBy(userName);
        employee.setModifiedDate(new Date());
        employee.setName(employeeAddDto.getName());
        employee.setNpk(employeeAddDto.getNpk());
        employee.setOfficeEmail(employeeAddDto.getOfficeEmail());

        Optional<EmployeeType> employeeType = employeeTypeRepository.findById(employeeAddDto.getTypeId());
        Optional<Placement> placement = placementRepository.findById(employeeAddDto.getPlacementId());

        employeeType.ifPresent(employee::setEmployeeType);
        placement.ifPresent(employee::setPlacement);

        return employeeRepository.save(employee);
    }

    @Override
    public Employee deleteEmployee(long id, String userName)
    {
        Employee employee = employeeRepository.findById(id).get();
        employee.setDeletedBy(userName);
        employee.setDeletedDate(new Date());
        employee.setDelete(true);

        return employeeRepository.save(employee);
    }
}
