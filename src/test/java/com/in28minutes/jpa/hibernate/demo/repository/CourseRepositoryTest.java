package com.in28minutes.jpa.hibernate.demo.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.jpa.hibernate.demo.DemoApplication;
import com.in28minutes.jpa.hibernate.demo.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class CourseRepositoryTest {

	@Autowired
	CourseRepository repository;
	
	@Test
	public void findById_basic() {
		Course course = repository.findById(10001L);
		assertEquals("JPA in 100 Steps", course.getName()); //(Expected, actual Value)
	}
	
	@Test
	@DirtiesContext						//For DELETE 
	public void deleteById_basic() {
		repository.deleteById(10002L);
		assertNull(repository.findById(10002L)); 
	}
	
	@Test
	@DirtiesContext						//For SAVE 
	public void saveById_basic() {
		/** @STEPS */
		//1.get a course
		Course course = repository.findById(10001L);
		assertEquals("JPA in 100 Steps", course.getName());
		//update Details
		course.setName("JPA in 100 Steps -Updated");
		repository.save(course);
		//check the value
		Course course1 = repository.findById(10001L);
		assertEquals("JPA in 100 Steps -Updated", course1.getName());	
	}

}
