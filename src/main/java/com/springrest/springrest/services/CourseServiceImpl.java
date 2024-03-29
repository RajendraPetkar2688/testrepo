package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {
 
	//List<Course> list;
	@Autowired
	private CourseDao courseDao;
	
	public CourseServiceImpl()
	{
//		list = new ArrayList<>();
//		list.add(new Course(145, "Java", "Java course"));
//		list.add(new Course(2628, "Spring", "Spring Boot Course"));
//		list.add(new Course(122, "Python", "Python Course"));
	}
	
	
	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		//return list;
		return courseDao.findAll();
	}


	@Override
	public Course getCourse(long courseId) {
//		Course c=null;
//		for(Course course :list)
//		{
//			if(course.getId()==courseId)
//			{
//				c=course;
//				break;
//			}
//		}
		return courseDao.getOne(courseId);
	}


	@Override
	public Course addCourse(Course course) {
	//	list.add(course);
		courseDao.save(course);
		return course;
	}


	@Override
	public Course updateCourse(Course course) {
//		list.forEach(e -> {
//			if(e.getId()==course.getId()) {
//				e.setTitle(course.getTitle());
//				e.setDescription(course.getDescription());
//			}
//		});
		courseDao.save(course);
		return course;
	}


	@Override
	public void deleteCourse(long parsLong) {
//		list=this.list.stream().filter(e -> e.getId()!=parsLong).collect(Collectors.toList());
		Course entity=courseDao.getOne(parsLong);
		courseDao.delete(entity);
		
		
	}

}
