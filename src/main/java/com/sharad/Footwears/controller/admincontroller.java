package com.sharad.Footwears.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sharad.Footwears.DAO.CategoryDAO;
import com.sharad.Footwears.DAO.ProductDAO;
import com.sharad.Footwears.DAO.SupplierDAO;
import com.sharad.Footwears.modal.Supplier;
import com.sharad.Footwears.modal.productmodel;
@Controller
public class admincontroller {
	
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	Categorycontroller categorycontroller;
	
	@Autowired
	Suppliercontroller suppliercontroller;
	
	@Transactional
	@RequestMapping("/accessDenied")
	public ModelAndView admin1()
	{
		ModelAndView mv=new ModelAndView("/index");
		return mv;
	}
	

	@Transactional
	@RequestMapping("/admin")
	public ModelAndView admin()
	{
		ModelAndView mv=new ModelAndView("/admin");
		return mv;
	}
	@Transactional
	@RequestMapping("/addproduct")
	public ModelAndView showaddproduct()
	{
		List<com.sharad.Footwears.modal.Category> list = categorycontroller.showlist();
		List<Supplier> list1=suppliercontroller.showlist();
		ModelAndView mv= new ModelAndView("/addproduct","command",new productmodel());
		mv.addObject("categorylist",list);
		mv.addObject("supplierlist", list1);
		return mv;
	}
	
	
	@Transactional
	public List<productmodel> showlist()
	{
		List<productmodel> list = new ArrayList<productmodel>();
		list.addAll(productDAO.getallproduct());
		return list;
	}
	
	
	@Transactional
	@RequestMapping("/editproduct")
	public ModelAndView showeditproduct()
	{
		List<productmodel> list = showlist();
		String path="C:\\Users\\Lenovo\\Desktop\\new project\\Footwears\\src\\main\\webapp\\images\\";
		ModelAndView mv= new ModelAndView("/editproduct","command",new productmodel());
		mv.addObject("productlist",list);
		mv.addObject("productimage", path);
		return mv;
	}
	
	@Transactional
	@RequestMapping("/deleteproduct")
	public ModelAndView showdeleteproduct()
	{
		List<productmodel> list = showlist();
		ModelAndView mv= new ModelAndView("/deleteproduct","command",new productmodel());
		mv.addObject("productlist",list);
		return mv;
		
	}
}