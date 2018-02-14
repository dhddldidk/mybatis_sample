package kr.or.dgit.mybatis_sample;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
	public void test1FindStudentByNoWithAPI() {
		Student student = service.findStudentByNoWithAPI(new Student(1));
		Assert.assertNotNull(student);
	}

	@Test
	public void test2FindStudentByAllWithAPI() {
		List<Student> listStd = service.findStudentByAllWithAPI();
		Assert.assertNotNull(listStd);
		for (Student std : listStd) {
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
		
		student.setEmail("timothy@gmail.com");
        student.setPhone(new PhoneNumber("123-123-1234"));
        student.setDob(new GregorianCalendar(1988, 04, 25).getTime());
        res = service.updateStudentWithAPI(student);
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
	public void test7SelectStudentByAllForHashMapWithAPI() {
		List<Map<String, Object>> listMaps = service.selectStudentByAllForHashMapWithAPI();
		List<Student> lists2 = service.findStudentByAllWithAPI();

		Assert.assertSame(listMaps.size(), lists2.size());

		for (Map<String, Object> map : listMaps) {
			for (Entry<String, Object> e : map.entrySet()) {
				System.out.printf("key %s => value %s %n", e.getKey(), e.getValue());
			}
		}
	}

	@Test
	public void test8SelectStudentByNoForResultMapExtendsWithAPI() {
		Student student = new Student();
		student.setStudId(1);

		Student extStdApi = service.selectStudentByNoForResultMapExtendsWithAPI(student);
		
		Assert.assertEquals(1, extStdApi.getStudId());

		//이 문장과 같음
		//Student searchStd = service.selectStudentByNoForResultMapExtendsWithAPI(new Student(1));
		//Assert.assertNotNull(searchStd);
	}

	@Test
	public void test9SelectStudentByNoAssociationWithAPI() {
		Student student = new Student();
		student.setStudId(1);

		Student extStdd = service.selectStudentByNoAssociationWithAPI(student);

		Assert.assertEquals(1, extStdd.getStudId());
		System.out.println(extStdd);
		
		//이 문장과 같음
		//Student searchStd = service.selectStudentByNoAssociationWithAPI(new Student(1));
		//Assert.assertNotNull(searchStd);
	}

	@Test
	public void testFCreateEnumStudentWithAPI() {
		Calendar newDate = GregorianCalendar.getInstance();
		newDate.set(1990, 2, 28);

		Student student = new Student(5, "홍길동5", "lee@test.co.kr", new PhoneNumber("010-1234-1234"), newDate.getTime());
		student.setGender(Gender.FEMALE);
		int res = service.createEnumStudentWithAPI(student);
		Assert.assertEquals(1, res);
		System.out.println(student);

		test5DeleteStudentWithAPI();
	}

	
	@Test
	public void testTBFindAllStudentByStudentWithAPI() {
		Student std = new Student();
		std.setName("Timothy");
		std.setEmail("timothy@gmail.com");
		Student student = service.selectAllStudentByStudentWithAPI(std);
		Assert.assertNotNull(student);
	}

	@Test
	public void testTCFindAllStudentByMapWithAPI() {
		Map<String, String> maps = new HashMap<>();
		maps.put("name", "Timothy");
		maps.put("email", "timothy@gmail.com");
		Student student = service.selectAllStudentByMapWithAPI(maps);
		Assert.assertNotNull(student);
	}

	 @Test
	    public void testISelectStudentForMapWithAPI() {
	        Map<Integer, String> map = service.selectStudentForMapWithAPI();
	        Assert.assertNotNull(map);
	        for(Entry<Integer, String>entry : map.entrySet()){
	            System.out.printf("key(%s) - value(%s)%n", entry.getKey(), entry.getValue());
	        }
	    }
}
