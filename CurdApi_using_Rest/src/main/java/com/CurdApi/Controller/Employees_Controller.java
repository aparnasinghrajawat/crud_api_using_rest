package com.CurdApi.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CurdApi.Entity.Employees;
import com.CurdApi.Repository.Employee_repo;

@RestController 
@RequestMapping("/api")
public class Employees_Controller {
	@Autowired
	Employee_repo employee_repo;
	
	
	
	
	//add data
	@PostMapping("/employee")
	public String createEmployee(@RequestBody Employees employee) {
		
		employee_repo.save(employee);
		return  "employee created successfully in Database";
	}
	
	
	
	
	
	//find all data 
	@GetMapping("/employee")
	public ResponseEntity<List<Employees>> getEmployees( ){
		List<Employees> employeesList =new ArrayList<>();
		employee_repo.findAll().forEach(employeesList :: add);
		return new  ResponseEntity<List<Employees>> (employeesList,HttpStatus.OK);
	}
	
	
	
	
	// find by id
	@GetMapping("/employee/{empID}")
	public ResponseEntity <Employees> getEmployeesID(@PathVariable long id ){
		Optional<Employees> emp=employee_repo.findById(id);
		if(emp.isEmpty()) {
			return new ResponseEntity<Employees>(emp.get(),HttpStatus.FOUND);
		}else {
			return new ResponseEntity<Employees>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	
	//UPDATE THE DATA
	@PutMapping("/employee/{empId}")
	public String updateEmployeeByID(@PathVariable long empId,@RequestBody Employees employees) {
		Optional<Employees> emp=employee_repo.findById(empId);
		if(emp.isPresent()) {
			Employees exitEmployees =emp.get();
			exitEmployees.setEmp_name(employees.getEmp_name());
			exitEmployees.setEmp_salary(employees.getEmp_salary());
			exitEmployees.setEmp_age(employees.getEmp_age());
			exitEmployees.setEmp_city(employees.getEmp_city());
			employee_repo .save(exitEmployees);
			return "Employees details agains ID "+empId+" updated ";
		}
		else {
			return "ReEmployees details not exists for empid " +empId;
		}
	}
	
	
	
	
	//delete by id
	@DeleteMapping("/employee/{empId}")
	public String deleteEmployeeById (@PathVariable long empId) {
		employee_repo.deleteById(empId);
		return "empoyees details ";
	}
	
	
	
	
	//delete all data in database
	@DeleteMapping("/employee")
	public String deleteAllEmployee() {
		employee_repo.deleteAll();
		return "Employee data deleted succesfully";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	 

}
