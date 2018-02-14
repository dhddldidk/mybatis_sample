package kr.or.dgit.mybatis_sample;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.dgit.mybatis_sample.dto.Address;
import kr.or.dgit.mybatis_sample.service.AddressService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AddressServiceTest {
	private static AddressService service;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service = new AddressService();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		service = null;
	}

	@Test
	public void test1SelectAddressByAllWithAPI() {
		RowBounds rowBounds = new RowBounds(0,3);
		List<Address> lists = service.findAddressByAllWithAPI(rowBounds);
		System.out.println(lists.size());
		Assert.assertNotNull(lists);
	}
	
	@Test
	public void test2SelectAddressByAllWithAPI() {
		RowBounds rowBounds = new RowBounds(3,3);
		List<Address> lists = service.findAddressByAllWithAPI(rowBounds);
		System.out.println(lists.size());
		Assert.assertNotNull(lists);
	}


	@Test
	public void test3SelectAddressLimitByAllWithAPI() {
        Map<String, Integer> map = new HashMap<>();
        map.put("offset", 0);
        map.put("limit", 3);
        List<Address> lists = service.selectAddressLimitByAllWithAPI(map);
        System.out.println(lists.size());
        Assert.assertNotNull(lists);
	}
	
	@Test
	public void test4SelectAddressLimitByAllWithAPI() {
        Map<String, Integer> map = new HashMap<>();
        map.put("offset", 3);
        map.put("limit", 3);
        List<Address> lists = service.selectAddressLimitByAllWithAPI(map);
        System.out.println(lists.size());
        Assert.assertNotNull(lists);
	}
}