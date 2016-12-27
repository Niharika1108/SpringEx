package com.dineshonjava.dao;


import com.dineshonjava.model.Login;

public interface LoginDao {	
	
	//public void loginUsers(Login login);
	public boolean loginUsers(String username, String password);
	//public boolean isValidUser(String username, String password); 

}
