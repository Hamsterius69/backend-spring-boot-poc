package com.hamster.backendsprintpoc.service;

import java.util.List;

import com.hamster.backendsprintpoc.entity.Course;
import com.hamster.backendsprintpoc.model.CourseModel;

public interface CourseService {

	public abstract List<CourseModel> listAllCourses();
	public abstract Course addCourse(CourseModel course);
	public abstract int removeCourse(int id);
	public abstract Course updateCourse(CourseModel course);
}
