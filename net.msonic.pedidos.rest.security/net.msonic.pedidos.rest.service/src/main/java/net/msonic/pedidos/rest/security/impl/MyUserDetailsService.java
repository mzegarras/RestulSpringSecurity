package net.msonic.pedidos.rest.security.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import net.msonic.pedidos.rest.security.User;
import net.msonic.pedidos.rest.security.UserContext;
import net.msonic.pedidos.rest.security.UserDao;

/**
 * Implements Spring Security {@link UserDetailsService} that is injected into authentication provider in configuration XML.
 * It interacts with domain, loads user details and wraps it into {@link UserContext} which implements Spring Security {@link UserDetails}.
 */

public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	/**
	 * This will be called from
	 * {@link org.springframework.security.authentication.dao.DaoAuthenticationProvider#retrieveUser(java.lang.String, org.springframework.security.authentication.UsernamePasswordAuthenticationToken)}
	 * when {@link AuthenticationService#authenticate(java.lang.String, java.lang.String)} calls
	 * {@link AuthenticationManager#authenticate(org.springframework.security.core.Authentication)}. Easy.
	 */
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println(" *** MyUseDetailService.loadUserByUsername");
		if(userDao==null){
			System.out.println(" *** MyUseDetailService.loadUserByUsername null");
		}else{
			System.out.println(" *** MyUseDetailService.loadUserByUsername not null");
		}
		User user = userDao.getByLogin(username);
		if (user == null) {
			throw new UsernameNotFoundException("User " + username + " not found");
		}
		
		
		System.out.println(" *** MyUseDetailService.loadUserByUsername- UserContext");
		return new UserContext(user);
	}
}