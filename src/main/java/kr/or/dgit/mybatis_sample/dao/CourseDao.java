package kr.or.dgit.mybatis_sample.dao;

import java.util.List;
import java.util.Map;

import kr.or.dgit.mybatis_sample.dto.Course;

public interface CourseDao {
	List<Course> selectCoursesByCondition(Map<String, Object> map);

	// choose조건
	List<Course> selectCaseCourses(Map<String, Object> map);

	// where조건
	List<Course> selectWhereCourses(Map<String, Object> map);

	// trim조건

	List<Course> selectTrimCourses(Map<String, Object> map);
	
	//foreach조건
	List<Course> selectCoursesForeachByTutors(Map<String, Object> map);
}
