package com.sharad.Footwears.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sharad.Footwears.DAO.CartDAO;
import com.sharad.Footwears.DAO.CheckoutDAO;
import com.sharad.Footwears.modal.Checkout;
import com.sharad.Footwears.modal.Mycart;

@Controller
public class CheckoutController 
{
@Autowired
Checkout checkout;
@Autowired
CheckoutDAO checkoutDAO;
@Autowired
com.sharad.Footwears.controller.Controller controller;
@Autowired
Mycart mycart;
@Autowired
CartDAO cartdao;
@Transactional
public List<Checkout> showlist()
{
	String id= controller.getLogid();

	List<Checkout> list= new ArrayList<Checkout>();
	list.addAll(checkoutDAO.getlist(id));
	return list;
}

@Transactional
@RequestMapping("/checkout")
public ModelAndView gocheckout()
{
	
	String id= controller.getLogid();
	checkout.setUser_id(id);

	String idresult=checkoutDAO.checktableforempty(id);
	if(idresult=="0")
	{
		ModelAndView mv1= new ModelAndView("/checkout","command", new Checkout());
		return mv1;
	}
	else
	{
		ModelAndView mv=new ModelAndView("/checkoutdetails","command",new Checkout());
		List<Checkout> list=showlist();
		mv.addObject("printdetails", list);
		return mv;
		
	}
		
	
}
@Transactional
@RequestMapping("/finalcheckout")
public ModelAndView gotoaddcheckout(@ModelAttribute Checkout checkout)
{
	String id= controller.getLogid();
	checkout.setUser_id(id);
	checkout.setId(ThreadLocalRandom.current().nextInt(100, 1000000 + 1));
	checkoutDAO.Save(checkout);
	ModelAndView mv=new ModelAndView("/checkoutdetails","command",new Checkout());
	List<Checkout> list=showlist();
	mv.addObject("printdetails", list);
	return mv;
}

@Transactional
@RequestMapping("/generatebill")
public ModelAndView generatebill()
{
	String id= controller.getLogid();
	boolean b=checkoutDAO.execute(id);
	List<Mycart>list=checkoutDAO.getallcartdetails(id);
	List<Checkout> list1=checkoutDAO.getlist(id);
	ModelAndView mv= new ModelAndView("/generatebilldetails");
	mv.addObject("cartdetails",list);
	mv.addObject("checkoutdetails", list1);
	double total=checkoutDAO.gettotal(id);
	mv.addObject("checkouttotal", total);
	
	return mv;
}

}
