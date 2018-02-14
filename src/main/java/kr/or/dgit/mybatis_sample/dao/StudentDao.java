package kr.or.dgit.mybatis_sample.dao;

import java.util.List;
import java.util.Map;

import kr.or.dgit.mybatis_sample.dto.Student;

public interface StudentDao {
	// select
	Student selectStudentByNo(Student student);

	List<Student> selectStudentByAll();

	List<Student> selectStudentByAllForResultMap();

	List<Map<String, Object>> selectStudentByAllForHashMap();

	// resultMap Extends
	Student selectStudentByForResultMapExtends(Student student);

	Student selectStudentByNoAssociation(Student student);

	// insert
	int insertStudent(Student student);
	int insertEnumStudent(Student student);

	// update
	int updateStudent(Student student);

	// delete
	int deleteStudent(int id);
	
	//여러개의 입력 파라미터 전달
	Student selectAllStudentByParam(String name, String email);
	Student selectAllStudentByStudent(Student student);
	Student selectAllStudentByMap(Map<String, String> map);
	
	// ResultSet 처리방식의 재정의
    Map<String, Object> selectStudentForMap(Student student);
}
