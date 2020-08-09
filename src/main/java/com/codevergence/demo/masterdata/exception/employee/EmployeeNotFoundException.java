package com.codevergence.demo.masterdata.exception.employee;

public class EmployeeNotFoundException extends RuntimeException
{
    public EmployeeNotFoundException(long id)
    {
        super("Employee not found with id : " + id);
    }
}
