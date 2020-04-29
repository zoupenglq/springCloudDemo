package com.itcast.controller;

import com.itcast.feignClient.ProductFeginClient;
import com.itcast.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private ProductFeginClient productFeignClient;


	@RequestMapping(value = "/buy/{id}",method = RequestMethod.GET)
	public Product findById(@PathVariable Long id) {
		return productFeignClient.getProduct(id);
	}

	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public String findOrderById(@PathVariable Long id) {
		return "调用订单系统查询订单";
	}
}
