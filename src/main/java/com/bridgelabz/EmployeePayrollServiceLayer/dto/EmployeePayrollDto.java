package com.bridgelabz.EmployeePayrollServiceLayer.dto;

public class EmployeePayrollDto {
	private String name;
	private Double salary;
	public EmployeePayrollDto() {
		
	}
	
	public EmployeePayrollDto(String name,Double salary) {
		this.name = name;
		this.salary = salary;
	}
	
	public String getName() { 
		return name; 
	}
    public void setName(String name) {
    	this.name = name; 
    }

    public Double getSalary() { 
    	return salary;
    }
    public void setSalary(Double salary) { 
    	this.salary = salary; 
    }
	
}
