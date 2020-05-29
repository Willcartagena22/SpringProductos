package com.cwac.app.micro.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cwac.app.micro.models.dao.MovieDao;
import com.cwac.app.micro.models.entity.Movie;

@Service
public class MovieServiceImpl  implements IMovieService{

	@Autowired
	private MovieDao movieDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Movie> findAll() {
		return (List<Movie>)movieDao.findAll();
		//Iterable es super interfaz de List, por eso se hace Cast
	}

	@Override
	public Movie findById(Long id) {
		return movieDao.findById(id).orElse(null);
		/*desde java 8 con la jdk, se puede saber si se encontró el objeto en la base
		no uso .get porque esto me devuelve una excepción y con orElse le digo 
		que me devuelva otra cosa*/
	}

	@Override
	@Transactional
	public Movie save(Movie movie) {

		return movieDao.save(movie);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		
		movieDao.deleteById(id);
		
	}

}
