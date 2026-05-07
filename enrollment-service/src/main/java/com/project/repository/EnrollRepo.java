package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.Enrollment;


@Repository
public interface EnrollRepo extends JpaRepository<Enrollment, Long> {

}
