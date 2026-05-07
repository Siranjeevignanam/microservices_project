package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.courseclient.CourseClient;
import com.project.entity.CourseDTO;
import com.project.entity.Enrollment;
import com.project.entity.EnrollmentDTO;
import com.project.entity.StudentDTO;
import com.project.repository.EnrollRepo;
import com.project.studentClient.StudentClient;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class EnrollService {

	
	@Autowired
	EnrollRepo repo;
	
	@Autowired
	StudentClient sclient;
	@Autowired
	CourseClient cclient;
//	
//	public Enrollment saveEnroll(Enrollment e)
//	
//	{
//		
//		ResponseEntity<StudentDTO> stud=sclient.getStudentById(e.getStudentId());
//		ResponseEntity<CourseDTO> cou= cclient.getCourseById(e.getCourseId());
//		
//		StudentDTO student=stud.getBody();
//		CourseDTO course=cou.getBody();
//		
//		if(student==null || course==null)
//			
//		{
//throw new RuntimeException("Student not found with given id");
//		}
//		return repo.save(e);
//	}
	
	
	public Enrollment saveEnroll(Enrollment e) {
	    try {
	        ResponseEntity<StudentDTO> stud = sclient.getStudentById(e.getStudentId());
	        ResponseEntity<CourseDTO> cou = cclient.getCourseById(e.getCourseId());

	        if (stud.getBody() == null || cou.getBody() == null) {
	            throw new RuntimeException("Student or Course not found");
	        }

	        return repo.save(e);

	    } catch (Exception ex) {
	        throw new RuntimeException("Error while calling other services: " + ex.getMessage());
	    }
	}
	
	public List<Enrollment> listEnroll()
	{
		return repo.findAll();
	}
	
	
	public EnrollmentDTO getEnrollment(Long id)
	{
		Enrollment enrollment = repo.findById(id).get();
		
		ResponseEntity<StudentDTO> stu= sclient.getStudentById(enrollment.getStudentId());
		ResponseEntity<CourseDTO> cou =cclient.getCourseById(enrollment.getCourseId());
		
		StudentDTO student=stu.getBody();
		CourseDTO course=cou.getBody();
		
		//@Autowired
		EnrollmentDTO edto=new EnrollmentDTO();
		edto.setCourse(course);
		edto.setStudent(student);
		edto.setId(enrollment.getEnrollmentId());
		
		return edto;
		
	}
	
	
	@CircuitBreaker(name="student-service" ,fallbackMethod="fallback")
	public ResponseEntity<StudentDTO> getStudentById(Long id)
	{
		ResponseEntity<StudentDTO> stud=sclient.getStudentById(id);
		return stud;
	}
	
	public ResponseEntity<StudentDTO> fallback()

	{
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(null);
	}
}
