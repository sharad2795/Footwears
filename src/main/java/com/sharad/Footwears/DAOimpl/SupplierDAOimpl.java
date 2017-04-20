package com.sharad.Footwears.DAOimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.sharad.Footwears.DAO.SupplierDAO;
import com.sharad.Footwears.modal.Category;
import com.sharad.Footwears.modal.Supplier;

@Repository
@EnableTransactionManagement
public class SupplierDAOimpl implements SupplierDAO
{
	private SessionFactory sessionfactory;
	
	public SupplierDAOimpl(SessionFactory sessionfactory)
	{
		this.sessionfactory=sessionfactory;
	}
	
	public List<Supplier> getallsupplier() 
	{
		return sessionfactory.getCurrentSession().createQuery("from Supplier").list();
	}

	public boolean save(Supplier supplier) 
	{
		try {
			 sessionfactory.getCurrentSession().save(supplier);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Supplier supplier) 
	{
		try {
			 sessionfactory.getCurrentSession().update(supplier);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Supplier supplier) 
	{
		try {
			 sessionfactory.getCurrentSession().delete(supplier);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Supplier getsupplierbyid(String id)
	{
		return (Supplier) sessionfactory.getCurrentSession().get(Supplier.class, id);
	}

	public Supplier getsupplierbyname(String name) 
	{
		return (Supplier) sessionfactory.getCurrentSession().createQuery("from Supplier where name='"+name+"'").uniqueResult();
	}
}
