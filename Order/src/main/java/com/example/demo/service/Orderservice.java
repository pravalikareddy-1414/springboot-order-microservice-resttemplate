package com.example.demo.service;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Repository.OrderRepository;
import com.example.demo.dto.UserDTO;
import com.example.demo.model.OrderModel;

@Service
public class Orderservice {
	
	@Autowired
	OrderRepository repo;
	
	
	@Autowired
	RestTemplate restTemplate;
	
	private String userServiceUrl = "http://localhost:8081/api/users";
	private String userServicePost = "http://localhost:8081/api";
	
	
	public List<OrderModel> getorder() {
		
		return (List<OrderModel>) repo.findAll();
	}
	
	public OrderModel insertUser(OrderModel or) {
		return repo.save(or);
	}
	
	public List<UserDTO> getUserDetails() {
        try {
            UserDTO[] userArray = restTemplate.getForObject(userServiceUrl, UserDTO[].class);
            return Arrays.asList(userArray);
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch users from User Service: " + e.getMessage());
        }
    }
	
	public UserDTO insertuserDetails(UserDTO newUser) {
		try {
			String url = userServiceUrl + "/save";
			UserDTO userlist = restTemplate.postForObject(url, newUser, UserDTO.class);
			return userlist;
		}
		catch (Exception e) {
            throw new RuntimeException("Failed to fetch users from User Service: " + e.getMessage());
        }
	}

}
