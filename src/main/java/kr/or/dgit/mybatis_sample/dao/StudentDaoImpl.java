package kr.or.dgit.mybatis_sample.dao;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.mybatis_sample.dto.Student;

public class StudentDaoImpl implements StudentDao {
	private static final Log log = LogFactory.getLog(StudentDaoImpl.class);

	private StudentDao studentDao;
	
	public StudentDaoImpl(SqlSession sqlSession) {
		studentDao = sqlSession.getMapper(StudentDao.class);
	}

	@Override
	public Student selectStudentByNo(Student student) {
		log.debug("selectStudentByNo()");
		return studentDao.selectStudentByNo(student);
	}

	@Override
	public List<Student> selectStudentByAll() {
		log.debug("selectStudentByAll()");
		return studentDao.selectStudentByAll();
	}

}
