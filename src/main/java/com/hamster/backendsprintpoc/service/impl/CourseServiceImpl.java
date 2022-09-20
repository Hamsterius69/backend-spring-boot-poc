package com.hamster.backendsprintpoc.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.hamster.backendsprintpoc.entity.Course;
import com.hamster.backendsprintpoc.repository.CourseJpaRepository;
import com.hamster.backendsprintpoc.service.CourseService;

@Service("courseServiceImpl")
public class CourseServiceImpl implements CourseService {


	private static final Log LOG = LogFactory.getLog(CourseServiceImpl.class);
	
	@Autowired
	@Qualifier("courseJpaRepository")
	private CourseJpaRepository courseJpaRepository;
	
	@Override
	public List<Course> listAllCourses() {
		LOG.info("call: listAllCourses()");
		return courseJpaRepository.findAll();
	}

	@Override
	public Course addCourse(Course course) {
		LOG.info("call: addCourse()");
		return courseJpaRepository.save(course);
	}

	@Override
	public int removeCourse(int id) {
		return courseJpaRepository.deleteById(id);
	}

	@Override
	public Course updateCourse(Course course) {
		return courseJpaRepository.save(course);
	}

}
