package kr.or.dgit.mybatis_sample.service;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.mybatis_sample.dto.UserPic;
import kr.or.dgit.mybatis_sample.util.MyBatisSqlSessionFactory;

public class UserPicService {
	private static final Log log = LogFactory.getLog(UserPicService.class);
	private String namespace = "kr.or.dgit.mybatis_sample.dao.UserPicDao.";
	
	public int insertUserPicWithAPI(UserPic userPic) {
		int res = -1;
		log.debug("insertUserPicWithAPI()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			
			/*db에 가서 찾은 문장이 mapper에 있는 형식에 맞게 수행이 되면  1을 반환, 아니면 -1
			그래서 test에서 Assert.assertSame(1, result) 여기에서 1과 내가 
			반환받은 result의 값을 비교해서 같으면 성공!!!*/
			res = sqlSession.insert(namespace + "insertUserPicWithAPI", userPic);
			sqlSession.commit();
			return res;
		}
	}
	
	public UserPic getUserPicWithAPI(UserPic userPic) {
		log.debug("getUserPicWithAPI()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			UserPic user = sqlSession.selectOne(namespace+"getUserPicWithAPI",userPic);
			
			return user;
		}

	}
}
