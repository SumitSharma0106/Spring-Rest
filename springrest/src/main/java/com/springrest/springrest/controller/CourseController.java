package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entity.Course;
import com.springrest.springrest.service.CourseService;

@RestController
@RequestMapping("/course/v1")
public class CourseController {
	
	@Autowired
	CourseService courseService ;
	
	@GetMapping("/all")
	public List<Course> getCourse(){
		return courseService.getCourses();
	}
	
	@GetMapping("/{id}")
	public Course getCourseByID(@PathVariable long id) {
		return courseService.getCourseById(id);
	}
	
	@PostMapping("/add")
	public Course addCourse(@RequestBody Course course) {
		return courseService.addCourse(course);
		
	}
	
	@PutMapping("/update")
	public Course updateCourse(@RequestBody Course course) {
		return courseService.updateCourse(course);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteCourse(@PathVariable long id) {
		courseService.deleteCourse(id);
	}

}
