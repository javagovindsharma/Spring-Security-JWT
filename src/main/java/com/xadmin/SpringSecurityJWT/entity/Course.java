package com.xadmin.SpringSecurityJWT.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "COURSE_TBL")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long course_id;

	public Set<Student> getLikes() {
		return likes;
	}

	public void setLikes(Set<Student> likes) {
		this.likes = likes;
	}

	@ManyToMany(mappedBy = "likedCourses")
	Set<Student> likes;

	public Long getCourse_id() {
		return course_id;
	}

	public void setCourse_id(Long course_id) {
		this.course_id = course_id;
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
