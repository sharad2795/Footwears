package com.sharad.Footwears.DAOimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.SQLUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.sharad.Footwears.DAO.CheckoutDAO;
import com.sharad.Footwears.modal.Checkout;
import com.sharad.Footwears.modal.Mycart;
@Repository("CheckoutDAO")
@EnableTransactionManagement
public class CheckoutDAOimpl implements CheckoutDAO
{
	@Autowired
	private SessionFactory sessionfactory;
	
	public List<Checkout> getlist(String user_id) 
	{
		return sessionfactory.getCurrentSession().createQuery("from Checkout where user_id='"+user_id+"'").list();
		
	}

	public boolean Save(Checkout checkout) 
	{
			
		try {
			sessionfactory.getCurrentSession().save(checkout);
			return true;
			} catch (Exception e) 
				{
				e.printStackTrace();
				return false;
				}
		}

	public boolean update(Checkout checkout) {
		try {
			sessionfactory.getCurrentSession().update(checkout);
			return true;
			} catch (Exception e) 
				{
				e.printStackTrace();
				return false;
				}
		}

	public boolean delete(Checkout checkout) 
	{
		try {
			sessionfactory.getCurrentSession().delete(checkout);
			return true;
			} catch (Exception e) 
				{
				e.printStackTrace();
				return false;
				}
	}

	public Boolean execute(String user_id)
	{
		try {
		 sessionfactory.getCurrentSession().createSQLQuery("update mycart set status='O' where user_id='"+user_id+"'").executeUpdate();
		return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public String checktableforempty(String user_id)	
	{
		return sessionfactory.getCurrentSession().createSQLQuery("select count(*) from checkout where user_id='"+user_id+"'").uniqueResult().toString();
	}

	public List<Mycart> getallcartdetails(String id)
	{
			return sessionfactory.getCurrentSession().createQuery("from Mycart where user_id='"+id+"'").list();
			
	
	}
	
	public double gettotal(String uid)
	{
		String result=sessionfactory.getCurrentSession().createSQLQuery("select isnull(sum(cartsum),0) from mycart where user_id='"+uid+"' and status='O'").uniqueResult().toString();
		double total=Double.parseDouble(result);
		return total;
	}


}
