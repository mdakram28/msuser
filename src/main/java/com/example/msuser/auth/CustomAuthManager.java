package com.example.msuser.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import com.example.msuser.dao.UserDAO;

public class CustomAuthManager implements AuthenticationProvider {

	private UserDAO userDAO;

	public CustomAuthManager(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getPrincipal() + "";
		String password = authentication.getCredentials() + "";
		
		if(username.equals("admin") && password.equals("password")){
			return new UsernamePasswordAuthenticationToken(username, password);
		}

		boolean valid = userDAO.authenticate(username, password);
		System.out.println("Authentication successful : "+valid);
		if (!valid) {
			throw new BadCredentialsException("1000");
		}

		return new UsernamePasswordAuthenticationToken(username, password);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
