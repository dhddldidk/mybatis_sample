package kr.or.dgit.mybatis_sample.dao;

import java.util.List;

import kr.or.dgit.mybatis_sample.dto.Student;

public interface StudentDao {
	// select
	Student selectStudentByNo(Student student);

	List<Student> selectStudentByAll();

	Student selectStudentByNoWithAPI(Student student);

	List<Student> selectStudentByAllWithAPI();

	// insert
	int insertStudent(Student student);

	int insertStudentWithAPI(Student student);
}
