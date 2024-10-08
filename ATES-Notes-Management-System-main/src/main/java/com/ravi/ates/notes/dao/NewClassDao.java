package com.ravi.ates.notes.dao;

import java.util.List;
import java.util.Locale.Category;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.ravi.ates.notes.helper.FactoryProvider;
import com.ravi.ates.notes.model.NewClass;


public class NewClassDao {
	
	private SessionFactory factory;

	public NewClassDao(SessionFactory factory) {
		super();
		this.factory = factory;
	}
	
	public void saveNewClassDetail(NewClass newClassObj) {
		try {
			Session ses=this.factory.openSession();
			Transaction tx=ses.beginTransaction();
			
		    ses.save(newClassObj);
			tx.commit();
			
			ses.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public List<NewClass> getNewClasses()
	{
		Session ses=this.factory.openSession();
		Query query=ses.createQuery("from NewClass");
		List<NewClass> list=query.list();
		return list;
	}
	
	public NewClass getNewClassById(long classId) {
		NewClass newClassObj=null;
		try {
			Session ses=FactoryProvider.getFactory().openSession();
			newClassObj=ses.get(NewClass.class, classId);
			ses.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return newClassObj;
	}

}
