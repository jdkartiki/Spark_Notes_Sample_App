package com.ravi.ates.notes.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.ravi.ates.notes.model.User;



public class UserDao {
	
	private SessionFactory factory;
    private Transaction tx=null;
	public UserDao(SessionFactory factory) {
		super();
		this.factory = factory;
	}
	
	//Get user by email and password
	public User getUserByEmailAndPassword(String email, String password)
	{
		User user=null;
		try {
			String hql="from "+User.class.getName()+" where userEmail=:e and userPassword=:p";
			Session ses= this.factory.openSession();
			Query query=ses.createQuery(hql);
			query.setParameter("e",email);
			query.setParameter("p", password);
			
		    user=(User)query.uniqueResult();
			
			ses.close();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}	
		return user;
	}
	
	//Get the All Details of Users
	public List<User> getAllData(){
		List<User> list=null;
		try {
			Session ses=this.factory.openSession();
			Query query=ses.createQuery("from "+User.class.getName());
			list=query.getResultList();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//Get User Data if Email Id And Answer are correct
	public User checkEmailAndAnswer(String email, String ans) {
		User user=null;
		try {
			Session ses= this.factory.openSession();
		    String hql="from "+User.class.getName()+"  where userEmail=:e and userAnswer=:a";
		    Query query=ses.createQuery(hql);
		    query.setParameter("e", email.trim());
		    query.setParameter("a", ans.trim());
		    
		    user=(User)query.uniqueResult();
		    ses.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return user;
	}
	
	//Update the User New Password By User ID
		public int updateUserPassword(int id, String password) {
			int i=0;
			
			try {
				System.out.println("id :"+id+" password :"+password);
				Session ses= this.factory.openSession();
				tx=ses.beginTransaction();
				
			    String hql="update User u set u.userPassword =:p where u.userId =:id";
			    Query query=ses.createQuery(hql);
			    query.setParameter("p", password.trim());
			    query.setParameter("id", id);
			    
			    i= query.executeUpdate();
			    System.out.println("i :"+i);
			    tx.commit();
			    ses.close();
				
				
			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			}
			
			return i;
		}
		
		//Update the User Profile
				public int updateUserProfile(int id, String fullName, int addYear, String password) {
					int i=0;
					
					try {
						System.out.println("id :"+id+" password :"+password);
						Session ses= this.factory.openSession();
						tx=ses.beginTransaction();
						
					    String hql="update User u set u.userPassword =:p, u.userFullName =:n , u.userAdmissionYear =:y where u.userId =:id";
					    Query query=ses.createQuery(hql);
					    query.setParameter("p", password.trim());
					    query.setParameter("id", id);
					    query.setParameter("n", fullName.trim());
					    query.setParameter("y", addYear);
					    
					    i= query.executeUpdate();
					    System.out.println("i :"+i);
					    tx.commit();
					    ses.close();
						
						
					} catch (Exception e) {
						e.printStackTrace();
						return 0;
					}
					
					return i;
				}

}
