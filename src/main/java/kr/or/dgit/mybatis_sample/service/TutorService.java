package kr.or.dgit.mybatis_sample.service;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.mybatis_sample.dto.Student;
import kr.or.dgit.mybatis_sample.dto.Tutor;
import kr.or.dgit.mybatis_sample.util.MyBatisSqlSessionFactory;

public class TutorService {
	private static final Log log = LogFactory.getLog(TutorService.class);
	private String namespace = "kr.or.dgit.mybatis_sample.dao.TutorDao.";
	
	public Tutor selectTutorByTutorIdWithAPI(Tutor tutor) {
		log.debug("selectTutorByTutorIdWithAPI()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + "selectTutorByTutorIdWithAPI", tutor);
		}
	}
}
