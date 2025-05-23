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

import com.bridgelabz.EmployeePayrollServiceLayer.model.EmployeeModel;
import com.bridgelabz.EmployeePayrollServiceLayer.repository.EmployeeRepository;


@RestController
@RequestMapping("/employee")
public class EmployeePayrollController {
	
	@Autowired
	private EmployeeRepository repo;
	
	@GetMapping("/")
	public String Hello() {
		return "Hello";
	}
	
	
	
	@PostMapping("/post")
	public EmployeeModel postEmployee(@RequestBody EmployeeModel emp) {
		return repo.save(emp);
	}
	
	@GetMapping("/get")
	public List<EmployeeModel> getEmployee(){
		return repo.findAll();
	}
	
	@GetMapping("/get/{id}")
	public EmployeeModel getById(@PathVariable long id) {
		return repo.findById(id).orElseThrow(()-> new RuntimeException("Employee With ID Not Found"));
	}
	
	@PutMapping("/update/{id}")
	public EmployeeModel updateEmployee(@PathVariable long id,@RequestParam(name="name") String name) {
		return repo.findById(id).map((i)->{
    		i.setName(name);
    		return repo.save(i);
    	}).orElseThrow(() -> new RuntimeException("Employee not found"));
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable long id) {
		repo.deleteById(id);
		return "Deleted row ID " + id;
	}
}
