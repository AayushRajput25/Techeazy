package com.example.techEzy.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student")
public class StudentEntity extends BaseEntity{

	@Column(length = 50)
	String name;
	
	@Column(length = 50)
	String city;
	
	LocalDate dateOfBirth;
	
	@Column(length = 13)
	String phone;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	Gender gender;
	
	@OneToOne
	@JoinColumn(name = "student_id",nullable = false)
	@MapsId
	private UserEntity sId;

	@OneToMany(mappedBy = "sid",cascade = CascadeType.ALL)
	List<EnrollmentEntity> enrollment = new ArrayList();
	
	
}

