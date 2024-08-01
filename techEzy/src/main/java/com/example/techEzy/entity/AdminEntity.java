package com.example.techEzy.entity;

import java.time.LocalDate;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "admin")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class AdminEntity extends BaseEntity{

	@Column(length = 50)
	String name;
	
	@Column(length = 50)
	String city;
	
	LocalDate dateOfBirth;
	
	@Column(length = 13)
	String Phone;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	Gender gender;
	
	@OneToOne
	@JoinColumn(name = "admin_id",nullable = false)
	@MapsId
	private UserEntity aId;
}
