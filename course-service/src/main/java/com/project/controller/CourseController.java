package com.project.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Course;
import com.project.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	CourseService service;
	
	
	@PostMapping("/save")
	public ResponseEntity<Course> saveCourse(@RequestBody Course c)
	{
		URI loc=URI.create("/course"+c.getId());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.saveCourse(c));
	}
	
	
	@GetMapping("/listcourses")
	public ResponseEntity<List<Course>> getAllCourses()
	{
		return ResponseEntity.ok(service.getAllCourses());
	}
	
	@GetMapping("/getcourse/{id}")
public ResponseEntity<Course> getCourseById(@PathVariable Long id)
{
		return ResponseEntity.ok(service.getCourseById(id));
}
}
