package com.codevergence.demo.masterdata.controller.rest;

import com.codevergence.demo.masterdata.exception.employee.BadRequestException;
import com.codevergence.demo.masterdata.exception.employee.EmployeeNotFoundException;
import com.codevergence.demo.masterdata.model.dto.EmployeeAddDto;
import com.codevergence.demo.masterdata.model.dto.EmployeeDto;
import com.codevergence.demo.masterdata.model.entity.Employee;
import com.codevergence.demo.masterdata.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeRest
{
    @Autowired
    private EmployeeService employeeService;
    private Object EmployeeNotFoundException;

    @GetMapping
    public ResponseEntity<?> getAll()
    {
        return new ResponseEntity<>(employeeService.getAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{value}")
    public EmployeeDto getById(@PathVariable(value = "value") String value)
    {
        try
        {
            long id = Long.parseLong(value);
            return employeeService.getById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
        }
        catch (NumberFormatException e)
        {
            throw new BadRequestException(value);
        }
    }

    @GetMapping(path = "/employee_type/{typeid}")
    public ResponseEntity<?> getEmployeeByTypeId(@PathVariable(value = "typeid") long typeid)
    {
        return new ResponseEntity<>(employeeService.getEmployeeByTypeId(typeid), HttpStatus.OK);
    }

    @GetMapping(path = "/placement/{placementid}")
    public ResponseEntity<?> getEmployeeByPlacementId(@PathVariable(value = "placementid") long placementId)
    {
        return new ResponseEntity<>(employeeService.getEmployeeByPlacementId(placementId), HttpStatus.OK);
    }

    @GetMapping(path = "/search/type_id/{typeid}/placement_id/{placementid}")
    public ResponseEntity<?> getAllEmployee(@PathVariable(value = "typeid") long typeId,
                                            @PathVariable(value = "placementid") long placementId)
    {
        return new ResponseEntity<>(employeeService.getAllEmployee(typeId, placementId), HttpStatus.OK);
    }

    @GetMapping(path = "search")
    public ResponseEntity<?> getAllEmployee(@RequestParam(value = "theNpk") String theNpk,
                                            @RequestParam(value = "theName") String theName)
    {
        return new ResponseEntity<>(employeeService.getAllEmployee(theNpk, theName), HttpStatus.OK);
    }

    @GetMapping(path = "/page/name/{ordertype}")
    public ResponseEntity<?> getAllEmployee(@PathVariable(value = "ordertype") String orderType,
                                            @RequestParam(value = "offset", defaultValue = "0") int offset,
                                            @RequestParam(value = "fetch", defaultValue = "1") int fetch)
    {
        return new ResponseEntity<>(employeeService.getAllEmployee(orderType, offset, fetch), HttpStatus.OK);
    }

    @GetMapping(path = "pagerow/name/asc")
    public ResponseEntity<?> getAllEmployee(@RequestParam(value = "rpg", defaultValue = "1") int rpg,
                                            @RequestParam(value = "page", defaultValue = "1") int page)
    {
        return new ResponseEntity<>(employeeService.getAllEmployee(rpg, page), HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee addEmployee(@RequestBody EmployeeAddDto employeeAddDto)
    {
        return employeeService.addEmployee(employeeAddDto);
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee editEmployee(@PathVariable(value = "id") long id,
                                 @RequestBody EmployeeAddDto employeeAddDto)
    {
        return employeeService.editEmployee(id, employeeAddDto);
    }

    @DeleteMapping(path = "/{userName}/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Employee deleteEmployee(@PathVariable(value = "id") long id,
                                   @PathVariable(value = "userName") String userName)
    {
        return employeeService.deleteEmployee(id, userName);
    }
}
