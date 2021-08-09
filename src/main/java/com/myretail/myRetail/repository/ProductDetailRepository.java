package com.myretail.myRetail.repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.myretail.myRetail.model.ProductDetails;

public interface ProductDetailRepository extends MongoRepository<ProductDetails, Integer> {
	
}
