package com.example.techEzy.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.techEzy.dto.AdminSignUpDto;
import com.example.techEzy.dto.SigninRequest;
import com.example.techEzy.dto.SigninResponse;
import com.example.techEzy.dto.StudentSignUp;
import com.example.techEzy.security.JwtUtils;
import com.example.techEzy.service.AdminService;
import com.example.techEzy.service.UserService;

@RestController
@RequestMapping("/user")
public class UserSignInSignUpController {

	@Autowired
	private UserService userService;
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private JwtUtils utils;

	@Autowired
	private AuthenticationManager mgr;

	// sign up
	@PostMapping(value = "/student_signup")
	public ResponseEntity<?> StudentSignup(@RequestBody StudentSignUp dto) {
		System.out.println("in sign up " + dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.studentRegistration(dto));
	}
	
	@PostMapping(value = "/admin_signup")
	private ResponseEntity<?> adminSignup(@RequestBody AdminSignUpDto dto) {
		System.out.println("in admin signup "+ dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(adminService.adminRegister(dto));
	}
	
	@PostMapping("/signin")
	public ResponseEntity<?> signinUser(@RequestBody SigninRequest reqDTO) {
		System.out.println("in signin " + reqDTO);
		// simply invoke authentucate(...) on AuthMgr
		// i/p : Authentication => un verifed credentials
		// i/f --> Authentication --> imple by UsernamePasswordAuthToken
		// throws exc OR rets : verified credentials (UserDetails i.pl class: custom
		// user details)
		try {
			Authentication verifiedAuth = mgr
					.authenticate(new UsernamePasswordAuthenticationToken(reqDTO.getEmail(), reqDTO.getPassword()));
			System.out.println(verifiedAuth.getClass());// Custom user details
			// => auth success

			return ResponseEntity
					.ok(new SigninResponse(utils.generateJwtToken(verifiedAuth), "Successful Authentication!!"));
		} catch (Exception e) {
			SigninResponse err = new SigninResponse("","Inavalid credentials!!");
			return ResponseEntity.ok(err);
		}
	}
}
