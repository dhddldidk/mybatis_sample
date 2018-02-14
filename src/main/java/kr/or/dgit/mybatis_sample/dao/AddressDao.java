package kr.or.dgit.mybatis_sample.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import kr.or.dgit.mybatis_sample.dto.Address;

public interface AddressDao {
	List<Address> selectAddressByAll(RowBounds rowBounds);
	List<Address> selectAddressLimitByAll(Map<String, Integer> map);
}
