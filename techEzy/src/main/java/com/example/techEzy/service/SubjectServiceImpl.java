package com.example.techEzy.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.techEzy.dao.SubjectDao;
import com.example.techEzy.dto.StudentSignUp;
import com.example.techEzy.dto.SubjectDto;
import com.example.techEzy.entity.StudentEntity;
import com.example.techEzy.entity.SubjectEntity;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class SubjectServiceImpl implements SubjectService{

	@Autowired
	SubjectDao subjectDao;
	
	@Autowired
	ModelMapper mapper;
	
	@Override
	public SubjectDto newSubject(SubjectDto subject) {
		SubjectEntity s = mapper.map(subject, SubjectEntity.class);
		
		SubjectDto result = mapper.map(subjectDao.save(s), SubjectDto.class);
		return result;
	}

	@Override
	public List<SubjectDto> getAllSubject() {	
		List<SubjectEntity> subject = subjectDao.findAll();
		return mapper.map(subject, new TypeToken<List<SubjectDto>>(){}.getType() );
	}

	@Override
	public Object editById(Long id, SubjectDto dto) {
		if (subjectDao.existsById(id)) {
			SubjectEntity oldSubject = subjectDao.findById(id).orElseThrow();
			oldSubject.setName(dto.getName());
			return (mapper.map(subjectDao.save(oldSubject), SubjectDto.class));
		}
		else {
			return "Subject don't exist";
		}	
	}

	@Override
	public String deleteById(Long id) {
		if (subjectDao.existsById(id)) {
			subjectDao.deleteById(id);
			return "SuccessFull Deleted";
		}else {
			return "Subject Don't Exist";
		}
		
	}

	
	
	
}
