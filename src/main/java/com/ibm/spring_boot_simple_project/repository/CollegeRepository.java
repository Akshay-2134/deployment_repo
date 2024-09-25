package com.ibm.spring_boot_simple_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ibm.spring_boot_simple_project.dto.College;

public interface CollegeRepository extends JpaRepository<College,Integer> {

//	public List<College> findByName(String name);
	
public List<College> findByName(String name);
	
	@Query(value = "SELECT * FROM college Where type=?1",nativeQuery = true)
	public List<College> getCollegeByType(String type);
}
