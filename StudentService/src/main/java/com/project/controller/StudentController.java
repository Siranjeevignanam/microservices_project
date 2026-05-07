package com.project.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Student;
import com.project.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService service;
	
	@PostMapping("/save")
	public ResponseEntity<Student> saveStudent(@Valid @RequestBody Student s)
	{
		return ResponseEntity.ok(service.saveStudent(s));
		
//	URI loc=URI.create("/student"+s.getId());
//	return ResponseEntity.status(HttpStatus.CREATED).body(service.saveStudent(s));
	}
	
	@GetMapping("/getStudent/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable Long id)
	{
		return ResponseEntity.ok(service.getStudentById(id));
	}
	
	
	@PutMapping("update/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable Long id,@Valid @RequestBody Student S)
	{
		return ResponseEntity.ok(service.updateStudent(id, S));
		}
	

	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Long id)
	{
		return  ResponseEntity.ok(service.deleteStudent(id));
	}
}
