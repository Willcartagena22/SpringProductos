package com.cwac.app.itemMovie.controllers;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cwac.app.itemMovie.models.ItemMovie;
import com.cwac.app.itemMovie.models.Movie;
import com.cwac.app.itemMovie.models.service.ItemService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@RefreshScope
@RestController
public class ItemController {

	private Logger log = org.slf4j.LoggerFactory.getLogger(ItemController.class);
	
	@Autowired
	private Environment env;
	
	
	@Autowired
	@Qualifier("serviceRestTemplate")
	private ItemService itemservice;
	
	@Value("${configuracion.texto}")
	private String texto;
	
	@GetMapping("/tolist")
	public List<ItemMovie> listar(){
		return itemservice.findAll();
	}
	
	
	@HystrixCommand(fallbackMethod = "metodoAlternativo")
	@GetMapping("/tolist/{id}/quantity/{quantity}")
	public ItemMovie detalle(@PathVariable Long id, @PathVariable Integer quantity) {
		
	return itemservice.findById(id, quantity);
	}
	
	public ItemMovie metodoAlternativo(Long id, Integer quantity) {
		ItemMovie item = new ItemMovie();
		Movie mv = new Movie();
		Date date = new Date();
			
		item.setQuantity(quantity);
		mv.setId(id);
		mv.setTittle("Pelicula Alternativa");
		mv.setSale_price(10.00);
		mv.setCreateAt(date);	
		mv.setId_image((long)1);
		mv.setDescription("Descripción Genérica");
		mv.setAvailability("YES");
		mv.setRental_price(10.00);
		item.setMovie(mv);
		
		return item;
	}
	
	
	@GetMapping("/obtener-config")
	public ResponseEntity<?> getConfig(@Value("${server.port}") String puerto){
		
			log.info(texto);
			Map<String, String> json = new HashMap<>();
			json.put("texto",texto);
			json.put("puerto",puerto);
			
			if(env.getActiveProfiles().length>0 && env.getActiveProfiles()[0].equals("dev")) {
				json.put("autor.nombre",env.getProperty("configuracion.autor.nombre"));
				json.put("autor.email",env.getProperty("configuracion.autor.email"));
			}
			
			return new ResponseEntity<Map<String, String>>(json, HttpStatus.OK);				
	}

	
	
}
