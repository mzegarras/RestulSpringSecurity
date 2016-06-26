package net.msonic.pedidos.rest.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 * {@link AuthenticationEntryPoint} that rejects all requests. Login-like function is featured
 * in {@link TokenAuthenticationFilter} and this does not perform or suggests any redirection.
 * This object is hit whenever user is not authorized (anonymous) and secured resource is requested.
 */


public final class UnauthorizedEntryPoint implements AuthenticationEntryPoint {

	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		System.out.println(" *** UnauthorizedEntryPoint.commence: " + request.getRequestURI());
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		
	}
	
	
	
	
	
}