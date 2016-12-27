package com.dineshonjava.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dineshonjava.model.Login;
import com.mysql.jdbc.ResultSet;

@Repository
public class LoginDaoImpl implements LoginDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	public boolean loginUsers(String username, String password) {
		boolean isValidUser = false;
		Query query  =sessionFactory.getCurrentSession().createSQLQuery("select * FROM Login as o WHERE o.username= ? and password = ?");
		query.setParameter(0, username);
		query.setParameter(1,password);
		//query.executeUpdate();
		List result=query.list();
		if((result.size() > 0)&&(result != null)){
			isValidUser= true;
		}
		return isValidUser;
	}
	

	
	
}
