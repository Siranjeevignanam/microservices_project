package com.project.courseclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.project.entity.CourseDTO;

@FeignClient(name = "course-service")
public interface CourseClient {

    @GetMapping("/course/getcourse/{id}")
    ResponseEntity<CourseDTO> getCourseById(@PathVariable("id") Long id);

}