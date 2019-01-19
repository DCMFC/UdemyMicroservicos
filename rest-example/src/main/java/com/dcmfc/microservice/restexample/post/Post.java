package com.dcmfc.microservice.restexample.post;

public class Post {
	
	private Integer id;
	private String message;
	private Integer userId;
	
	public Post(Integer id, Integer userId, String message) {
		super();
		this.id = id;
		this.message = message;
		this.userId = userId;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
