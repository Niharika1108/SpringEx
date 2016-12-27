package com.dineshonjava.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dineshonjava.dao.LoginDao;
import com.dineshonjava.model.Login;

@Service("loginService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDao loginDao;
	

	@Override
	public boolean  loginUsers(String username, String password) {
		return loginDao.loginUsers(username,password);
		
	}
	
	

}
