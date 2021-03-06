package com.codevergence.demo.masterdata.controller.rest;

import com.codevergence.demo.masterdata.model.entity.EmployeeType;
import com.codevergence.demo.masterdata.service.EmployeeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/employeetypes")
public class EmployeeTypeRest
{
    @Autowired
    private EmployeeTypeService employeeTypeService;

    @GetMapping
    public List<EmployeeType> getAll()
    {
        return employeeTypeService.getAll();
    }

    @GetMapping(path = "{/id}")
    public ResponseEntity<?> getById(@PathVariable(value = "id") long id)
    {
        if (employeeTypeService.getById(id).isPresent())
        {
            return new ResponseEntity<>(employeeTypeService.getById(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
