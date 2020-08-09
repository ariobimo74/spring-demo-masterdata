package com.codevergence.demo.masterdata.service.impl;

import com.codevergence.demo.masterdata.model.entity.EmployeeType;
import com.codevergence.demo.masterdata.repository.EmployeeTypeRepository;
import com.codevergence.demo.masterdata.service.EmployeeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeTypeServiceImpl implements EmployeeTypeService
{
    @Autowired
    private EmployeeTypeRepository employeeTypeRepository;

    @Override
    public List<EmployeeType> getAll() {
        List<EmployeeType> employeeTypeList = employeeTypeRepository.findAll();
        List<EmployeeType> employeeTypes = new ArrayList<EmployeeType>();

        for (int i = 0; i < employeeTypeList.size(); i++)
        {
            if (!employeeTypeList.get(i).isDelete())
            {
                employeeTypes.add(employeeTypeList.get(i));
            }
        }

        return employeeTypes;
    }

    @Override
    public Optional<EmployeeType> getById(long id) {

        if (!employeeTypeRepository.findById(id).get().isDelete())
        {
            return employeeTypeRepository.findById(id);
        }
        else
        {
            return Optional.empty();
        }
    }
}
