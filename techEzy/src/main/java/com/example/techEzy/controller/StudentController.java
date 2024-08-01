package com.example.techEzy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.techEzy.dto.EditAdminDto;
import com.example.techEzy.dto.EditStudentDto;
import com.example.techEzy.service.SubjectService;
import com.example.techEzy.service.UserService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	UserService userService;
	
	@Autowired
	SubjectService subjectService;
	
	@PostMapping("/enroll/{sid}/{subid}")
	public ResponseEntity<?> enrollInSubect(@PathVariable Long sid,@PathVariable Long subid) {
		System.out.println("student id = "+sid+"/ subject id ="+subid);
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.enroll(sid,subid));
	}
	
	
	@GetMapping("/subject")
	public ResponseEntity<?> getAllSubject(){
		return ResponseEntity.ok(subjectService.getAllSubject());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editStudent(@PathVariable Long id, @RequestBody EditStudentDto dto) {
		System.out.println("Edit Student id = "+id);
		
		return ResponseEntity.accepted().body(userService.editById(id,dto));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable Long id){
		System.out.println("deleting student id = "+id);
		return ResponseEntity.ok(userService.deleteById(id));
	}
	
	@GetMapping("/enroll/{sid}")
	public ResponseEntity<?> getSubjectEnrolled(@PathVariable Long sid) {
		System.out.println("Enrolled student id = "+sid);
		return ResponseEntity.ok(userService.getSubject(sid));	
	}
	
	@DeleteMapping("/enroll/{id}")
	public ResponseEntity<?> unenrollSubject(@PathVariable Long id) {
		System.out.println("unenrollment from id = "+id);
		return ResponseEntity.ok(userService.unerollById(id));
	}
	
}
