package com.bridgelabz.EmployeePayrollServiceLayer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.EmployeePayrollServiceLayer.model.EmployeeModel;

public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long>{

}
