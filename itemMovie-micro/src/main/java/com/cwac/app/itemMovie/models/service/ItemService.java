package com.cwac.app.itemMovie.models.service;

import java.util.List;

import com.cwac.app.itemMovie.models.ItemMovie;

public interface ItemService {
	
	public List<ItemMovie> findAll();
	public ItemMovie findById(Long id, Integer quantity);

}
