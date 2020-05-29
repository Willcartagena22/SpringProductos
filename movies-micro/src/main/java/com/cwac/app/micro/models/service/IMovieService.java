package com.cwac.app.micro.models.service;

import java.util.List;

import com.cwac.app.micro.models.entity.Movie;

public interface IMovieService {

	public List<Movie> findAll();
	public Movie findById(Long id);
	public Movie save(Movie movie);
	public void deleteById(Long id);
}
