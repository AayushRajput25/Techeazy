package com.example.techEzy.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;

import com.example.techEzy.entity.Gender;
import com.example.techEzy.entity.UserRole;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdminSignUpDto {

	@JsonProperty(access = Access.READ_ONLY) // this property only used during ser.
	private Long id;
//	@NotBlank(message = "Name required")
	private String name;

	private LocalDate dateOfBirth;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private Gender gender;
	
	@Column(length = 15)
	private String phone;
	
//	@Email(message = "Invalid Email!!!")
	private String email;
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	
	@JsonProperty(access = Access.READ_ONLY)
	@Enumerated(EnumType.STRING)
	@Column(length = 30)
	private UserRole role = UserRole.ROLE_Admin;
	
	@Column(length = 50)
	private String city;
	
}
