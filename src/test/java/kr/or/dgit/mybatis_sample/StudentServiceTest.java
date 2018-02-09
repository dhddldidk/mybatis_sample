package kr.or.dgit.mybatis_sample;

import java.util.Calendar;
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
	public void test1FindStudentByNo() {
		Student student = service.findStudentByNo(new Student(1));
		Assert.assertNotNull(student);
	}

	@Test
	public void test2selectStudentByAll() {
		List<Student> listStd = service.findStudentByAll();
		Assert.assertNotNull(listStd);
		for(Student std : listStd) {
			System.out.println(std);
		}
			
	}
	
	@Test
	public void test3FindStudentByNoWithAPI() {
		Student student = service.findStudentByNoWithAPI(new Student(1));
		Assert.assertNotNull(student);
	}

	@Test
	public void test4selectStudentByAllWithAPI() {
		List<Student> listStd = service.findStudentByAllWithAPI();
		Assert.assertNotNull(listStd);
		for(Student std : listStd) {
			System.out.println(std);
		}
	}
	
	@Test
	public void test5CreateStudent() {
		Calendar newDate = GregorianCalendar.getInstance();
		newDate.set(1990, 2,28);
		
		Student student = new Student(5, "홍길동5", "lee@test.co.kr", new PhoneNumber("010-1234-1234"),newDate.getTime());
		int res = service.insertStudent(student);
		Assert.assertEquals(1, res);
	}
	
	@Test
	public void test6CreateStudentWithAPI() {
		Calendar newDate = GregorianCalendar.getInstance();
		newDate.set(1990, 2,28);
		
		Student student = new Student(6, "홍길동6", "lee@test.co.kr", new PhoneNumber("010-5678-5678"),newDate.getTime());
		int res = service.insertStudentWithAPI(student);
		Assert.assertEquals(1, res);
	}
}
