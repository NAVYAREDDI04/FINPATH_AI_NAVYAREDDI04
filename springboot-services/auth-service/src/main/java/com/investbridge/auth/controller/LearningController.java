package com.investbridge.auth.controller;

import com.investbridge.auth.entity.Course;
import com.investbridge.auth.entity.Quiz;
import com.investbridge.auth.service.LearningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LearningController {

    @Autowired
    private LearningService learningService;

    @GetMapping("/courses")
    public List<Course> getCourses() {
        return learningService.getAllCourses();
    }

    @PostMapping("/courses")
    public Course createCourse(@RequestBody Course course) {
        return learningService.saveCourse(course);
    }

    @GetMapping("/course/{id}")
    public Course getCourse(@PathVariable Long id) {
        return learningService.getCourseById(id)
                .orElse(null);
    }

    @GetMapping("/quizzes/{courseId}")
    public List<Quiz> getQuizzes(@PathVariable Long courseId) {
        return learningService.getQuizzesForCourse(courseId);
    }
}
