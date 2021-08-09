package com.myretail.myRetail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.myretail.myRetail.model.ProductDetails;

@Service
public class KafkaService {

	@Autowired
	KafkaTemplate<String, ProductDetails> kafkaTemplate;
	
	@Autowired
	ProductService productService;
	
	private final String TOPIC="store1";
	
	public void sender(ProductDetails productDetails) {
		kafkaTemplate.send(TOPIC, productDetails);
	}
	
	@KafkaListener(topics = TOPIC,groupId ="group-store" )
	public void reciver(ProductDetails productDetails) {
		productService.createProductDetails(productDetails);
	}
}
