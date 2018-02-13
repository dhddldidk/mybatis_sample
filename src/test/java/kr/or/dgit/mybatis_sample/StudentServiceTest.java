package kr.or.dgit.mybatis_sample;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.ibatis.ognl.OgnlRuntime.ArgsCompatbilityReport;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.dgit.mybatis_sample.dto.PhoneNumber;
import kr.or.dgit.mybatis_sample.dto.Student;
import kr.or.dgit.mybatis_sample.service.StudentService;
import kr.or.dgit.mybatis_sample.type.Gender;

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
	public void test2FindStudentByAll() {
		List<Student> listStd = service.findStudentByAll();
		Assert.assertNotNull(listStd);
		for (Student std : listStd) {
			System.out.println(std);
		}
	}

	@Test
	public void test3CreateStudent() {
		Calendar newDate = GregorianCalendar.getInstance();
		newDate.set(1990, 2, 28);

		Student student = new Student(3, "홍길동3", "lee@test.co.kr", new PhoneNumber("010-1234-1234"), newDate.getTime());
		int res = service.createStudent(student);
		// sql쿼리대로 문장이 잘 수행되면 1을 반환해서 res에 담아서
		// Assert.assertEquals(1, res);에서 equals에 1과 같으면
		// 성공 아니면 에러가 뜸
		Assert.assertEquals(1, res);
	}

	@Test
	public void test4UpdateStudent() {

		Student student = new Student();
		student.setStudId(1);
		student.setName("Timothy");
		student.setEmail("test@test.co.kr");
		student.setPhone(new PhoneNumber("987-654-3211"));
		student.setDob(new Date());

		int res = service.updateStudent(student);
		// 안에있는 데이터베이스를 찾으려면 assertsame
		Assert.assertSame(1, res);

		student.setEmail("timothy@gmail.com");
		student.setPhone(new PhoneNumber("123-456-7890"));
		student.setDob(new GregorianCalendar(1988, 04, 25).getTime());
		res = service.updateStudent(student);
		// 안에있는 데이터베이스를 찾으려면 assertsame
		Assert.assertSame(1, res);
	}

	@Test
	public void test5DeleteStudent() {
		int deleteStudent = service.deleteStudent(3);
		Assert.assertSame(1, deleteStudent);

	}

	@Test
	public void test6SelectStudentByAllForResultMap() {
		List<Student> lists = service.selectStudentByAllForResultMap();
		List<Student> listStd2 = service.findStudentByAll();

		Assert.assertSame(lists.size(), listStd2.size());
	}

	@Test
	public void test7SelectStudentByAllForHashMap() {
		List<Map<String, Object>> listMaps = service.selectStudentByAllForHashMap();
		List<Student> lists2 = service.findStudentByAll();

		Assert.assertSame(listMaps.size(), lists2.size());

		for (Map<String, Object> map : listMaps) {
			for (Entry<String, Object> e : map.entrySet()) {
				System.out.printf("key %s => value %s %n", e.getKey(), e.getValue());
			}
		}
	}

	@Test
	public void test8selectStudentByForResultMapExtends() {
		Student student = new Student();
		student.setStudId(1);

		Student extStd = service.selectStudentByForResultMapExtends(student);

		Assert.assertEquals(1, extStd.getStudId());
	}

	@Test
	public void test9SelectStudentByNoAssociation() {
		Student student = new Student();
		student.setStudId(1);

		Student extStdd = service.selectStudentByNoAssociation(student);

		Assert.assertEquals(1, extStdd.getStudId());
		System.out.println(extStdd);
	}

	@Test
	public void testFCreateEnumStudent() {
		Calendar newDate = GregorianCalendar.getInstance();
		newDate.set(1990, 2, 28);

		Student student = new Student(3, "홍길동3", "lee@test.co.kr", new PhoneNumber("010-1234-1234"), newDate.getTime());
		student.setGender(Gender.FEMALE);
		int res = service.createEnumStudent(student);
		// sql쿼리대로 문장이 잘 수행되면 1을 반환해서 res에 담아서
		// Assert.assertEquals(1, res);에서 equals에 1과 같으면
		// 성공 아니면 에러가 뜸
		Assert.assertEquals(1, res);
		System.out.println(student);
		
		test5DeleteStudent();
	}

}
