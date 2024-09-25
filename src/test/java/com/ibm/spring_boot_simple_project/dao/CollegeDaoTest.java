package com.ibm.spring_boot_simple_project.dao;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ibm.spring_boot_simple_project.dto.College;
import com.ibm.spring_boot_simple_project.repository.CollegeRepository;

@ExtendWith(MockitoExtension.class)
class CollegeDaoTest {

	@Mock
	CollegeRepository collegeRepository;

	@InjectMocks
	CollegeDao collegeDao;

	College college;

	@BeforeEach
	void createCollegeObject() {

		college = College.builder().id(123).name("aktu").address("noida").type("enginerring").build();
	}

	@Test
	public void saveCollegeDaoTest() {
		when(collegeRepository.save(college)).thenReturn(college);

		College college1 = collegeDao.saveCollegeDao(college);

		assertEquals(123, college1.getId());
	}

	@Test
	public void fetchCollegeByIdFoundTest() {
		when(collegeRepository.findById(123)).thenReturn(Optional.of(college));
		
		College college=collegeDao.fetchCollegeByIdDao(123);
		
		assertEquals(123,college.getId());
	}

}
