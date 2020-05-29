package com.cwac.app.itemMovie.models.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.cwac.app.itemMovie.clients.ItemMovieClient;
import com.cwac.app.itemMovie.models.ItemMovie;

@Service("serviceFeign")
@Primary
public class ItemServiceFeign implements ItemService{

	@Autowired
	private ItemMovieClient  clienteFeign;
	
	@Override
	public List<ItemMovie> findAll() {
		// TODO Auto-generated method stub
		return clienteFeign.listar().stream().map(p -> new ItemMovie(p,1)).collect(Collectors.toList());
	}

	@Override
	public ItemMovie findById(Long id, Integer quantity) {
		// TODO Auto-generated method stub
		return new ItemMovie(clienteFeign.detalle(id), quantity) ;
	}

}
