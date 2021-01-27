package com.luv.hibernate.demo.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="instructor")
public class instructor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="birth")
	private Date birth;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="instructor_detail_id")
	private instructorDetail instructorD;
	
	@OneToMany(fetch=FetchType.LAZY,
			   mappedBy="instruct", 
			   cascade={CascadeType.DETACH, CascadeType.MERGE,
			 			CascadeType.PERSIST, CascadeType.REFRESH} )
	private List<Course> courseList;
	
	public instructor() {
		
	}

	public instructor(String firstName, String lastName, String email, Date birth) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.birth = birth;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public instructorDetail getInstructorD() {
		return instructorD;
	}

	public void setInstructorD(instructorDetail instructorD) {
		this.instructorD = instructorD;
	}

	public List<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

	@Override
	public String toString() {
		return "instructor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", birth=" + DateUtil.dateToString(birth);
	}
	
	public void addCourse(Course course) {
		if(courseList == null) {
			courseList = new ArrayList<>();
		}
		course.setInstruct(this);
		
		courseList.add(course);
	}
	
	
}
