package com.ravi.ates.notes.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.ravi.ates.notes.model.NewClass;
import com.ravi.ates.notes.model.NewClassSubject;

public class GetSubjectNameByClassDao {

	private SessionFactory factory;

	public GetSubjectNameByClassDao(SessionFactory factory) {
		super();
		this.factory = factory;
	}


	public List<NewClass> getNewClasses()
	{
		Session ses=this.factory.openSession();
		Query query=ses.createQuery("from NewClass");
		List<NewClass> list=query.list();
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


}
