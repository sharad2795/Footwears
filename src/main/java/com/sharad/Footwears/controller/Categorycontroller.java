package com.sharad.Footwears.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sharad.Footwears.DAO.CategoryDAO;
import com.sharad.Footwears.modal.Category;
import com.sharad.Footwears.modal.productmodel;
@Controller
public class Categorycontroller
{
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	Category category;
	
	@RequestMapping("/categorycrud")
	public ModelAndView category()
	{
			ModelAndView mv= new ModelAndView("/Category","command",new Category());
			return mv;
	}
	
	@Transactional
	public List<Category> showlist()
	{
		List<Category> list = new ArrayList<Category>();
		list.addAll(categoryDAO.list());
		return list;
	}
	@Transactional
	@RequestMapping(value="/category",method=RequestMethod.POST)
	public ModelAndView addcategory(@ModelAttribute Category category,@RequestParam("id")String id,@RequestParam("name")String name,@RequestParam("description")String desc)
	{
		System.out.println("insideaddcategory");
		if(id.equals(""))
		{
			ModelAndView mv1=new ModelAndView("/Category","command",new Category());
			mv1.addObject("nullid", "please enter categoryid");
			return mv1;
		}
		
		if(name.equals(""))
		{
			ModelAndView mv1=new ModelAndView("/Category","command",new Category());
			mv1.addObject("nullname", "please enter category name");
			return mv1;
		}
		
		if(desc.equals(""))
		{
			ModelAndView mv1=new ModelAndView("/Category","command",new Category());
			mv1.addObject("nulldesc", "please enter description");
			return mv1;
		}
		
		ModelAndView mv=new ModelAndView("/showaddcategory","command",new Category());
		System.out.println("aftermodelandview");
		categoryDAO.save(category);
		System.out.println("after categorydaosave");
		List<Category> list= showlist();
		mv.addObject("categorylist", list);
		return mv;
	}
	@Transactional
	@RequestMapping("/updatecategory")
	public ModelAndView updatecategorylist()
	{		List<Category> list= showlist();
			ModelAndView mv= new ModelAndView("/updatecategory","command",new Category());
			mv.addObject("updatelist", list);
			return mv;
	}
	
	@Transactional
	@RequestMapping("/validateupdatecategory")
	public ModelAndView showupdatecategory(@RequestParam("id")String id, Category category)
	{
		if(id.equals(""))
		{
			ModelAndView mv1=new ModelAndView("forward:/updatecategory","command",new Category());
			mv1.addObject("nullid", "please enter the id");
			return mv1;
		}
	
		category=categoryDAO.getcategorybyid(id);
		ModelAndView mv= new ModelAndView("/showupdatecategory","command",new Category());
		List<Category> list =showlist();
		mv.addObject("showlist",list);
		mv.addObject("ID", id);
		mv.addObject("NAME",category.getName());
		mv.addObject("DESC",category.getDescription() );
		return mv;
	}
	
	@Transactional
	@RequestMapping("/validateupdate")
	public ModelAndView validateupdatecategory(@ModelAttribute Category category)
	{
		ModelAndView mv=new ModelAndView("/updatecategory","command", new Category());
		categoryDAO.update(category);
		List<Category> list= showlist();
		mv.addObject("updatelist", list);
		mv.addObject("successupdate", "updatedsuccesfully");
		return mv;
	}
	
	@Transactional
	@RequestMapping("/deletecategory")
	public ModelAndView showdeletecategory()
	{
		List<Category> list = showlist();
		ModelAndView mv= new ModelAndView("/deletecategory","command",new Category());
		mv.addObject("deletelist",list);
		return mv;
		
	}
	
	@Transactional
	@RequestMapping("/validatedeletecategory")
	public ModelAndView deletecategory(@RequestParam("id")String id)
	{
		if(id.equals(""))
		{
			ModelAndView mv1=new ModelAndView("forward:/deletecategory","command",new Category());
			mv1.addObject("nullid", "please enter id to be deleted");
			return mv1;
		}
		
		 	Category category=categoryDAO.getcategorybyid(id);
		 	categoryDAO.delete(category);
		 	List<Category> list =showlist();
			ModelAndView mv= new ModelAndView("/deletecategory","command",new Category());
			mv.addObject("deletelist",list);
			return mv;
	}

}
