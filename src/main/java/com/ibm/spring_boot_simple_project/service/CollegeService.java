package com.ibm.spring_boot_simple_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ibm.spring_boot_simple_project.dao.CollegeDao;
import com.ibm.spring_boot_simple_project.dto.College;
import com.ibm.spring_boot_simple_project.exception.IdNotFoundException;
import com.ibm.spring_boot_simple_project.exception.NameNotFoundException;
import com.ibm.spring_boot_simple_project.repository.CollegeRepository;
import com.ibm.spring_boot_simple_project.response.ResponseStructure;



@Service
public class CollegeService {

	@Autowired
	private CollegeDao dao;
	
	@Autowired
	private CollegeRepository cr;

	@Autowired
	private ResponseStructure<College> structure;

	@Autowired
	private ResponseStructure<java.util.List<College>> structure2;

	public ResponseStructure<College> saveCollegeService(College college) {

		College college2 = dao.saveCollegeDao(college);
		if (college2 != null) {
			structure.setStatusCode(HttpStatus.CREATED.value());
			structure.setMessage("successfully data stored.....");
			structure.setData(college2);
			return structure;
		} else {
			structure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			structure.setMessage("data not stored.....");
			structure.setData(college2);
			return structure;
		}
	}

	public ResponseStructure<College> fetchCollegeByIdService(int collegeId) {

		College college = dao.fetchCollegeByIdDao(collegeId);

		if (college != null) {
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setMessage("Data found......");

			structure.setData(college);

			return structure;
		} else {
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			structure.setMessage("given id is not present ..data not found......");
			structure.setData(college);
			return structure;
		}
	}

	/*
	 * 
	 * fetch Student by id
	 */

	public ResponseStructure<java.util.List<College>> getCollegeByNameService(String name) {
		java.util.List<College> colleges = dao.getCollegeByNameDao(name);

		if (!colleges.isEmpty()) {
			structure2.setStatusCode(HttpStatus.FOUND.value());
			structure2.setMessage("data found");
			structure2.setData(colleges);
			return structure2;
		} else {
			throw new NameNotFoundException("Given name is not found in database");
		}
	}

	/*
	 * UpdateCollegeById
	 */
	public ResponseStructure<College> updateCollegeByIdService(College college) {
		College c1 = dao.fetchCollegeByIdDao(college.getId());
		if (c1 != null) {
			dao.saveCollegeDao(college);
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			structure.setMessage("Data  Succesfully Updated");
			structure.setData(c1);
			return structure;
		} else {
			throw new IdNotFoundException("Given id is not found");
		}
	}

	public ResponseStructure<College> updateCollegeByIdAndNameService(int id, String name) {
		College c1 = dao.fetchCollegeByIdDao(id);
		if (c1 != null) {
			c1.setName(name);
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			structure.setMessage("Data  Succesfully Updated");
			structure.setData(c1);
			return structure;
		} else {
			throw new IdNotFoundException("Given id is not found");
		}
	}

	public ResponseStructure<College> deleteCollegeByIdService(int id) {

		College college = dao.deleteCollegeByIdDao(id);

		if (college != null) {

			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			structure.setMessage("Data  Succesfully Deleted");
			structure.setData(null);
			return structure;
		} else {
			throw new IdNotFoundException("Given id is not found");
		}
	}

}
