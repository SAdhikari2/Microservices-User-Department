package com.saikat.userservice.VO;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.saikat.userservice.entity.User;

public class ResponseTemplateVO {

	private Optional<User> user;
	private Department department;
	
	public ResponseTemplateVO(Optional<User> user, Department department) {

		this.user = user;
		this.department = department;
	}

	public ResponseTemplateVO() {
		
	}

	public Optional<User> getUser() {
		return user;
	}

	public void setUser(Optional<User> user) {
		this.user = user;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department2) {
		this.department = department2;
	}
	
	
	
}
