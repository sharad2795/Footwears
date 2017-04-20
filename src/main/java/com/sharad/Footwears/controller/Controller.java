package com.sharad.Footwears.controller;

import java.util.Collection;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sharad.Footwears.DAO.UserDAO;
import com.sharad.Footwears.modal.User;

@org.springframework.stereotype.Controller

public class Controller {
	
	public String logid;
	
	
	
	public String getLogid() {
		return logid;
	}
	@Autowired
	private HttpSession session;
	
	@Autowired
	User user;
	
	@Autowired
	UserDAO userDAO;
	
	@RequestMapping("/")
	public ModelAndView showindex()
	{
		ModelAndView mv=new ModelAndView("/index");
		session.setAttribute("index", "true");
		return mv;
	}
	@RequestMapping("/home")
	public ModelAndView showhome()
	{
		ModelAndView mv=new ModelAndView("/index");
		return mv;
	}
	@RequestMapping("/aboutus")
	public ModelAndView aboutus()
	{
		ModelAndView mv=new ModelAndView("/aboutus");
		return mv;
	}
	@RequestMapping("/contactus2")
	public ModelAndView contactus()
	{
		ModelAndView mv=new ModelAndView("/contactus2");
		return mv;
	}
	@RequestMapping("/login")
	public ModelAndView login()
	{
		ModelAndView mv=new ModelAndView("/login","command",new User());
		mv.addObject("loginclicked","true");
		return mv;
	}
	
	@RequestMapping("/register")
	public ModelAndView register()
	{
		ModelAndView mv=new ModelAndView("/register","command",new User());
		mv.addObject("register clicked","true");
		return mv;
	}
	@RequestMapping("/logout")
	public ModelAndView logout()
	{
		ModelAndView mv= new ModelAndView("/index");
		session.removeAttribute("lkey");
		session.removeAttribute("pkey");
		session.removeAttribute("admin");
		session.removeAttribute("index");
		logid=null;
		return mv;
	}
	@Transactional
	@RequestMapping(value="/validate")
	public ModelAndView validateLogin(@ModelAttribute User user,@RequestParam("userid")String uid,@RequestParam("password")String psw)
	{	
		user = userDAO.validateuserlogin(uid, psw);
		ModelAndView mv ;
		if(user==null)
		{
			mv=new ModelAndView("/validatelogin","command",new User());
			mv.addObject("fail", "please enter valid emailid and password");
		}
		else
		{
			String userid = SecurityContextHolder.getContext().getAuthentication().getName();
			user=userDAO.getuserbyid(userid);
			Authentication auth = SecurityContextHolder.getContext().getAuthentication(); 
			String loggedInUserid = auth.getName();
			Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) auth.getAuthorities();
			mv= new ModelAndView("/index");
			logid=uid;
			user=userDAO.getuserbyid(uid);
			String role=user.getRole();
			if(role.equals("admin"))
			{
				mv= new ModelAndView("/admin");
				session.setAttribute("admin", "true");
			}
				
			mv.addObject("succ", "Hurray");
			session.setAttribute("lkey", "Welcome : "+uid);
			session.setAttribute("pkey", "Welcome");
			
		}
		return mv;
	}
	@Transactional
	@RequestMapping("/validatereg")
	public ModelAndView validateregister(@RequestParam("firstname")String fname,@RequestParam("lastname")String lname,@RequestParam("userid")String uide,@RequestParam("password")String passw,@RequestParam("confirmpassword")String cp,@RequestParam("emailid")String eid,@ModelAttribute User user)
	{
		System.out.println("In Validate Reg");
		ModelAndView mv= new ModelAndView("/index","command",new User());
		boolean b = passw.equals(cp);
		
		if(fname=="")
		{
			ModelAndView mv1= new ModelAndView("/register","command",new User());
			mv1.addObject("nullfname", "please enter firstname");
			return mv1;
		}
		
		if(lname.equals(""))
		{
			ModelAndView mv1= new ModelAndView("/register","command",new User());
			mv1.addObject("nulllname", "please enter lastname");
			return mv1;
		}
		
		if(uide.equals(""))
		{
			ModelAndView mv1= new ModelAndView("/register","command",new User());
			mv1.addObject("nulluide", "please enter userid");
			return mv1;
		}
	
		if(passw.equals(""))
		{
			ModelAndView mv1= new ModelAndView("/register","command",new User());
			mv1.addObject("nullpass", "please enter password");
			return mv1;
		}
		if(cp.equals(""))
		{
			ModelAndView mv1= new ModelAndView("/register","command",new User());
			mv1.addObject("nullcp", "please enter confirmpassword");
			return mv1;
		}
		if(eid.equals(""))
		{
			ModelAndView mv1= new ModelAndView("/register","command",new User());
			mv1.addObject("nullemail", "please enter emailid");
			return mv1;
		}
	
		
		if(fname.equals(uide))
		{
			System.out.println("in name");
			mv.addObject("errormessage","firstname and userid cannot be same");
		}
		if(b!=true)
		{
			System.out.println("in pass");
			mv.addObject("fkey","passwords are not matching");
			
		}
		if(!fname.equals(uide) && b==true)
		{
			logid=uide;
			System.out.println("complted");
			user.setRole("user");
			userDAO.save(user);//useradd function is called here through register
			
			mv.addObject("msg1","succesfully registered");
			mv.addObject("passkey","passwords are matching");
			session.setAttribute("pkey", "Welcome");
			session.setAttribute("lkey", "Welcome :"+fname+lname);
			
		}
		return mv;
	}
	

}
