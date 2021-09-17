package com.saikat.userservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.saikat.userservice.VO.Department;
import com.saikat.userservice.VO.ResponseTemplateVO;
import com.saikat.userservice.entity.User;
import com.saikat.userservice.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	

	public User saverUser(User user) {

		return userRepository.save(user);
	}

//	public Optional<User> findUserById(Long userId) {
//
//		return userRepository.findById(userId);
//	}

	public ResponseTemplateVO getuserWithDepartment(Long userId) {
		
		ResponseTemplateVO vo = new ResponseTemplateVO();
		Optional<User> user = userRepository.findById(userId);
		
		Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.get().getDepartmentId(), 
				Department.class);
		
		vo.setUser(user);
		vo.setDepartment(department);
		
		return vo;
	}
}
