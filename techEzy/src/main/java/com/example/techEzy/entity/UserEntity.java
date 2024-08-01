package com.example.techEzy.entity;

import jakarta.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "secure_users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = "password") // toString excluding password
public class UserEntity extends BaseEntity {

	@Column(length = 30, unique = true)
	private String email;
	@Column(length = 300, nullable = false)
	private String password;
	@Enumerated(EnumType.STRING)
	@Column(length = 30)
	private UserRole role;



}
