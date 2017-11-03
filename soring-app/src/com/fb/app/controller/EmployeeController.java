package com.fb.app.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fb.app.bean.Employee;
import com.fb.app.bean.EmployeeListVO;
import com.fb.app.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	
	@Autowired
	EmployeeService empService;
	
	@GetMapping("/test")
	public String testService() {
		return "Hi This is soring app service";
	}
	
	@GetMapping("/list/{compnay}") 
	public @ResponseBody EmployeeListVO getAllEmployees(@PathVariable(value="compnay") String compnayName,@RequestParam String country,@RequestParam String region) {
		System.out.println("Company Name->" + compnayName + "country name --> " + country + "Region ----->" + region);
		
		return empService.getEmployeesList();
		
	}
	
	
	@PostMapping("/create")
	public @ResponseBody String createEmployee(@RequestParam String firstName,@RequestParam String lastName) {
		
		//Employee one = new Employee("1","Raj","Gupta");
		
		Employee one = new Employee();
		one.setFirstName(firstName);
		one.setLastName(lastName);
		
		empService.createEmployee(one);
		
		return "done!";
		
	}
	
	@GetMapping("/read/{empid}")
	public @ResponseBody Employee readEmployee(@PathVariable(value="empid") int empid) {
		
		return empService.readEmployee(empid);
		
	}
	
	@PostMapping("/update")
	public @ResponseBody String updateEmployee(@RequestParam int empid,@RequestParam String firstName,@RequestParam String lastName) {
		
		 empService.updateEmployee(empid, firstName, lastName);
		 return "done!";
		
	}
	
	@DeleteMapping("/delete")
	public @ResponseBody String deleteEmployee(@RequestParam int empid) {
		 empService.deleteEmployee(empid);
		 return "done!";

	}
}
