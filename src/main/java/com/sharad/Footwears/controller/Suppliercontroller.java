package com.sharad.Footwears.controller;

import java.util.ArrayList;
import java.util.List;

import org.h2.util.New;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.ModelAndView;

import com.sharad.Footwears.DAO.SupplierDAO;
import com.sharad.Footwears.modal.Category;
import com.sharad.Footwears.modal.Supplier;

@Controller
public class Suppliercontroller 
{

	@Autowired
	SupplierDAO supplierDAO;
	@Autowired
	Supplier supplier;
	
	@RequestMapping("/addsupplier")
	public ModelAndView supplieradd()
	{
		ModelAndView mv=new ModelAndView("/supplieradd","command",new Supplier());
		return mv;
	}
	@Transactional
	public List<Supplier> showlist()
	{
		List<Supplier> list = new ArrayList<Supplier>();
		list.addAll(supplierDAO.getallsupplier());
		return list;
	}
	@Transactional
	@RequestMapping("/supplieradd")
	public ModelAndView showsupplieradd(@ModelAttribute Supplier supplier,@RequestParam("id")String id,@RequestParam("name")String name,@RequestParam("address")String addr)
	{
		if(id.equals(""))
		{
			ModelAndView mv1=new ModelAndView("/supplieradd","command",new Supplier());
			mv1.addObject("nullid", "please enter supplier id");
			return mv1;
		}
		
		if(name.equals(""))
		{
			ModelAndView mv1=new ModelAndView("/supplieradd","command",new Supplier());
			mv1.addObject("nullname", "please enter supplier name");
			return mv1;
		}
		
		if(addr.equals(""))
		{
			ModelAndView mv1=new ModelAndView("/supplieradd","command",new Supplier());
			mv1.addObject("nulladdr", "please enter address");
			return mv1;
		}
		ModelAndView mv= new ModelAndView("/showaddsupplier","command",new Supplier());
		supplierDAO.save(supplier);
		List<Supplier> list= showlist();
		mv.addObject("supplierlist", list);
		return mv;
	}
	@Transactional
	@RequestMapping("/supplierupdate")
	public ModelAndView supplierupdate()
	{	
		List<Supplier> list= showlist();
		ModelAndView mv= new ModelAndView("/supplierupdate","command",new Supplier());
		mv.addObject("updatelist", list);
				return mv;
	}
	
	@Transactional
	@RequestMapping("/validateupdatesupplier")
	public ModelAndView showupdatesupplier(@RequestParam("id")String id, Supplier supplier)
	{
		if(id.equals(""))
		{
			ModelAndView mv1=new ModelAndView("forward:/supplierupdate","command",new Supplier());
			mv1.addObject("nullid", "please enter the id");
			return mv1;
		}
		supplier=supplierDAO.getsupplierbyid(id);
		ModelAndView mv= new ModelAndView("/showupdatesupplier","command",new Supplier());
		List<Supplier> list =showlist();
		mv.addObject("showlist",list);
		mv.addObject("ID", id);
		mv.addObject("SNAME",supplier.getName());
		mv.addObject("ADD",supplier.getAddress());
		return mv;
	}
	
	@Transactional
	@RequestMapping("/validatesupplier")
	public ModelAndView validateupdatesupplier(@ModelAttribute Supplier supplier)
	{
		supplierDAO.update(supplier);
		List<Supplier> list =showlist();
		ModelAndView mv=new ModelAndView("/supplierupdate","command", new Supplier());
		mv.addObject("updatelist",list);
		mv.addObject("successupdate", "updatedsuccesfully");
		return mv;
	}
	
	@Transactional
	@RequestMapping("/deletesupplier")
	public ModelAndView showdeletesupplier()
	{
		List<Supplier> list = showlist();
		ModelAndView mv= new ModelAndView("/deletesupplier","command",new Supplier());
		mv.addObject("deletelist",list);
		return mv;
		
	}
	
	@Transactional
	@RequestMapping("/validatedeletesupplier")
	public ModelAndView deletesupplier(@RequestParam("id")String id)
	{
		if(id.equals(""))
	{
		ModelAndView mv1=new ModelAndView("forward:/deletesupplier","command",new Supplier());
		mv1.addObject("nullid", "please enter id to be deleted");
		return mv1;
	}
	
		
		 Supplier supplier=supplierDAO.getsupplierbyid(id);
		supplierDAO.delete(supplier);
		
			List<Supplier> list =showlist();
			ModelAndView mv= new ModelAndView("/deletesupplier","command",new Supplier());
			mv.addObject("deletelist",list);
			return mv;
	}

}
