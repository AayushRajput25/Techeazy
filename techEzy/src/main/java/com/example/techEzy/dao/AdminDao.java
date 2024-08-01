package com.example.techEzy.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.techEzy.entity.AdminEntity;

public interface AdminDao extends JpaRepository<AdminEntity, Long>{

}
