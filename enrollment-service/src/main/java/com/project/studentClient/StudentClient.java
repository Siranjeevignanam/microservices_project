package com.project.studentClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.project.entity.StudentDTO;

@FeignClient(name="student-service")
public interface StudentClient 
{
	
	@GetMapping("/student/getStudent/{id}")
	ResponseEntity<StudentDTO> getStudentById(@PathVariable Long id);
	

}
