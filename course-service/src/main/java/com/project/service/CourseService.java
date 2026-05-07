package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Course;
import com.project.repository.CourseRepo;

@Service
public class CourseService {
	
	@Autowired
	CourseRepo repo;
	
	public Course saveCourse(Course c)
	{
		return repo.save(c);
	}
	

	public List<Course> getAllCourses()
	{
		return repo.findAll();
	}
	
	public Course getCourseById(Long id)
	{
		return repo.findById(id).orElseThrow(()->new RuntimeException("No course with the given id found"));
	}
}
