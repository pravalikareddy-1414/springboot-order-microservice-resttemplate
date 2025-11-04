package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.OrderModel;

public interface OrderRepository extends CrudRepository<OrderModel,Integer> {

	 public List<OrderModel> findByUid(Integer uid);
}
