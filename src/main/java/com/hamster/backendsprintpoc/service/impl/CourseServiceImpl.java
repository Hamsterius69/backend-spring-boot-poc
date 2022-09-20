package com.hamster.backendsprintpoc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hamster.backendsprintpoc.converter.CourseConverter;
import com.hamster.backendsprintpoc.entity.Course;
import com.hamster.backendsprintpoc.model.CourseModel;
import com.hamster.backendsprintpoc.repository.CourseJpaRepository;
import com.hamster.backendsprintpoc.service.CourseService;

@Service("courseServiceImpl")
public class CourseServiceImpl implements CourseService {


	private static final Log LOG = LogFactory.getLog(CourseServiceImpl.class);
	
	@Autowired
	@Qualifier("courseJpaRepository")
	private CourseJpaRepository courseJpaRepository;
	
	@Autowired
	@Qualifier("courseConverter")
	private CourseConverter courseConverter;
	
	@Override
	public List<CourseModel> listAllCourses() {
		LOG.info("call: listAllCourses()");
		List<Course> courseResponse = courseJpaRepository.findAll();
		List<CourseModel> courseListModel = new ArrayList<>();
		int size = courseResponse.size();
		for(int i = 0; i < size; i++) {
			courseListModel.add(courseConverter.entityToModel(courseResponse.get(i)));
		}
		return courseListModel;
	}

	@Override
	public Course addCourse(CourseModel course) {
		LOG.info("call: addCourse()");
		return courseJpaRepository.save(courseConverter.modelToEntity(course));
	}

	@Override
	public int removeCourse(int id) {
		return courseJpaRepository.deleteById(id);
	}

	@Override
	public Course updateCourse(CourseModel course) {
		return courseJpaRepository.save(courseConverter.modelToEntity(course));
	}

}
