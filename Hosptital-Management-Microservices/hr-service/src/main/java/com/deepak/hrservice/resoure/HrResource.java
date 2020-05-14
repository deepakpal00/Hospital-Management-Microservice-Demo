package com.deepak.hrservice.resoure;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deepak.hrservice.Models.Employee;
import com.deepak.hrservice.Models.EmployeesList;

@RestController
@RequestMapping("/hr")
public class HrResource {

	List<Employee> employee = Arrays.asList(
		new Employee("E1", "Deepak", "Munonye", "MediTech"),
			new Employee("E2", "Sunnny", "Hardcastle", "Surgery"),
			new Employee("E1", "You", "Chucks", "Dentistry"));
			
	@GetMapping(value="/employees")
	private EmployeesList getEmployees(){
		EmployeesList employeesList = new EmployeesList();
		employeesList.setEmployees(employee);
		
		return employeesList;
	}
	
	@GetMapping(value="/employees/{Id}")
	private Employee getEmployeesById(@PathVariable("Id") String id){
		return employee.stream().filter(emp-> id.equals(emp.getId())).findAny().orElse(null);
	}
	
}
  