package com.example.techEzy.service;

import java.util.List;

import com.example.techEzy.dto.SubjectDto;

public interface SubjectService {

	SubjectDto newSubject(SubjectDto subject);

	List<SubjectDto> getAllSubject();

	Object editById(Long id, SubjectDto dto);

	String deleteById(Long id);

}
