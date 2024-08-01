package com.example.techEzy.service;

import java.util.*;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.techEzy.dao.EnrollmentDao;
import com.example.techEzy.dao.StudentDao;
import com.example.techEzy.dao.SubjectDao;
import com.example.techEzy.dao.UserEntityDao;
import com.example.techEzy.dto.EditAdminDto;
import com.example.techEzy.dto.EditStudentDto;
import com.example.techEzy.dto.EnrolledSubjectDto;
import com.example.techEzy.dto.StudentSignUp;
import com.example.techEzy.dto.SubjectDto;
import com.example.techEzy.entity.AdminEntity;
import com.example.techEzy.entity.EnrollmentEntity;
import com.example.techEzy.entity.StudentEntity;
import com.example.techEzy.entity.SubjectEntity;
import com.example.techEzy.entity.UserEntity;



@Service
@Transactional
public class UserServiceImpl implements UserService {
	//dep : dao layer i/f
	@Autowired
	private UserEntityDao userDao;
	//dep
	@Autowired
	private ModelMapper mapper;
	//dep 
	@Autowired
	private PasswordEncoder encoder;
	@Autowired
	private StudentDao studentDao;
	@Autowired
	private SubjectDao subjectDao;
	@Autowired
	private EnrollmentDao enrollmentDao;

	@Override
	public StudentSignUp studentRegistration(StudentSignUp reqDTO) {
		//dto --> entity
		StudentEntity student=mapper.map(reqDTO, StudentEntity.class);
//		Students student = new Students(reqDTO.getName(), reqDTO.getAge(), reqDTO.getGender(), reqDTO.getPhoneNo(), reqDTO.getAddress(), null, null, null);
		UserEntity user = mapper.map(reqDTO, UserEntity.class);
		
		user.setPassword(encoder.encode(user.getPassword()));//pwd : encrypted using SHA
		StudentSignUp reg = mapper.map(userDao.save(user), StudentSignUp.class) ;
		student.setSId(user);
		reg = mapper.map(studentDao.save(student), StudentSignUp.class) ;
		return reg;
	}


	@Override
	public String enroll(Long sid, Long subid) {
		
		StudentEntity student = studentDao.getById(sid); 
		SubjectEntity subject = subjectDao.getById(subid);
		
		if (student != null && subject != null) {
			EnrollmentEntity enrollment = new EnrollmentEntity(student,subject);
			enrollmentDao.save(enrollment);
			return "Succeccfull Enrolled";
		}
		else
			return "Enrollment Failed";
	}


	@Override
	public List<StudentSignUp>  getStudents() {	
		List<StudentEntity> student = studentDao.findAll();
		return mapper.map(student,new TypeToken<List<StudentSignUp>>(){}.getType());
	}


	@Override
	public EditStudentDto editById(Long id, EditStudentDto dto) {
		StudentEntity oldStudent = studentDao.findById(id).orElseThrow();
		oldStudent = mapper.map(dto, StudentEntity.class); 
		oldStudent.setId(id);
		
		return mapper.map(studentDao.save(oldStudent), EditStudentDto.class);
	}


	@Override
	public String deleteById(Long id) {
		if (studentDao.existsById(id)) {
			studentDao.deleteById(id);
			userDao.deleteById(id);
			return "deleted Successfully";
		}else {
			return "Student Not exist";
		}
	}


	@Override
	public List<EnrolledSubjectDto> getSubject(Long id) {
		StudentEntity student = studentDao.findById(id).orElseThrow();
		List<EnrollmentEntity>  enrollment = enrollmentDao.findAllBySid(student);
		List<EnrolledSubjectDto> res = new ArrayList<>();
		for (EnrollmentEntity e : enrollment) {
			EnrolledSubjectDto en = new EnrolledSubjectDto();
			en.setId(e.getId());
			en.setName(e.getSubId().getName());
			System.out.println(en.toString());
			res.add(en);
		}
		
		return res;
	}


	@Override
	public String unerollById(Long id) {
		if (enrollmentDao.existsById(id)) {
			enrollmentDao.deleteById(id);
			return "Successfull Unenrolled";
		}
		else {
			return "Enrollment Don't Exist";
		}
		
	}

	

}
