package com.codevergence.demo.masterdata.service.interf;

import com.codevergence.demo.masterdata.model.entity.EmployeeType;

import java.util.List;
import java.util.Optional;

public interface EmployeeTypeService
{
    List<EmployeeType> getAll();

    Optional<EmployeeType> getById(long id);
}
