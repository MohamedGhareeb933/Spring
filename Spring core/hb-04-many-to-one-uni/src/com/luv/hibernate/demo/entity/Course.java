package com.luv.hibernate.demo.entity;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="course")
public class Course {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@ManyToOne(cascade= {CascadeType.DETACH, CascadeType.MERGE,
						 CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="instructor_id")
	private Instructor instruct;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name  = "course_id", referencedColumnName = "id")
	private List<Review> reviewList;
	
	Course() {
		
	}

	public Course(String title) {
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Instructor getInstruct() {
		return instruct;
	}

	public void setInstruct(Instructor instruct) {
		this.instruct = instruct;
	}
	

	public List<Review> getReviewList() {
		return reviewList;
	}

	public void setReviewList(List<Review> reviewList) {
		this.reviewList = reviewList;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", ReviewList" + reviewList + "]";
	}
	
	public void addReview(Review review) {
		if(reviewList == null) {
			reviewList = new ArrayList<>();
		}
		
		reviewList.add(review);
	}
	
	
}
