package com.myretail.myRetail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import com.myretail.myRetail.model.ProductDetails;

@SpringBootApplication
@EnableCaching
public class MyRetailApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyRetailApplication.class, args);
		ProductDetails productDetails =new ProductDetails();
		System.out.print(productDetails);
	}

}
