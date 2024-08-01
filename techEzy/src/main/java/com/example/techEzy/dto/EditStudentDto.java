package com.example.techEzy.dto;

import java.time.LocalDate;

import com.example.techEzy.entity.Gender;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EditStudentDto {

	@JsonProperty(access = Access.READ_ONLY)
	private Long id;
	
	private String name;
	private LocalDate dateOfBirth;
	private String city;
	private String phone;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
}
