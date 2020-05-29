package com.cwac.app.itemMovie.models;

public class ItemMovie {

	private Movie movie;
	private Integer quantity;
	
	
	
	public ItemMovie() {
	}
	public ItemMovie(Movie movie, Integer quantity) {

		this.movie = movie;
		this.quantity = quantity;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public Double getTotalRent() {
		return movie.getRental_price() * quantity.doubleValue();
	};
	
}
