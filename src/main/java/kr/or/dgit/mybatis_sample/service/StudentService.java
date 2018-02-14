package kr.or.dgit.mybatis_sample.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.mybatis_sample.dao.StudentDao;
import kr.or.dgit.mybatis_sample.dto.Student;
import kr.or.dgit.mybatis_sample.util.MyBatisSqlSessionFactory;



public class StudentService {
	private static final Log log = LogFactory.getLog(StudentService.class);
	private String namespace = "kr.or.dgit.mybatis_sample.dao.StudentDao.";

	

	public Student findStudentByNoWithAPI(Student student) {
		log.debug("findStudentByNoWithAPI()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + "selectStudentByNoWithAPI", student);
		}
	}

	public List<Student> findStudentByAllWithAPI() {
		log.debug("findStudentByAllWithAPI()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + "selectStudentByAllWithAPI");
		}
	}


	public int createStudentWithAPI(Student student) {
		log.debug("createStudentWithAPI()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			int res = sqlSession.insert(namespace + "insertStudentWithAPI", student);
			sqlSession.commit();
			return res;
		}
	}
	
	public int createEnumStudentWithAPI(Student student) {
		log.debug("createEnumStudentWithAPI()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			int res = sqlSession.insert(namespace + "insertEnumStudentWithAPI", student);
			sqlSession.commit();
			return res;
		}
	}
	
	public int updateStudentWithAPI(Student student) {
		log.debug("updateStudentWithAPI()");
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			int res = sqlSession.update(namespace + "updateStudentWithAPI", student);
			sqlSession.commit();
			return res;
		} catch(Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw new RuntimeException(e.getCause());
		}finally {
			sqlSession.close();
		}
	}
	
	public int deleteStudentWithAPI(int id) {
		log.debug("deleteStudentWithAPI()");
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			int res = sqlSession.update(namespace + "deleteStudentWithAPI", id);
			sqlSession.commit();
			return res;
		} catch(Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw new RuntimeException(e.getCause());
		}finally {
			sqlSession.close();
		}
	}
	
	public List<Student> selectStudentByAllForResultMapWithAPI() {
		log.debug("selectStudentByAllForResultMapWithAPI()");
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			return sqlSession.selectList(namespace + "selectStudentByAllForResultMapWithAPI");
			
			
		} catch(Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw new RuntimeException(e.getCause());
		}finally {
			sqlSession.close();
		}
	}
	
	public List<Map<String, Object>> selectStudentByAllForHashMapWithAPI(){
		log.debug("selectStudentByAllForHashMapWithAPI()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			return studentDao.selectStudentByAllForHashMapWithAPI();
		}
	}
	public Student selectStudentByNoForResultMapExtendsWithAPI(Student student){
		log.debug("selectStudentByNoForResultMapExtendsWithAPI()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			return studentDao.selectStudentByNoForResultMapExtendsWithAPI(student);
		}
	}
	
	
	public Student selectStudentByNoAssociationWithAPI(Student student){
		log.debug("selectStudentByNoAssociationWithAPI()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			return studentDao.selectStudentByNoAssociationWithAPI(student);
		}
	}
	
	//여러개의 입력 파라미터
	
	public Student selectAllStudentByStudentWithAPI(Student student) {
		log.debug("selectAllStudentByStudentWithAPI()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + "selectStudentByStudentWithAPI", student);
		}
	}
	public Student selectAllStudentByMapWithAPI(Map<String, String> map) {
		log.debug("selectAllStudentByMapWithAPI()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + "selectStudentByMapWithAPI", map);
		}
	}
	
	public Map<Integer, String> selectStudentForMapWithAPI() {
		log.debug("selectStudentForMapWithAPI()");
		Map<Integer, String> map = new HashMap<>();
        ResultHandler<Student> resultHandler = new ResultHandler<Student>() {
            @Override
            public void handleResult(ResultContext<? extends Student> resultContext) {
                Student student = resultContext.getResultObject();
                map.put(student.getStudId(), student.getName());                
            }
        };

		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			sqlSession.select(namespace + "selectStudentForMapWithAPI", resultHandler);
			return map;
		}
	}
}
