package com.bridgelabz.EmployeePayrollServiceLayer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bridgelabz.EmployeePayrollServiceLayer.dto.EmployeePayrollDto;
import com.bridgelabz.EmployeePayrollServiceLayer.model.EmployeePayrollData;

@Service
public class serviceLayer {
	
	private List<EmployeePayrollData> employeeList = new ArrayList<>();
    private int empIdCounter = 1;

	
	public EmployeePayrollData addEmployee(EmployeePayrollDto empDto) {
		EmployeePayrollData empData = new EmployeePayrollData(empIdCounter++,empDto.getName(),empDto.getSalary());
		employeeList.add(empData);
		return empData;
		
	}
	
	public List<EmployeePayrollData> getAll(){
		return employeeList;
	}
	
	public EmployeePayrollData getEmployeeById(long id) {
		return employeeList.stream().filter(i -> i.getId() == id ).findFirst().orElse(null);
	}
	
	public EmployeePayrollData updateEmp(long id,EmployeePayrollDto empDTO) {
		EmployeePayrollData empData = this.getEmployeeById(id);
		empData.setName(empDTO.getName());
		empData.setSalary(empDTO.getSalary());
		return empData;
	}
	
	public void deleteEmployeeById(long id) {
			employeeList.removeIf(i -> i.getId() == id);
	}
	
}

