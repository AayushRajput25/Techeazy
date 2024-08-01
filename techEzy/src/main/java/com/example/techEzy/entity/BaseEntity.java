package com.example.techEzy.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@MappedSuperclass // to tell hib , not to create any tables n other entities will extend from it
@Getter
@Setter
public class BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty(access = Access.READ_ONLY)
	private Long id;
	
}
