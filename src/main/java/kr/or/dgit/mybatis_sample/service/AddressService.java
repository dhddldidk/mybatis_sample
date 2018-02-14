package kr.or.dgit.mybatis_sample.service;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.mybatis_sample.dto.Address;
import kr.or.dgit.mybatis_sample.util.MyBatisSqlSessionFactory;

public class AddressService {
	private static final Log log = LogFactory.getLog(TutorService.class);
	private String namespace = "kr.or.dgit.mybatis_sample.dao.AddressDao.";
	public List<Address> findAddressByAllWithAPI(RowBounds rowBounds){
		log.debug("findAddressByAllWithAPI()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + "selectAddressByAllWithAPI", null, rowBounds);
		}
		
	}
}
