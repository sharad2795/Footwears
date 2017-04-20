package com.sharad.Footwears.DAO;

import java.util.List;

import com.sharad.Footwears.modal.Category;

public interface CategoryDAO 
{
	public List<Category> list();
	
	public boolean save(Category category);
	
	public boolean update(Category category);
	
	public boolean delete(Category category);
	

	
	public Category getcategorybyid(String id);
	
	public Category getcategorybyname(String name);

}
