package kr.or.dgit.mybatis_sample;

import static org.junit.Assert.fail;

import java.util.List;

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
	public void test() {
		RowBounds rowBounds = new RowBounds(0,3);
		List<Address> lists = service.findAddressByAll(rowBounds);
		Assert.assertNotNull(lists);
	}

}
