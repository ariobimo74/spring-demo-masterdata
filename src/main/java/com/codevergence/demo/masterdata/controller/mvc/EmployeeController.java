package com.codevergence.demo.masterdata.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/employee")
public class EmployeeController
{
    @GetMapping
    public String employee()
    {
        return "employee";
    }
}
