package com.cwac.app.itemMovie.models.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cwac.app.itemMovie.models.ItemMovie;
import com.cwac.app.itemMovie.models.Movie;

@Service("serviceRestTemplate")
public class ItemServiceImpl implements ItemService{

	@Autowired
	private RestTemplate clienteRest;
	
	@Override
	public List<ItemMovie> findAll() {
		List<Movie> movies = Arrays.asList(clienteRest.getForObject("http://movies-micro/tolist", Movie[].class));
		
		return movies.stream().map(p -> new ItemMovie(p,1)).collect(Collectors.toList());
		
	}

	@Override
	public ItemMovie findById(Long id, Integer quantity) {
		
		Map<String, String> pathVariables = new HashMap<String,String>();
		pathVariables.put("id", id.toString());
		Movie movie = clienteRest.getForObject("http://movies-micro/tolist/{id}", Movie.class,pathVariables);
		return new ItemMovie(movie,quantity);
	}

}
