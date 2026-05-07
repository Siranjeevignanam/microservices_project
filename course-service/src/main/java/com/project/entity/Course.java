package com.project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity

public class Course {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message="Course name can't be blank")
	private String coursename;
	private String description;
	@NotNull
	private Integer credits;
	public Course()
	{
		
	}
	public Course(Long id, @NotBlank(message = "COurse name can't be blank") String coursename, String description,
			@NotNull Integer credits) {
		super();
		this.id = id;
		this.coursename = coursename;
		this.description = description;
		this.credits = credits;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getCredits() {
		return credits;
	}
	public void setCredits(Integer credits) {
		this.credits = credits;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", coursename=" + coursename + ", description=" + description + ", credits="
				+ credits + "]";
	}

}
