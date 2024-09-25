package com.ibm.spring_boot_simple_project.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;

import com.ibm.spring_boot_simple_project.dao.CollegeDao;
import com.ibm.spring_boot_simple_project.dto.College;
import com.ibm.spring_boot_simple_project.response.ResponseStructure;
import com.ibm.spring_boot_simple_project.service.CollegeService;

@RestController
public class CollegeController {
	
	@Autowired
	private CollegeService service;

	@Autowired
	private CollegeDao collegeDao;
	
	@GetMapping(value = "/getTodaysDate")
	public String getData() {
		System.out.println("ge");
		return "today date is " + LocalDate.now() + " date";
	}

	@PostMapping(value = "/saveCollege")
	public ResponseStructure<College> saveCollegeController(@RequestBody College college) {
		return service.saveCollegeService(college);
	}

	@PostMapping(value = "/saveMultipleCollege")
	public List<College> saveMultipleCollegeController(@RequestBody List<College> college) {
		return collegeDao.saveMultipleCollegeDao(college);
	}

	@GetMapping(value = "/fetchCollegeById/{collegeId}")
	public ResponseStructure<College> fetchCollegeByIdController(@PathVariable int collegeId) {
		return  service.fetchCollegeByIdService(collegeId);
	}

	@GetMapping(value = "/getAllCollegeData")
	public ResponseEntity<List<College>> getAllCollegeController() {
		
		return new ResponseEntity<List<College>>(collegeDao.getAllCollegeDao(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getCollegeByName/{name}")
	public ResponseStructure<List<College>> getCollegeByNameController(@PathVariable String name) {
		return service.getCollegeByNameService(name);
	}
	
	@GetMapping(value = "/getCollegeByType/{type}")
	public List<College> getCollegeByTypeController(@PathVariable String type){
		return collegeDao.getCollegeByTypeDao(type);
	}
	
	/*
	 * UpdateCollegeById
	 */
	
	@PutMapping(value = "/updateCollege")
	 public ResponseStructure<College> updateCollegeByIdService(@RequestBody  College college){
		 return service.updateCollegeByIdService(college);
	 }
	
	@PutMapping(value = "/updateCollege/{id}/{name}")
	 public ResponseStructure<College> updateCollegeNameById(@PathVariable  int  id,@PathVariable String name){
		 return service.updateCollegeByIdAndNameService(id,name);
	 }
	
	
	@DeleteMapping(value = "/deleteCollegeById/{id}")
	 public ResponseStructure<College> deleteCollegeNameById(@PathVariable  int  id){
		 return service.deleteCollegeByIdService(id);
	 }
	 
}
