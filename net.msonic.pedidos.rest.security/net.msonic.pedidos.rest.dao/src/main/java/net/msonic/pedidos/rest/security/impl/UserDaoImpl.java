package net.msonic.pedidos.rest.security.impl;

import org.springframework.stereotype.Repository;

import net.msonic.pedidos.rest.security.User;
import net.msonic.pedidos.rest.security.UserDao;

@Repository
public class UserDaoImpl implements UserDao {

	public User getByLogin(String login) {
		
		System.out.println(login);
		
		if(login.compareTo("admin")==0){
			System.out.println("1");
			return new User("admin", "Administrator", "admin", "ADMIN");
		}else if(login.compareTo("special")==0){
			System.out.println("2");
			return new User("special", "Special Expert", "special", "ROLE_SPECIAL");
		}else if(login.compareTo("user1")==0){
			System.out.println("3");
			return new User("user1", "User Uno", "user1");
		}else if(login.compareTo("Aladdin")==0){
			System.out.println("4");
			return new User("Aladdin", "Aladdin", "open sesame");
		}
		return null;
	}
}