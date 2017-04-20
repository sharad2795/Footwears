package com.sharad.Footwears.DAO;

import java.util.List;

import com.sharad.Footwears.modal.Mycart;

public interface CartDAO 
{
	
	public List<Mycart> getallcartdetails(String id);
	
	public boolean save(Mycart mycart);
	
	public boolean update(Mycart mycart);
	
	public boolean delete (Mycart mycart);
	
	public Mycart getbyid(int id);
	
	public Mycart getbyname(String name);
	
	public double getsum(double price, int quantity);
	
	public double gettotal(String uid);
	

	

}
