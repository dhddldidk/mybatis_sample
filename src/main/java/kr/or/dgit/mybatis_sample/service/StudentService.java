package kr.or.dgit.mybatis_sample.service;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.mybatis_sample.dao.StudentDao;
import kr.or.dgit.mybatis_sample.dao.StudentDaoImpl;
import kr.or.dgit.mybatis_sample.dto.Student;
import kr.or.dgit.mybatis_sample.util.MyBatisSqlSessionFactory;

public class StudentService {
	private static final Log log = LogFactory.getLog(StudentDaoImpl.class);
	private String namespace = "kr.or.dgit.mybatis_sample.dao.StudentDao.";
	
	public Student findStudentByNo(Student student) {
		log.debug("selectStudentByNo()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			return studentDao.selectStudentByNo(student);
		}
	}

	public List<Student> findStudentByAll() {
		log.debug("selectStudentByAll()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			return studentDao.selectStudentByAll();
		}
	}

	public Student findStudentByNoWithAPI(Student student) {
		log.debug("selectStudentByNo()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			return sqlSession.selectOne(namespace+"selectStudentByNoWithAPI", student);
		}
	}

	public List<Student> findStudentByAllWithAPI() {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			log.debug("selectStudentByAllWithAPI()");
			return sqlSession.selectList(namespace+"selectStudentByAllWithAPI");
		}
	}

	public int insertStudent(Student student) {
		log.debug("insertStudent()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			int res = sqlSession.insert(namespace+"insertStudentWithAPI", student);
			sqlSession.commit();
			return res;
		}

	}

	public int insertStudentWithAPI(Student student) {
		
		log.debug("insertStudent()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			int res = sqlSession.insert(namespace+"insertStudentWithAPI", student);
			sqlSession.commit();
			return res;
		}

	}
}
