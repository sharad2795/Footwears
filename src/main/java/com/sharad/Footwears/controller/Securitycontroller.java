package com.sharad.Footwears.controller;


import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sharad.Footwears.DAO.CartDAO;
import com.sharad.Footwears.DAO.UserDAO;
import com.sharad.Footwears.modal.User;
@Controller
public class Securitycontroller {

	@Autowired
	private HttpSession session;
	
	@Autowired
	private UserDAO userDAO;
	
	private CartDAO cartDAO;
	
	@Autowired
	public User user;
	
	@RequestMapping(value="/loginError",method = RequestMethod.GET)
	public ModelAndView loginErrorEncountered()
	{
	
		ModelAndView mv=new ModelAndView("/index");
		mv.addObject("msg","Invalid User Credential");
		return mv;
	}
	
	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public String accessDenied(Model model) {
		model.addAttribute("errorMsg", "You are not authorized to access this page");
		return "/accessdenied";

	}
	
	@SuppressWarnings("unchecked")	
	@RequestMapping(value="/user_validate")
	public ModelAndView userlogin(HttpSession session,Model model)
	{
		
		String userid = SecurityContextHolder.getContext().getAuthentication().getName();
		User user=userDAO.getuserbyid(userid);
		ModelAndView mv;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication(); 
		String loggedInUserid = auth.getName();
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) auth.getAuthorities(); 
		if(user.getRole().equals("admin")) 
		{ 
			mv=new ModelAndView("/admin");
			session.setAttribute("AdminMsg","AdminLoggedIn");
			session.setAttribute("admin", "true");
			session.setAttribute("UserName", user.getFirstname());
			session.setAttribute("loginMsg", null);
			mv.addObject("isAdmin", "true");
		} 
		else 
		{
			mv=new ModelAndView("/index");
			session.setAttribute("UserMsg","LoggedIn");
			session.setAttribute("lkey", "Welcome : "+loggedInUserid);
			session.setAttribute("pkey", "Welcome");
			session.setAttribute("UserID", user.getUserid());
			session.setAttribute("UserName", user.getFirstname());
			session.setAttribute("loginMsg", null);
		     mv.addObject("isAdmin", "false");
			}

		session.setAttribute("lkey", "Welcome : "+loggedInUserid);
		session.setAttribute("pkey", "Welcome");
		return mv;
	}
	
	@RequestMapping("/secure_logout")
	public ModelAndView secureLogout()
	{		
		session.invalidate();		
		ModelAndView mv = new ModelAndView("/index");
		session.setAttribute("loginMsg", "notLoggedIn");
		session.setAttribute("UserMsg", null);
		session.setAttribute("AdminMsg", null);
		return mv;		
	}


}
