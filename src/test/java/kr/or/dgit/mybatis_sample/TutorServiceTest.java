package kr.or.dgit.mybatis_sample;


import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.dgit.mybatis_sample.dto.Tutor;
import kr.or.dgit.mybatis_sample.service.TutorService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TutorServiceTest {

	private static TutorService service;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service = new TutorService();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		service = null;
	}

	@Test
	public void test1FindStudent() {
		Tutor findTutor = new Tutor();
		findTutor.setTutorId(1);
		Tutor tutor = service.findTutorByTutorId(findTutor);
		Assert.assertSame(findTutor.getTutorId(), tutor.getTutorId());
		System.out.println(tutor);
	}

}
