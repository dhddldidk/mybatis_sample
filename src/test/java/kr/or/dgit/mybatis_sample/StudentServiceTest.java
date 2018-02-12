package kr.or.dgit.mybatis_sample;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.dgit.mybatis_sample.dto.PhoneNumber;
import kr.or.dgit.mybatis_sample.dto.Student;
import kr.or.dgit.mybatis_sample.service.StudentService;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentServiceTest {
	private static StudentService service;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service = new StudentService();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		service = null;
	}

	@Test
	public void test1FindStudentByNoWithAPI() {
		Student student = service.findStudentByNoWithAPI(new Student(1));
		Assert.assertNotNull(student);
	}

	@Test
	public void test2FindStudentByAllWithAPI() {
		List<Student> listStd = service.findStudentByAllWithAPI();
		Assert.assertNotNull(listStd);
		for(Student std : listStd) {
			System.out.println(std);
		}
	}
	
	@Test
	public void test3CreateStudentWithAPI() {
		Calendar newDate = GregorianCalendar.getInstance();
        newDate.set(1990, 2, 28);

        Student student = new Student(5, "홍길동5", "lee@test.co.kr", new PhoneNumber("010-1234-1234"), newDate.getTime());
        int res = service.createStudentWithAPI(student);
        Assert.assertEquals(1, res);
	}
	
	@Test
	public void test4UpdateStudentWithAPI() {
		Student student = new Student();
		student.setStudId(1);
		student.setName("Timothy");
		student.setEmail("test@test.co.kr");
		student.setPhone(new PhoneNumber("987-654-3211"));
		student.setDob(new Date());
		
		int res = service.updateStudentWithAPI(student);
		Assert.assertSame(1, res);
	}
	
	@Test
	public void test5DeleteStudentWithAPI() {
		
		int res = service.deleteStudentWithAPI(5);
		Assert.assertSame(1, res);
	}
	
	@Test
	public void test6SelectStudentByAllForResultMapWithAPI() {
		List<Student> lists = service.findStudentByAllWithAPI();
		List<Student> listsAPI = service.selectStudentByAllForResultMapWithAPI();
		Assert.assertSame(lists.size(), listsAPI.size());
		
	}
	
	@Test
	public void test7SelectStudentByNoForResultMapExtendsWithAPI() {
		Student student = new Student();
		student.setStudId(1);
		
		Student extStdApi = service.selectStudentByNoForResultMapExtendsWithAPI(student);
		
		Assert.assertEquals(1, extStdApi.getStudId());
		
	}
	
	@Test
	public void test8SelectStudentByNoAssociationWithAPI() {
		Student student = new Student();
		student.setStudId(1);
		
		Student extStdd = service.selectStudentByNoAssociationWithAPI(student);
		
		Assert.assertEquals(1, extStdd.getStudId());
		System.out.println(extStdd);
	}
}
