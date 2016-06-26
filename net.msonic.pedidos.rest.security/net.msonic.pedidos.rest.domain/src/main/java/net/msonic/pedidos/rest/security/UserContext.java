package net.msonic.pedidos.rest.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/** This object wraps {@link User} and makes it {@link UserDetails} so that Spring Security can use it. */
public class UserContext implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	

	public UserContext(User user) {
		this.user = user;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		for (String role : user.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		return authorities;
	}

	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getLogin();
	}

	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		return this == o
				|| o != null && o instanceof UserContext
				&& Objects.equals(user, ((UserContext) o).user);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hashCode(user);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "UserContext{" +
		"user=" + user +
		'}';
	}
	
}