package com.sharad.Footwears.DAOimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.sharad.Footwears.DAO.CartDAO;
import com.sharad.Footwears.modal.Mycart;
@Repository("cartDAO")
@EnableTransactionManagement
public class CartDAOimpl  implements CartDAO
{
	private SessionFactory sessionFactory;
	
	public CartDAOimpl(SessionFactory sessionfactory)
	{
		this.sessionFactory=sessionfactory;
	}
	

	public List<Mycart> getallcartdetails(String id)
	{
			return sessionFactory.getCurrentSession().createQuery("from Mycart where user_id='"+id+"' and status='N'").list();
			
	
	}

	public boolean save(Mycart mycart) 
	{
	
	 try {
		sessionFactory.getCurrentSession().save(mycart);
		 return true;
	 	} catch (Exception e) {
		e.printStackTrace();
		
		return false;
	}
	
	
}

	public boolean update(Mycart mycart) 
	{
		try {
			sessionFactory.getCurrentSession().update(mycart);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
	}

	public boolean delete(Mycart mycart) 
	{
		try {
			sessionFactory.getCurrentSession().delete(mycart);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	
	}

	

	public Mycart getbyname(String name) 
	{
		
		return (Mycart) sessionFactory.getCurrentSession().createQuery("from Mycart where name='"+name+"'").list();
		
	}


	public Mycart getbyid(int id) 
	{
	
		return (Mycart) sessionFactory.getCurrentSession().get(Mycart.class,id)	;
	}


	public double getsum(double price, int quantity)
	{
		return price*quantity;
	}
			
	public double gettotal(String uid)
	{
		String result=sessionFactory.getCurrentSession().createSQLQuery("select isnull(sum(cartsum),0) from mycart where user_id='"+uid+"' and status='N'").uniqueResult().toString();
		double total=Double.parseDouble(result);
		return total;
	}
	

}
