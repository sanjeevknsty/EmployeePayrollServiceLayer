package com.bridgelabz.EmployeePayrollServiceLayer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.EmployeePayrollServiceLayer.dto.EmployeePayrollDto;
import com.bridgelabz.EmployeePayrollServiceLayer.model.EmployeeModel;
import com.bridgelabz.EmployeePayrollServiceLayer.model.EmployeePayrollData;
import com.bridgelabz.EmployeePayrollServiceLayer.repository.EmployeeRepository;
import com.bridgelabz.EmployeePayrollServiceLayer.service.serviceLayer;


@RestController
@RequestMapping("/payroll")
public class EmployeePayrollController {
	
	
	@Autowired
	private serviceLayer empService;
	private EmployeeRepository repo;
	
	
	@GetMapping("/")
	public String Hello() {
		return "Hello";
	}
	
	
	
	@PostMapping("/post")
	public EmployeePayrollData postEmployee(@RequestBody EmployeePayrollDto empDto) {
		return empService.addEmployee(empDto);
	}
	
	@GetMapping("/get")
	public List<EmployeePayrollData> getEmployee(){
		return empService.getAll();
	}
	
	@GetMapping("/get/{id}")
	public EmployeePayrollData getById(@PathVariable long id) {
		return empService.getEmployeeById(id);
	}
	
	@PutMapping("/update/{id}")
	public EmployeePayrollData updateEmployee(@PathVariable long id,@RequestBody EmployeePayrollDto empDto) {
		return empService.updateEmp(id, empDto);
//				repo.findById(id).map((i)->{
//    		i.setName(name);
//    		return repo.save(i);
//    	}).orElseThrow(() -> new RuntimeException("Employee not found"));
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable long id) {
		empService.deleteEmployeeById(id);
		return "Deleted row ID " + id;
	}
}
