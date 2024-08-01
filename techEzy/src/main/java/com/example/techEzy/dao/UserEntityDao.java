package com.example.techEzy.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.techEzy.entity.UserEntity;

public interface UserEntityDao extends JpaRepository<UserEntity, Long>{

	Optional<UserEntity> findByEmail(String email);
}
