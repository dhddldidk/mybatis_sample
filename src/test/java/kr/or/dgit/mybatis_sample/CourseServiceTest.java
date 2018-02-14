package kr.or.dgit.mybatis_sample;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.dgit.mybatis_sample.dto.Course;
import kr.or.dgit.mybatis_sample.service.CourseService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CourseServiceTest {

	private static CourseService service;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service = new CourseService();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		service = null;
	}

	@Test
	public void test1FindCourseByCondition() {
		GregorianCalendar cal = new GregorianCalendar(2013, 1, 1);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tutorId", 1);
		map.put("name", "%java%");
		map.put("startDate", cal.getTime());

		List<Course> courses = service.selectCoursesByCondition(map);
		Assert.assertNotNull(courses);
	}

	@Test
	public void test2FindCaseCourses() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchBy", "Tutor");
		map.put("tutorId", 1);

		List<Course> courses = service.selectCaseCourses(map);
		Assert.assertNotNull(courses);
		System.out.println(courses);

		map.replace("searchBy", "name");
		map.remove("tutorId");
		map.put("name", "%java%");
		courses = service.selectCaseCourses(map);
		Assert.assertNotNull(courses);
		System.out.println(courses);
	}
	
	@Test
	public void test3FindWhereCourses() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Course> courses = service.selectWhereCourses(map);
		Assert.assertNotNull(courses);
		
		map.put("tutorId", 1);
		courses = service.selectWhereCourses(map);
		Assert.assertNotNull(courses);
		
		map.put("name", "%java%");
		courses = service.selectWhereCourses(map);
		
		map.clear();
		map.put("endDate", new Date());
		courses = service.selectWhereCourses(map);
	}
	
	@Test
	public void test4FindTrimCourses() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Course> courses = service.selectTrimCourses(map);
		Assert.assertNotNull(courses);
		
		map.put("tutorId", 1);
		courses = service.selectTrimCourses(map);
		Assert.assertNotNull(courses);
		
		//map.put("tutorId", 1);
		map.remove("tutorId");
		map.put("name", "%java%");
		courses = service.selectTrimCourses(map);
		Assert.assertNotNull(courses);
		
	}
	
	@Test
	public void test5FindCoursesForeachByTutors() {
		
		List<Integer> tutorIds = new ArrayList<Integer>();
		tutorIds.add(1);
		tutorIds.add(2);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tutorIds", tutorIds);
		
		List<Course> courses = service.selectCoursesForeachByTutors(map);
		Assert.assertNotNull(courses);
	
		
	}

}
