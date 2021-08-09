package com.myretail.myRetail.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection="ProductDetails")
public class ProductDetails implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Integer id;
	private String description;
	private Double current_price;
	private String currency_code;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getCurrent_price() {
		return current_price;
	}
	public void setCurrent_price(Double current_price) {
		this.current_price = current_price;
	}
	public String getCurrency_code() {
		return currency_code;
	}
	public void setCurrency_code(String currency_code) {
		this.currency_code = currency_code;
	}
	
	@Override
	public String toString() {
		return "ProductDetails [id=" + id + ", description=" + description + ", current_price=" + current_price
				+ ", currency_code=" + currency_code + "]";
	}
	
	
	
	
	

}
