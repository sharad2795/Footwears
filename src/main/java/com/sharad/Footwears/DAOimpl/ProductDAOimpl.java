package com.sharad.Footwears.DAOimpl;

import java.util.List;

import org.h2.engine.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.sharad.Footwears.DAO.ProductDAO;
import com.sharad.Footwears.modal.productmodel;

@Repository("productDAO")
@EnableTransactionManagement
public class ProductDAOimpl implements ProductDAO 
{
	@Autowired
	private SessionFactory sessionfactory;
	
	public ProductDAOimpl(SessionFactory sessionfactory)
	{
		this.sessionfactory=sessionfactory;
	}
	
	public List<productmodel> getallproduct() 
	{
		return sessionfactory.getCurrentSession().createQuery("from productmodel").list();
	}

	public boolean Save(productmodel productmodel ) 
	{
		try {
			sessionfactory.getCurrentSession().save(productmodel);
			return true;
			} catch (Exception e) 
				{
				e.printStackTrace();
				return false;
				}
		
	}
	public boolean update(productmodel productmodel)
	{
		System.out.println("insideupdate");
		try {
			System.out.println("insidetryabovesession");
			sessionfactory.getCurrentSession().update(productmodel);
			System.out.println(productmodel.getPid());
			System.out.println("aftersession");
			return true;
			} catch (Exception e) 
		{
				return false;
		}
		
		
	}
	
	
	public boolean delete(productmodel productmodel) 
	{
		try {
			sessionfactory.getCurrentSession().delete(productmodel);
			return true;
		} catch (Exception e) {
			
			return false;
		}
			
	}
	
	


	public productmodel getproductbyid(String id) 
	{
		return (productmodel) sessionfactory.getCurrentSession().get(productmodel.class, id);
		
	}

	public List<productmodel> getproductbyname(String name)
	{
		return sessionfactory.getCurrentSession().createQuery("from productmodel").list();
	}

}
