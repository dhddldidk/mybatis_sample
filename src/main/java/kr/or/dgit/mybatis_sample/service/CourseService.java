package kr.or.dgit.mybatis_sample.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.mybatis_sample.dao.CourseDao;
import kr.or.dgit.mybatis_sample.dto.Course;
import kr.or.dgit.mybatis_sample.util.MyBatisSqlSessionFactory;

public class CourseService {
	private static final Log log = LogFactory.getLog(CourseService.class);
	
	public List<Course> selectCoursesByCondition(Map<String, Object> map) {
		log.debug("selectCoursesByCondition()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			CourseDao courseDao = sqlSession.getMapper(CourseDao.class);
			return courseDao.selectCoursesByCondition(map);
		}
	}
}
