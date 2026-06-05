package com.investbridge.auth.repository;

import com.investbridge.auth.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
