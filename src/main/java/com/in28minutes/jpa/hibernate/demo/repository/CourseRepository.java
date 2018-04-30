package com.in28minutes.jpa.hibernate.demo.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.in28minutes.jpa.hibernate.demo.entity.Course;

@Repository
@Transactional
public class CourseRepository  {
	
	@Autowired
	EntityManager em;
	
	//find Course by Id
	public Course findById(Long id) {
		return em.find(Course.class, id);
	}
	
	/**
	 * @save or @Update DATA
	 * if @ID is null, insert the Data 
	 * if @ID NOT null, Update the Data
	 */
	public Course save(Course course) {
		
		if(course.getId()==null) {
			em.persist(course);
		}
		else {
			em.merge(course);
		}
		return course;
	}
	
	/**
	 * @Insert or @Update
	 * @Delete 
	 */
	public void deleteById(Long id) {
		Course course = findById(id);
		em.remove(course);
	}
		

	
}
