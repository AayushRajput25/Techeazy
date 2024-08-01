package com.example.techEzy.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "enrollment")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentEntity extends BaseEntity {
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "studentid",nullable = false)
	StudentEntity sid;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subjectid",nullable = false)
	SubjectEntity subId;
	
}
