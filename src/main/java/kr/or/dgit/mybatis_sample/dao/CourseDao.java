package kr.or.dgit.mybatis_sample.dao;

import java.util.List;
import java.util.Map;

import kr.or.dgit.mybatis_sample.dto.Course;



public interface CourseDao {
	List<Course> selectCoursesByCondition(Map<String, Object> map);
}
