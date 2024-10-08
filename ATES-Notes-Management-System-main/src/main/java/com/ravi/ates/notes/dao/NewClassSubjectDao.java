package com.ravi.ates.notes.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.ravi.ates.notes.helper.FactoryProvider;
import com.ravi.ates.notes.model.NewClass;
import com.ravi.ates.notes.model.NewClassSubject;

public class NewClassSubjectDao {
	private SessionFactory factory;

	public NewClassSubjectDao(SessionFactory factory) {
		super();
		this.factory = factory;
	}
	
	public void saveNewClassSubjectDetail(NewClassSubject newClassSubjectObj) {
		try {
			Session ses=this.factory.openSession();
			Transaction tx=ses.beginTransaction();
			
		    ses.save(newClassSubjectObj);
			tx.commit();
			
			ses.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public List<NewClassSubject> getSubjectList()
	{
		Session ses=this.factory.openSession();
		Query query=ses.createQuery("from NewClassSubject");
		List<NewClassSubject> list=query.list();
		return list;
	}
	
	public List<NewClassSubject> getSubjectsByClassId(long classId) {
		
		try {
			Session ses=this.factory.openSession();
			Query query=ses.createQuery("from com.ravi.ates.notes.model.NewClassSubject subject where newClassObj ="+classId);
			List<NewClassSubject> list=query.list();
			
			for(NewClassSubject sub: list) {
				System.out.println(sub.getSubjectName());
			}
			return list;		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
				
	}
	
	public NewClassSubject getClassSubjectById(long classSubjectId) {
		NewClassSubject newClassSubjectObj=null;
		try {
			Session ses=FactoryProvider.getFactory().openSession();
			newClassSubjectObj=ses.get(NewClassSubject.class, classSubjectId);
			ses.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return newClassSubjectObj;
	}


}
