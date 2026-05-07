package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Enrollment;
import com.project.entity.EnrollmentDTO;
import com.project.service.EnrollService;

@RestController
@RequestMapping("/enrollment")
public class EnrollmentController {
	
	@Autowired
	EnrollService service;
	
	@PostMapping("/save")
	public Enrollment save(@RequestBody Enrollment e)
	{
		return service.saveEnroll(e);
	}

	@GetMapping("/getall")
	public List<Enrollment> getAll()
	{
		return service.listEnroll();
	}
	
	@GetMapping("get/{id}")
	public EnrollmentDTO getEnrollmentById(@PathVariable Long id)
	{
		return service.getEnrollment(id);
	}
}
