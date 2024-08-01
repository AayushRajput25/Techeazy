package com.example.techEzy.service;

import java.util.List;

import org.springframework.http.ProblemDetail;

import com.example.techEzy.dto.EditStudentDto;
import com.example.techEzy.dto.EnrolledSubjectDto;
import com.example.techEzy.dto.StudentSignUp;
import com.example.techEzy.dto.SubjectDto;
import com.example.techEzy.entity.EnrollmentEntity;

public interface UserService {

	Object studentRegistration(StudentSignUp dto);

	String enroll(Long sid, Long subid);

	List<StudentSignUp> getStudents();

	EditStudentDto editById(Long id, EditStudentDto dto);

	String deleteById(Long id);

	List<EnrolledSubjectDto> getSubject(Long id);

	String unerollById(Long id);

}
