package com.deepak.admissionservice.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.deepak.admissionservice.models.DiseasesList;
import com.deepak.admissionservice.models.EmployeesList;
import com.deepak.admissionservice.models.Patient;

@RestController
@RequestMapping("/admissions")
public class AdmissionsResources {
	
	@Autowired
	private RestTemplate restTepmplate;

	private List<Patient> patients = Arrays.asList(new Patient("P1", "ABC", "Delhi"),
			new Patient("P2", "DEF", "Bangalore"), new Patient("P3", "GHI", "Finland"),
			new Patient("P4", "JKL", "Paris"));

	@GetMapping("/physicians")
	public EmployeesList getPhysician(){
		
		return restTepmplate.getForObject("http://localhost:8082/hr/employees", EmployeesList.class);
		
		
	}
	
	@GetMapping(value = "/patients")
	public List<Patient> getPatients() {

		return patients;

	}

	@GetMapping(value = "patients/{Id}")
	public Patient getPatientById(@PathVariable("Id") String id) {
		return patients.stream().filter(pat -> id.equals(pat.getId())).findAny().orElse(null);
	}
	
	@GetMapping("/diseases")
	public DiseasesList getDiseases(){
		
		return restTepmplate.getForObject("http://localhost:8083pathology/disease", DiseasesList.class);
		
		
	}

}
