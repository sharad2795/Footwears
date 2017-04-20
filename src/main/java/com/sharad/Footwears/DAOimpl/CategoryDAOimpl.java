package com.sharad.Footwears.DAOimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.sharad.Footwears.DAO.CategoryDAO;
import com.sharad.Footwears.modal.Category;
@Repository("categoryDAO")
@EnableTransactionManagement
public class CategoryDAOimpl implements CategoryDAO {
	private SessionFactory sessionfactory;
	
	public CategoryDAOimpl(SessionFactory sessionFactory) 
	{
		this.sessionfactory = sessionFactory;
	}

	public List<Category> list() 
	{
		return sessionfactory.getCurrentSession().createQuery("from Category").list();	
	}
	@Transactional
	public boolean save(Category category) 
	{
		System.out.println("inside savecategory");
		try 
		{
			System.out.println("insidetry");
			sessionfactory.getCurrentSession().save(category);
			System.out.println("after session");
			return true;
		} catch (Exception e) 
		{
			
			e.printStackTrace();
			return false;
		}

	}

	public boolean update(Category category) 
	{
		try {
			sessionfactory.getCurrentSession().update(category);
		return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean delete(Category category) 
	{
		try {
			sessionfactory.getCurrentSession().delete(category);
			return true;
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
		
	}

	public Category getcategorybyid(String id)
		{
		
			return (Category) sessionfactory.getCurrentSession().get(Category.class, id);
		
		
		}

	public Category  getcategorybyname(String name) 
	{
		return (Category) sessionfactory.getCurrentSession().createQuery("from Category where name='"+name+"'").uniqueResult();
	}

}
