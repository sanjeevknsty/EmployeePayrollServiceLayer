package com.bridgelabz.EmployeePayrollServiceLayer.model;

public class EmployeePayrollData {
	private Long id;
	private String name;
	private Double salary;
	public EmployeePayrollData () {
		
	}
	
	public EmployeePayrollData(long id,String name,Double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	public long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		this.id = id;
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
