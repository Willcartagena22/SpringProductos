package com.cwac.app.micro.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.cwac.app.micro.models.entity.Movie;

public interface MovieDao extends CrudRepository<Movie, Long> {

}
