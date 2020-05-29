package com.cwac.app.micro.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cwac.app.micro.models.dao.MovieDao;
import com.cwac.app.micro.models.entity.Movie;
import com.cwac.app.micro.models.service.IMovieService;
@RestController
public class MovieController {

	@Autowired
	private Environment env;
	
	@Value("${server.port}")
	private Integer port;
	
	
	@Autowired
	private IMovieService movieService;
	
	
	@GetMapping("/tolist")
	public List<Movie> listar(){
		return movieService.findAll().stream().map(movie -> {
			//movie.setPort(Integer.parseInt(env.getProperty("local.server.port")));
			movie.setPort(port);
			return movie;
		}).collect(Collectors.toList());
	}
	

	
	@GetMapping("/tolist/{id}")
	public Movie detalle(@PathVariable Long id) throws Exception {		
		Movie movie = movieService.findById(id);
		//movie.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		movie.setPort(port);
/*		boolean ok = false;
		if (ok== false) {
			throw new Exception("No se pudo cargar");
		}*/
		return movie;
	}
	
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public Movie addMovie(@RequestBody Movie mv) {
		return movieService.save(mv);
	}
	
	
	@PutMapping("/edit/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Movie editMovie(@RequestBody Movie mv,@PathVariable Long id) {
		Movie movieDB = movieService.findById(id);
		movieDB.setTittle(mv.getTittle());
		movieDB.setAvailability(mv.getAvailability());
		movieDB.setDescription(mv.getDescription());
		movieDB.setRental_price(mv.getRental_price());
		movieDB.setSale_price(mv.getSale_price());
		movieDB.setId_image(mv.getId_image());
		return movieService.save(movieDB);
	}
	
	
	@DeleteMapping("/deleteMovie/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteMovie(@PathVariable Long id) {
		movieService.deleteById(id);
	}
	
}
