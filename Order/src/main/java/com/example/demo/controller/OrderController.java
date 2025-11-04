package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.OrderRepository;
import com.example.demo.dto.UserDTO;
import com.example.demo.model.OrderModel;
import com.example.demo.service.Orderservice;

@RestController
public class OrderController{
	
	@Autowired
	OrderRepository orderrepo;
	
	@Autowired  // 
    Orderservice orderService;
	
	@GetMapping("/orders")
	public List<OrderModel> getAllOrders(){
		return (List<OrderModel>) orderrepo.findAll();
	}
	
	@PostMapping("/order")
	public OrderModel saveOrder(@RequestBody OrderModel ord)
	{
		return orderrepo.save(ord);
	}
	
	@GetMapping("/order/{uid}")
	public List<OrderModel> getOrderByUid(@PathVariable Integer uid){
		     return orderrepo.findByUid(uid);
	}
	
	@GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        try {
            List<UserDTO> users = orderService.getUserDetails();
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
	@PostMapping("/user")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO newUser) {
        try {
            UserDTO createdUser = orderService.insertuserDetails(newUser);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
	
	
}