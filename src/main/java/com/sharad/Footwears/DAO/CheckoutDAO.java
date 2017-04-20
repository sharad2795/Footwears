package com.sharad.Footwears.DAO;

import java.util.List;

import com.sharad.Footwears.modal.Checkout;
import com.sharad.Footwears.modal.Mycart;

public interface CheckoutDAO 
{
public List<Checkout> getlist(String user_id);
	
	public boolean Save(Checkout checkout);
	
	public boolean update(Checkout checkout);
	
	public boolean delete(Checkout checkout);
	
	public String checktableforempty(String user_id);
	
	public List<Mycart> getallcartdetails(String id);
	
	public double gettotal(String uid);
	
	public Boolean execute(String user_id);

}
