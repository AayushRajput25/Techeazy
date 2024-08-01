package com.example.techEzy.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.techEzy.dao.AdminDao;
import com.example.techEzy.dao.UserEntityDao;
import com.example.techEzy.dto.AdminSignUpDto;
import com.example.techEzy.dto.EditAdminDto;
import com.example.techEzy.entity.AdminEntity;
import com.example.techEzy.entity.UserEntity;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminDao adminDao;
	@Autowired
	private UserEntityDao userDao;
	@Autowired
	private PasswordEncoder encoder;
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public AdminSignUpDto adminRegister(AdminSignUpDto dto) {
		AdminEntity admin = mapper.map(dto, AdminEntity.class);
		UserEntity user = mapper.map(dto, UserEntity.class);
		user.setPassword(encoder.encode(user.getPassword()));
		AdminSignUpDto res = mapper.map(userDao.save(user), AdminSignUpDto.class);
		admin.setAId(user);
		res = mapper.map(adminDao.save(admin),AdminSignUpDto.class );
		return res;
	}

	@Override
	public EditAdminDto editById(Long id, EditAdminDto dto) {
		AdminEntity oldAdmin = adminDao.findById(id).orElseThrow();
		oldAdmin = mapper.map(dto, AdminEntity.class); 
		oldAdmin.setId(id);
		
		return mapper.map(adminDao.save(oldAdmin), EditAdminDto.class);
	}

	@Override
	public String deleteById(Long id) {
		if (adminDao.existsById(id)) {
			adminDao.deleteById(id);
			userDao.deleteById(id);
			return "deleted Successfully";
		}else {
			return "Admin Not exist";
		}
		
	}
	
	

}
