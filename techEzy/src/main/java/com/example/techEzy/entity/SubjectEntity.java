package com.example.techEzy.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "subject")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubjectEntity extends BaseEntity {
	
	@Column(length = 50)
	String name;
	
	@OneToMany(mappedBy = "subId",cascade = CascadeType.ALL)
	List<EnrollmentEntity> enrollment = new ArrayList<>();
	
	// helper for enrollment
	public void addEnrollment(EnrollmentEntity e) {
		this.enrollment.add(e);
		e.setSubId(this);
	}
	
	// helper to unenroll
	public void removeEnrollment(EnrollmentEntity e) {
		this.enrollment.remove(e);
		e.setSubId(null);
	}

}
