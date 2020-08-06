package com.codevergence.demo.masterdata.controller.rest;

import com.codevergence.demo.masterdata.model.dto.EmployeeAddDto;
import com.codevergence.demo.masterdata.model.dto.EmployeeDto;
import com.codevergence.demo.masterdata.model.entity.Employee;
import com.codevergence.demo.masterdata.service.interf.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/rest/employee")
public class EmployeeRest
{
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<?> getAll()
    {
        return new ResponseEntity<>(employeeService.getAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getById(@PathVariable(value = "id") long id)
    {
        if (employeeService.getById(id).isPresent())
        {
            return new ResponseEntity<>(employeeService.getById(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping(path = "/employeetype/{typeid}")
    public ResponseEntity<?> getEmployeeByTypeId(@PathVariable(value = "typeid") long typeid)
    {
        return new ResponseEntity<>(employeeService.getEmployeeByTypeId(typeid), HttpStatus.OK);
    }

    @GetMapping(path = "/placement/{placementid}")
    public ResponseEntity<?> getEmployeeByPlacementId(@PathVariable(value = "placementid") long placementId)
    {
        return new ResponseEntity<>(employeeService.getEmployeeByPlacementId(placementId), HttpStatus.OK);
    }

    @GetMapping(path = "/search/{typeid}/{placementid}")
    public ResponseEntity<?> getAllEmployee(@PathVariable(value = "typeid") long typeId, @PathVariable(value = "placementid") long placementId)
    {
        return new ResponseEntity<>(employeeService.getAllEmployee(typeId, placementId), HttpStatus.OK);
    }

    @GetMapping(path = "/paging/name/{ordertype}")
    public List<EmployeeDto> getAllEmployee(@PathVariable(value = "ordertype") String orderType,
                                            @RequestParam(value = "offset") int offset,
                                            @RequestParam(value = "fetch") int fetch)
    {
        return employeeService.getAllEmployee(orderType, offset, fetch);
    }

    @GetMapping(path = "pagerow/name")
    public List<EmployeeDto> getAllEmployee(@RequestParam(value = "rpg") int rpg,
                                            @RequestParam(value = "page") int page)
    {
        return employeeService.getAllEmployee(rpg, page);
    }

    @PostMapping(path = "/{userName}")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee addEmployee(@PathVariable(value = "userName") String userName,
                                @RequestBody EmployeeAddDto employeeAddDto)
    {
        return employeeService.addEmployee(userName, employeeAddDto);
    }

    @PatchMapping(path = "/{userName}")
    @ResponseStatus(HttpStatus.OK)
    public Employee editEmployee(@PathVariable(value = "userName") String userName,
                                 @RequestBody EmployeeAddDto employeeAddDto)
    {
        return employeeService.editEmployee(userName, employeeAddDto);
    }

    @DeleteMapping("/{userName}/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Employee deleteEmployee(@PathVariable(value = "id") long id,
                                   @PathVariable(value = "userName") String userName)
    {
        return employeeService.deleteEmployee(id, userName);
    }
}
