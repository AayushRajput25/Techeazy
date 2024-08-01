package com.example.techEzy.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.techEzy.entity.StudentEntity;

public interface StudentDao extends JpaRepository<StudentEntity, Long> {

	
}
