package com.ibm.spring_boot_simple_project.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibm.spring_boot_simple_project.dto.College;
import com.ibm.spring_boot_simple_project.repository.CollegeRepository;

@Repository
public class CollegeDao {

	@Autowired
	CollegeRepository collegeRepository;
	
	public College saveCollegeDao(College college) {
		return collegeRepository.save(college);
	}
	
	public List<College> saveMultipleCollegeDao(List<College> college) {
		return collegeRepository.saveAll(college);
	}
	
	public College fetchCollegeByIdDao(int collegeId) {
		Optional<College> optional=collegeRepository.findById(collegeId);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}
	
	public List<College> getAllCollegeDao(){
		
		return collegeRepository.findAll();
	}
	
	public List<College> getCollegeByNameDao(String name) {
		return collegeRepository.findByName(name);
	}
	
	public List<College> getCollegeByTypeDao(String type){
		return collegeRepository.getCollegeByType(type);
	}
	
	public College deleteCollegeByIdDao(int id) {
		College college=fetchCollegeByIdDao(id);
		
		if(college!=null) {
			 collegeRepository.delete(college);
			return college;
		}else {
			return null;
		}
	}
}
