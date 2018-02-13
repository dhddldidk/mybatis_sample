package kr.or.dgit.mybatis_sample.service;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.mybatis_sample.dao.TutorDao;
import kr.or.dgit.mybatis_sample.dto.Tutor;
import kr.or.dgit.mybatis_sample.util.MyBatisSqlSessionFactory;

public class TutorService {
	private static final Log log = LogFactory.getLog(TutorService.class);
	
	public Tutor findTutorByTutorId(Tutor tutor) {
		log.debug("findTutorByTutorId()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			TutorDao tutorDao = sqlSession.getMapper(TutorDao.class);
			return tutorDao.selectTutorByTutorId(tutor);
		}
	}
}
