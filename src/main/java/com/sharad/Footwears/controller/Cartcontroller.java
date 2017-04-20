package com.sharad.Footwears.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sharad.Footwears.DAO.CartDAO;
import com.sharad.Footwears.DAO.ProductDAO;
import com.sharad.Footwears.modal.Mycart;
import com.sharad.Footwears.modal.productmodel;
@Controller
public class Cartcontroller
{
@Autowired com.sharad.Footwears.controller.Controller Controller;

@Autowired 
CartDAO cartDAO;

@Autowired 
Mycart mycart;

@Autowired
ProductDAO productDAO;

long d=System.currentTimeMillis();
Date today = new Date(d);
 
@Transactional
public List<Mycart> showlist()
{
	List<Mycart> list = new ArrayList<Mycart>();
	String logid=Controller.getLogid();
	list.addAll(cartDAO.getallcartdetails(logid));
	return list;

}
@Transactional
@RequestMapping("/addtocart")
public ModelAndView savecart(@ModelAttribute Mycart mycart,@RequestParam("pid")String productid)
{	
	if(Controller.getLogid()==null)
	{
		ModelAndView mv  = new ModelAndView("forward:/login");
		return mv;
	}
	else
	{
	String id=Controller.getLogid();
	
	productmodel productmodel = productDAO.getproductbyid(productid);
	mycart.setId(ThreadLocalRandom.current().nextInt(100, 1000000 + 1));
	mycart.setProduct_id(productmodel.getPid());
	mycart.setDate_added(today);
	mycart.setPrice(productmodel.getCost());
	mycart.setProductname(productmodel.getPname());
	mycart.setQuantity(1);
	mycart.setStatus("N");
	mycart.setUser_id(id);
	mycart.setSum(cartDAO.getsum(mycart.getPrice(),mycart.getQuantity()));
	cartDAO.save(mycart);
	List<Mycart> list= showlist();
	ModelAndView mv= new ModelAndView("forward:/mycart");
	mv.addObject("showcartlist", list);
		return mv;
	}
}

@Transactional
@RequestMapping("/deletecart")
public ModelAndView deletecart(@RequestParam("id")int id)
{
	Mycart mycart= cartDAO.getbyid(id);
	cartDAO.delete(mycart);
	ModelAndView mv=new ModelAndView("forward:/mycart");
	return mv;
	
}

@Transactional
@RequestMapping("mycart")
public ModelAndView showmycart()
{	String id= Controller.getLogid();
	List<Mycart> list=showlist();
	ModelAndView mv= new ModelAndView("/Mycart");
	mv.addObject("showcartlist",list);
	double total=cartDAO.gettotal(id);
	System.out.println(total);
	mv.addObject("carttotal", total);
	return mv;
}

@Transactional
@RequestMapping("/increaseqty")
public ModelAndView increasequantity(@RequestParam("id")int id)
{
	Mycart mycart=cartDAO.getbyid(id);
	int qty=mycart.getQuantity();
	qty=qty+1;
	mycart.setQuantity(qty);
	mycart.setSum(cartDAO.getsum(mycart.getPrice(),mycart.getQuantity()));
	cartDAO.update(mycart);
	ModelAndView mv=new ModelAndView("forward:/mycart");
	return mv;
}
@Transactional
@RequestMapping("/decreaseqty")
public ModelAndView decreasequantity(@RequestParam("id")int id)
{
	
	Mycart mycart=cartDAO.getbyid(id);
	int qty=mycart.getQuantity();
	if(qty<=1)
	{
		 ModelAndView mv1= new ModelAndView("forward:/mycart");
		return mv1;
	}
	qty=qty-1;
	mycart.setQuantity(qty);
	mycart.setSum(cartDAO.getsum(mycart.getPrice(),mycart.getQuantity()));
	cartDAO.update(mycart);
	ModelAndView mv=new ModelAndView("forward:/mycart");
	return mv;
}
}