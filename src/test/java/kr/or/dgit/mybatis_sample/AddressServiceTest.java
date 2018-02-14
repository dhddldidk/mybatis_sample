package kr.or.dgit.mybatis_sample;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.mybatis_sample.dto.Address;
import kr.or.dgit.mybatis_sample.service.AddressService;

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
	public void test1SelectAddressByAll() {
		RowBounds rowBounds = new RowBounds(0,3);
		List<Address> lists = service.findAddressByAll(rowBounds);
		Assert.assertNotNull(lists);
	}
	
	@Test
	public void test2SelectAddressByAll() {
		RowBounds rowBounds = new RowBounds(2, 3);
        List<Address> lists = service.findAddressByAll(rowBounds);
        System.out.println(lists.size());
        Assert.assertNotNull(lists);
	}

	@Test
	public void test3SelectAddressLimitByAll() {
		Map<String, Integer> map = new HashMap<>();
		map.put("offset", 0);
		map.put("limit", 3);
        List<Address> lists = service.selectAddressLimitByAll(map);
        System.out.println(lists.size());
        Assert.assertNotNull(lists);

	}
	
	@Test
	public void test4SelectAddressLimitByAll() {
		Map<String, Integer> map = new HashMap<>();
		map.put("offset", 3);
		map.put("limit", 3);
        List<Address> lists = service.selectAddressLimitByAll(map);
        System.out.println(lists.size());
        Assert.assertNotNull(lists);
	}
}
