package kr.or.dgit.mybatis_sample;

import java.sql.Connection;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.dgit.mybatis_sample.util.MyBatisSqlSessionFactory;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MyBatisSqlSessionFactoryTest {
	private static SqlSessionFactory factory;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		factory = MyBatisSqlSessionFactory.getSqlSessionFactory();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		factory = null;
	}

	@Test
	public void testFactory() {
		Assert.assertNotNull(factory);
	}
	
	@Test
	public void testSession() {
		Connection connection = factory.openSession().getConnection();
		Assert.assertNotNull(connection);
	}

}
