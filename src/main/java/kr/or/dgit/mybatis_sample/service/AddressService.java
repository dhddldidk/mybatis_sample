package kr.or.dgit.mybatis_sample.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.mybatis_sample.dao.AddressDao;
import kr.or.dgit.mybatis_sample.dto.Address;
import kr.or.dgit.mybatis_sample.util.MyBatisSqlSessionFactory;

public class AddressService {
	private static final Log log = LogFactory.getLog(TutorService.class);
	
	public List<Address> findAddressByAll(RowBounds rowBounds){
		log.debug("findAddressByAll()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			AddressDao addressDao = sqlSession.getMapper(AddressDao.class);
			return addressDao.selectAddressByAll(rowBounds);
		}
		
	}
	
	public List<Address> selectAddressLimitByAll(Map<String, Integer> map) {
		log.debug("selectAddressLimitByAll()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			AddressDao addressDao = sqlSession.getMapper(AddressDao.class);
			return addressDao.selectAddressLimitByAll(map);
		}
	}
}
