package com.myretail.myRetail.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myretail.myRetail.model.ProductDetails;
import com.myretail.myRetail.repository.ProductDetailRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductDetailRepository detailRepository;
	@Autowired
	KafkaService kafkaService;
	
	
	public ProductDetails getProductDetails(Integer id) {
		return detailRepository.findById(id).get();
	}
	
	
	public List<ProductDetails> getAllProductDetails(){
		return detailRepository.findAll();	
		}
	
	public void createProductDetails(ProductDetails productDetails) {
		detailRepository.save(productDetails);
	}
	
	public void deleteProductDetails(Integer id) {
	 detailRepository.deleteById(id);
	}
	
	public ProductDetails updateProductDetails(Integer id, ProductDetails productDetails) {
		ProductDetails product = getProductDetails(id);
		if(productDetails.getId()==null )
			productDetails.setId(product.getId());
		if(productDetails.getCurrency_code()==null )
			productDetails.setCurrency_code(product.getCurrency_code());
		if(productDetails.getCurrent_price()==null )
			productDetails.setCurrent_price(product.getCurrent_price());
		if(productDetails.getDescription()==null )
			productDetails.setDescription(product.getDescription());
		return detailRepository.save(productDetails);
	}
	
	public void createBulkProductDetails(List<ProductDetails> productDetails) {
		productDetails.forEach(product -> this.kafkaService.sender(product));
	
		
	}
	

}
