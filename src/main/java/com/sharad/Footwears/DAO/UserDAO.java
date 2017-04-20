package com.sharad.Footwears.DAO;

import java.util.List;

import com.sharad.Footwears.modal.User;

public interface UserDAO
{
	public List<User> list();
	
	public boolean save(User user);
	
	public boolean update(User user);
	
	public  boolean delete(User user);
	
	public User getuserbyid(String id);
	
	public List<User> getuserbyname(String name);
	
	public User validateuserlogin(String id, String password);
	
}

	
	
	
