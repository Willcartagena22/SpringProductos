package com.cwac.app.itemMovie.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cwac.app.itemMovie.models.Movie;

@FeignClient(name = "movies-micro")
//@FeignClient(name = "movies-micro", url="localhost:8001")
public interface ItemMovieClient {
	
	@GetMapping("tolist")
	public List<Movie> listar();
	
	@GetMapping("/tolist/{id}")
	public Movie detalle(@PathVariable Long id);
}
