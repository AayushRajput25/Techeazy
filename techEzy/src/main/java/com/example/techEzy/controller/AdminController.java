package com.example.techEzy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.example.techEzy.dto.EditAdminDto;
import com.example.techEzy.dto.SubjectDto;
import com.example.techEzy.service.AdminService;
import com.example.techEzy.service.SubjectService;
import com.example.techEzy.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	SubjectService subjectService;
	@Autowired
	AdminService adminService;
	@Autowired
	UserService userService;
	
	@PostMapping("/addSubject")
	public ResponseEntity<?> postMethodName(@RequestBody SubjectDto subject) {
		
		System.out.println("subject = "+ subject);
		return ResponseEntity.status(HttpStatus.CREATED).body(subjectService.newSubject(subject));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editAdmin(@PathVariable Long id, @RequestBody EditAdminDto dto) {

		System.out.println("Editing admin id=" + id);
		return ResponseEntity.accepted().body(adminService.editById(id,dto));
	}
	
	@DeleteMapping("/{id}")
	private ResponseEntity<?> deleteingAdmin(@PathVariable Long id) {
		System.out.println("deleting admin id = "+id);
		return ResponseEntity.ok(adminService.deleteById(id));
	}
	
	@PutMapping("/editSubject/{id}")
	private ResponseEntity<?> editSubject(@PathVariable Long id, @RequestBody SubjectDto dto){
		System.out.println("editing subject id = "+id);
		return ResponseEntity.accepted().body(subjectService.editById(id,dto));
	}
	
	@DeleteMapping("/deleteSubject/{id}")
	private ResponseEntity<?> deleteSubject(@PathVariable Long id){
		System.out.println("deleting subject id = "+id);
		return ResponseEntity.ok(subjectService.deleteById(id));
	}
	
	@GetMapping("/student")
	public ResponseEntity<?> getAllStudents() {
		return ResponseEntity.ok(userService.getStudents());
	}
	
}
