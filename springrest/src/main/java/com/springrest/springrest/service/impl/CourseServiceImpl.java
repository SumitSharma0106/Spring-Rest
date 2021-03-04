package com.springrest.springrest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.entity.Course;
import com.springrest.springrest.repository.CourseRepository;
import com.springrest.springrest.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	
	@Autowired
	private CourseRepository courseRepository;


	@Override
	public List<Course> getCourses() {
		return courseRepository.findAll();
	}

	@Override
	public Course getCourseById(long id) {
		return courseRepository.findById(id).get();
	}

	@Override
	public Course addCourse(Course course) {
		return courseRepository.save(course);
	}

	@Override
	public Course updateCourse(Course course) {
		return courseRepository.save(course);
	}

	@Override
	public void deleteCourse(long id) {
		courseRepository.deleteById(id);		
	}
	

}
