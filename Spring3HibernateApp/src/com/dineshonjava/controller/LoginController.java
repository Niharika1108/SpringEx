package com.dineshonjava.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dineshonjava.bean.EmployeeBean;
import com.dineshonjava.bean.LoginBean;
import com.dineshonjava.model.Employee;
import com.dineshonjava.model.Login;
import com.dineshonjava.service.EmployeeService;
import com.dineshonjava.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView displayLogin(HttpServletRequest request, HttpServletResponse response, Login login)
	{
		ModelAndView model = new ModelAndView("login");		
		model.addObject("login", login);
		return model;
	}	
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String executeLogin(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("login")Login login)
	{
			
		ModelAndView model= null;
			String username=request.getParameter("username");
			String password=request.getParameter("password");

			try
			{       /*HttpSession session= request.getSession();
			        session.setAttribute("username", username);
			        System.out.println(session);*/
					if(username.trim().isEmpty()|| password.trim().isEmpty()){
						model = new ModelAndView("login");
						System.out.println("Cannot be empty credentials");
						request.setAttribute("message", "Cannot be empty credentials!!");
						return "redirect:/login";
					}
					else if(loginService.loginUsers(username,password))
					{
							System.out.println("User Login Successful");
							request.setAttribute("loggedInUser", login.getUsername());
							//System.out.println( loginBean.getUsername());
							//model = new ModelAndView("welcome");
							return "redirect:/index";
							
					}
				/*boolean userExists = loginService.loginUsers(login.getUsername(),
		                login.getPassword());
				if(userExists){
					model.put("login", login);
					return "index";
				}*/
					else
					{
							model = new ModelAndView("login");
							System.out.println("Invalid credentials!!");
							request.setAttribute("message", "Invalid credentials!!");
							
							return "redirect:/login";
					}

			}
			catch(Exception e)
			{
					e.printStackTrace();
			}
			return null;

			//return model;
	}
	

	
}
