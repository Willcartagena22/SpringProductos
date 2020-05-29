package com.cwac.app.oauth.service;

import com.cwac.app.user.commons.entity.Usuario;

public interface IUsuarioService {

	public Usuario findByUsername(String username);
	
}
