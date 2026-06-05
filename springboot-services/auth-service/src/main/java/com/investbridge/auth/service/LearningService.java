package com.investbridge.auth.service;

import com.investbridge.auth.entity.Course;
import com.investbridge.auth.entity.Quiz;
import com.investbridge.auth.repository.CourseRepository;
import com.investbridge.auth.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LearningService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private QuizRepository quizRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    public List<Quiz> getQuizzesForCourse(Long courseId) {
        return quizRepository.findByCourseId(courseId);
    }

    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }
}
