package kr.or.dgit.mybatis_sample.service;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.mybatis_sample.dao.StudentDao;
import kr.or.dgit.mybatis_sample.dao.UserPicDao;
import kr.or.dgit.mybatis_sample.dto.UserPic;
import kr.or.dgit.mybatis_sample.util.MyBatisSqlSessionFactory;

public class UserPicService {
	private static final Log log = LogFactory.getLog(TutorService.class);
	
	public int insertUserPic(UserPic userPic) {
		log.debug("insertUserPic()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			UserPicDao userPicDao = sqlSession.getMapper(UserPicDao.class);
			int res = userPicDao.insertUserPic(userPic);
			sqlSession.commit();
			return res;
		}

	}
	
	public UserPic getUserPic(int id) {
		log.debug("getUserPic()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			UserPicDao userPicDao = sqlSession.getMapper(UserPicDao.class);
			
			return userPicDao.getUserPic(id);
		}

	}
}
