package com.cwac.app.oauth.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.cwac.app.oauth.service.IUsuarioService;
import com.cwac.app.user.commons.entity.Usuario;

@Component
public class InfoAdicionalToken implements TokenEnhancer {

	@Autowired
	private IUsuarioService iuser;
	
	
	
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		Map<String, Object> info = new HashMap<String, Object>();	
		
		Usuario usuario = iuser.findByUsername(authentication.getName());
		info.put("nombre", usuario.getName());
		info.put("email", usuario.getEmail());
		info.put("nombre", usuario.getName());
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
	
		return accessToken;
	}

	
}
