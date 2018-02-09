package kr.or.dgit.mybatis_sample.dao;

import java.util.List;

import kr.or.dgit.mybatis_sample.dto.Student;

public interface StudentDao {
	// select
	Student selectStudentByNo(Student student);

	List<Student> selectStudentByAll();


	// insert
	int insertStudent(Student student);
}
