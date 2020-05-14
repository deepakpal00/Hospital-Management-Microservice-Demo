package com.deepak.pathologyservice.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deepak.pathologyservice.Model.Disease;
import com.deepak.pathologyservice.Model.DiseasesList;

@RestController
@RequestMapping("/pathology")
public class PatholoryResource {

	List<Disease> disease = Arrays.asList(
			new Disease("D1", "Asthma", "warm water bath"),
			new Disease("D2", "Thyphoid", "Amplicilin capsule"));
	
	
	@GetMapping(value="/disease")
	private DiseasesList getDiseases(){
		
		DiseasesList diseasesList = new DiseasesList();
		diseasesList.setDiseaseList(disease);
		return diseasesList;
	}
	
	@GetMapping(value = "/disease/{id}")
	private Disease getDisease(@PathVariable("id") String id) {
		   return disease.stream().filter(dis -> id.equals(dis.getId())).findAny().orElse(null);
	}
	
}
