package kr.or.dgit.mybatis_sample.dao;

import java.util.List;

import kr.or.dgit.mybatis_sample.dto.Student;

public interface StudentDao {
	// select
	Student selectStudentByNo(Student student);

	List<Student> selectStudentByAll();

	List<Student> selectStudentByAllForResultMap();

	//resultMap Extends
	Student selectStudentByForResultMapExtends(Student student);
	// insert
	int insertStudent(Student student);
	
	// update
	int updateStudent(Student student);
	
	//delete
	int deleteStudent(int id);
}
