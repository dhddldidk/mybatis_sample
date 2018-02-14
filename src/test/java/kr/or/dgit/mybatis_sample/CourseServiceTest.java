package kr.or.dgit.mybatis_sample;

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
	public void testFindCourseByCondition() {
		GregorianCalendar cal = new GregorianCalendar(2013, 1, 1);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tutorId", 1);
		map.put("name", "%java%");
		map.put("startDate", cal.getTime());
		
		List<Course> courses = service.selectCoursesByCondition(map);
		Assert.assertNotNull(courses);
	}

}
