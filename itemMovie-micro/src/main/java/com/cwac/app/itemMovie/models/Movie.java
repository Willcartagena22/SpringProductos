package com.cwac.app.itemMovie.models;

import java.util.Date;

public class Movie {

	private Long id;	
	private String tittle;
	private String description;
	private Long id_image;
	private Date createAt;
	private Double rental_price;
	private Double sale_price;
	private String availability;
	private Integer port;
	
	public Integer getPort() {
		return port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTittle() {
		return tittle;
	}
	public void setTittle(String tittle) {
		this.tittle = tittle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getId_image() {
		return id_image;
	}
	public void setId_image(Long id_image) {
		this.id_image = id_image;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public Double getRental_price() {
		return rental_price;
	}
	public void setRental_price(Double rental_price) {
		this.rental_price = rental_price;
	}
	public Double getSale_price() {
		return sale_price;
	}
	public void setSale_price(Double sale_price) {
		this.sale_price = sale_price;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	
	
}
