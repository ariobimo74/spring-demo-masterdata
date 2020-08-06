package com.codevergence.demo.masterdata.repository;

import com.codevergence.demo.masterdata.model.entity.EmployeeType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeTypeRepository extends JpaRepository<EmployeeType, Long> {
}
