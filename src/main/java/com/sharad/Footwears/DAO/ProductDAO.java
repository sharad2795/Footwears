package com.sharad.Footwears.DAO;

import java.util.List;

import com.sharad.Footwears.modal.productmodel;

public interface ProductDAO
{
	public List<productmodel> getallproduct();
	
	public boolean Save(productmodel productmodel);
	
	public boolean update(productmodel productmodel);
	
	public boolean delete(productmodel productmodel);
	
	public productmodel getproductbyid(String id);//we use return type as product model bcoz it will return only one record
	
	public List<productmodel> getproductbyname(String name);// same as above
	

}
