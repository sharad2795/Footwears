package com.sharad.Footwears.DAO;

import java.util.List;

import com.sharad.Footwears.modal.Category;
import com.sharad.Footwears.modal.Supplier;

public interface SupplierDAO 
{
	public List<Supplier> getallsupplier();
	
	public boolean save(Supplier supplier);
	
	public boolean update(Supplier supplier);
	
	public boolean delete(Supplier supplier);
	
public Supplier getsupplierbyid(String id);
	
	public Supplier getsupplierbyname(String name);
	
} 
	
	
	
	
	
	
	
	

