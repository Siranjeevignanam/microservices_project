package com.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Student;
import com.project.exceptionhandling.StudentNotFound;
import com.project.repo.StudentRepo;

@Service
public class StudentService {
	
	
	@Autowired
	StudentRepo repo;
	
	
	public Student saveStudent(Student s)
	{
		return repo.save(s);
	}
	
	
	public Student getStudentById(Long id)
	{
		return repo.findById(id).orElseThrow(()->new StudentNotFound("Student not found"));
				
				//orElseThrow(() -> new RuntimeException("Student not found"));
	}

	public Student updateStudent(Long id,Student s)
	{
		Student existing= repo.findById(id).orElseThrow(()-> new RuntimeException("No such existing student"));
		 existing.setDepartment(s.getDepartment());
		 existing.setEmail(s.getEmail());
		 existing.setName(s.getName());
		 
		 return repo.save(existing);
		
	
	}
	
	public String deleteStudent(Long id)
	{
		repo.deleteById(id);
		
		return "Student with" +id+ "was deleted";
	}
}
