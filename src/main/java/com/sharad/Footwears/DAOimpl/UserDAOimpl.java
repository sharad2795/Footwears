package com.sharad.Footwears.DAOimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.sharad.Footwears.DAO.UserDAO;
import com.sharad.Footwears.modal.User;
@Repository("userDAO")
@EnableTransactionManagement
public class UserDAOimpl implements UserDAO
{
	private SessionFactory sessionfactory;
	
	private User user;
	
	
	public UserDAOimpl(SessionFactory sessionFactory)
	{
		this.sessionfactory=sessionFactory;
	}

	public List<User> list() 
	{
		return sessionfactory.getCurrentSession().createQuery("from User").list();
	
	
	}

	public boolean save(User user) 
	{
		try {
			sessionfactory.getCurrentSession().save(user);
			return true;
		} catch (HibernateException e) 
		{
			e.printStackTrace();
			return false;
		}
		
	
	}

	public boolean update(User user) {
		
	try {
		sessionfactory.getCurrentSession().update(user);
		return true;
		} catch (Exception e) {
		e.printStackTrace();
		return false;
		}
	
	
}

	public boolean delete(User user) 
	{

	try {
		sessionfactory.getCurrentSession().delete(user);
		return true;
		} catch (Exception e) 	
		{
		e.printStackTrace();
		return false;
		}
	}
	
	@Transactional
	public User getuserbyid(String id) 
	{
	
		return (User) sessionfactory.getCurrentSession().get(User.class, id);
		
		
	}

	public List<User> getuserbyname(String name) 
	{
		return sessionfactory.getCurrentSession().createQuery("from User where name='"+name+"'").list();
	}

	public User validateuserlogin(String id, String password) 
	{
		//FROM USER where userid = 'mj' and password='1234567'
		String hql =  "from User where userid = '"+id+"' and password='"+password+"'";
		return  (User) sessionfactory.getCurrentSession().createQuery(hql).uniqueResult();
	}
	
	
	
	
	
}
