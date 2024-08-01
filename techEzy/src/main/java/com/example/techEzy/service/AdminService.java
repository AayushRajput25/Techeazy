package com.example.techEzy.service;

import com.example.techEzy.dto.AdminSignUpDto;
import com.example.techEzy.dto.EditAdminDto;

public interface AdminService {

	AdminSignUpDto adminRegister(AdminSignUpDto dto);

	EditAdminDto editById(Long id, EditAdminDto dto);

	 String deleteById(Long id); 

}
