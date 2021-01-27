package com.luv.hibernate.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="instructor_detail")
public class instructorDetail {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="youtube_channel")
	private String youtubeChannel;
	
	@Column(name="hobby")
	private String hobby;
	
	// Mapped By tell hibernate to look for Instructor Detail Object in the InstrucorClass 
	// then Specify the @JoinColumn to get the FK from Date Base 
	// and Initial Bi Direction between two Tables 
	// Cascade All except remove 
	@OneToOne(mappedBy="instructorD",
			cascade= {CascadeType.DETACH, CascadeType.MERGE,
					CascadeType.PERSIST, CascadeType.REFRESH}) 
	private instructor instruct;
	
	public instructorDetail() {
		
	}

	public instructorDetail(String youtubeChannel, String hobby) {
		this.youtubeChannel = youtubeChannel;
		this.hobby = hobby;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYoutubeChannel() {
		return youtubeChannel;
	}

	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	

	public instructor getInstruct() {
		return instruct;
	}

	public void setInstruct(instructor instruct) {
		this.instruct = instruct;
	}

	@Override
	public String toString() {
		return "instructorDetail [id=" + id + ", youtubeChannel=" + youtubeChannel + ", hobby=" + hobby ;
	}

	
}
