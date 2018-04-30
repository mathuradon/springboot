package com.in28minutes.jpa.hibernate.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.in28minutes.jpa.hibernate.demo.entity.Course;

public interface CourseRepository2 extends CrudRepository<Course, Long> {

}
