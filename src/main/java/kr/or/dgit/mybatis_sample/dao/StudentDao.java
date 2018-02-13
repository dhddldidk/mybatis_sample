package kr.or.dgit.mybatis_sample.dao;

import java.util.List;
import java.util.Map;

import kr.or.dgit.mybatis_sample.dto.Student;

public interface StudentDao {
	// select
	Student selectStudentByNoWithAPI(Student student);
	List<Student> selectStudentByAllWithAPI();
	List<Student> selectStudentByAllForResultMapWithAPI();
	List<Map<String, Object>> selectStudentByAllForHashMapWithAPI();
	
	Student selectStudentByNoForResultMapExtendsWithAPI(Student student);
	Student selectStudentByNoAssociationWithAPI(Student student);
	// insert
	int insertStudentWithAPI(Student student);
	int insertEnumStudentWithAPI(Student student);
	// update
	int updateStudentWithAPI(Student student);
	
	//delete
	int deleteStudentWithAPI(int id);
}
