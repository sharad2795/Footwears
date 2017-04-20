package com.sharad.Footwears.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sharad.Footwears.DAO.UserDAO;
import com.sharad.Footwears.modal.Supplier;
import com.sharad.Footwears.modal.User;

@Controller
public class Usercontroller 
{
	@Autowired
	com.sharad.Footwears.controller.Controller controller;//normal controller.java object
	
	@Autowired
	User user;
	
	@Autowired
	UserDAO userDAO;
	
	@Transactional
	public List<User> showlist()
	{
		List<User> list = new ArrayList<User>();
		list.addAll(userDAO.list());
		return list;
	}
	@Transactional
	@RequestMapping("/viewupdateanddeleteuser")
	public ModelAndView showupdateanddeleteuser()
	{
		String id = controller.getLogid();
		User list = userDAO.getuserbyid(id);
		ModelAndView mv=new ModelAndView("/updateuser");
		mv.addObject("updatelist",list);
		return mv;
	}
	
	
	@Transactional
	@RequestMapping("/edituser")
	public ModelAndView userclickededit()
	{
		String id = controller.getLogid();
		User list = userDAO.getuserbyid(id);
		ModelAndView mv=new ModelAndView("/updateuser","command",new User());
		mv.addObject("userclickededit", true);
		mv.addObject("updatelist", list);
		return mv;
	}
	
	@Transactional
	@RequestMapping("/updateuser")
	public ModelAndView validateupdateuser(@ModelAttribute User user)
	{
		user.setRole("user");
		userDAO.update(user);
		String id = controller.getLogid();
		User list = userDAO.getuserbyid(id);
		ModelAndView mv= new ModelAndView("/updateuser","command", new User());
		mv.addObject("updatelist", list);
		return mv;
	}
	
	@Transactional
	@RequestMapping("/deleteuser")
	public ModelAndView deleteuser()
	{
		String id = controller.getLogid();
		User list = userDAO.getuserbyid(id);
		userDAO.delete(list);
		ModelAndView  mv= new ModelAndView("forward:/logout","command",new User());
		return mv;
		
	}
}