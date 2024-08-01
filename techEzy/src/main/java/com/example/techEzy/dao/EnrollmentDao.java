package com.example.techEzy.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.techEzy.entity.EnrollmentEntity;
import com.example.techEzy.entity.StudentEntity;

public interface EnrollmentDao extends JpaRepository<EnrollmentEntity, Long>{

	List<EnrollmentEntity> findAllBySid(StudentEntity student);

}
