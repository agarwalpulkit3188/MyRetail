package com.myretail.myRetail.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myretail.myRetail.model.ProductDetails;
import com.myretail.myRetail.service.ProductService;

@RestController
@RequestMapping("/productdetails") 
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/{id}")
	//@Cacheable(value = "productdetailsCache",key="#id")
	public ProductDetails getProductDetails(@PathVariable Integer id) {
		return productService.getProductDetails(id);
	}
	
	@GetMapping("/")
	public List<ProductDetails> getAllProductDetails(){
		return productService.getAllProductDetails();
		
	}
	@PostMapping("/")
	public void createProductDetails (@RequestBody ProductDetails productDetails) {
		productService.createProductDetails(productDetails);
	}
	
	@DeleteMapping("/{id}")
	//@CacheEvict(value = "productdetailsCache", key="#id")
	public void deleteProductDetails(@PathVariable Integer id) {
		productService.deleteProductDetails(id);
	}
	
	@PutMapping("/{id}")
	//@CachePut(value = "productdetailsCache",key="#id")
	public ProductDetails updateProductDetails(@PathVariable Integer id, @RequestBody ProductDetails productDetails) {
		return productService.updateProductDetails(id, productDetails);
	}
	
	
	@PostMapping("/bulk")
	public void createBulkProductDetails (@RequestBody List<ProductDetails> productDetails) {
		System.out.println("sarthak");
		productService.createBulkProductDetails(productDetails);
	}
	

}
