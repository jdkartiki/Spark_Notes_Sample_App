package com.ravi.ates.notes.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.ravi.ates.notes.model.NewClass;
import com.ravi.ates.notes.model.NewClassSubject;


public class CountryStateDao {
   
    
	private SessionFactory factory;
    
    public CountryStateDao(SessionFactory factory) {
		super();
		this.factory = factory;
	}

//	public List<Country> getAllCountry(){
//		
//		Session ses=this.factory.openSession();
//		Query query=ses.createQuery("from "+Country.class.getName());
//	    List<Country> list=query.list();
//	    return list;
//    }
	
	public List<NewClass> getNewClasses()
	{
		Session ses=this.factory.openSession();
		Query query=ses.createQuery("from "+NewClass.class.getName());
		List<NewClass> list1=query.list();
		List<NewClass> list=new ArrayList<NewClass>();
		for(NewClass c: list1) {
			System.out.println(c.getClassName());
			NewClass class1=new NewClass();
			class1.setId(c.getId());
			class1.setClassName(c.getClassName());
			class1.setClassYear(c.getClassYear());
			list.add(class1);
		}
		return list;
	}

	public List<NewClassSubject> getSubjectsByClassId(long classId) {

		try {
			Session ses=this.factory.openSession();
			Query query=ses.createQuery("from com.ravi.ates.notes.model.NewClassSubject  where newClassObj ="+classId);
			List<NewClassSubject> list1=query.list();
			
			List<NewClassSubject> list=new ArrayList<NewClassSubject>();

			for(NewClassSubject sub: list1) {
				System.out.println(sub.getSubjectName());
				
				NewClassSubject subject=new NewClassSubject();
				subject.setId(sub.getId());
				subject.setSubjectName(sub.getSubjectName());
				
				list.add(subject);
			}
			return list;		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;

	}
    
//    public List<State> getStateByCountryId(int countryId){
//        List<State> list = new ArrayList<>();
//        try{
//        	
//        	Session ses=this.factory.openSession();
//			Query query=ses.createQuery("from com.ravi.ates.notes.model.State where countryId ="+countryId);
//		    list=query.list();
//
//			for(State sub: list) {
//				System.out.println(sub.getName());
//			}	
//        	
//        }catch(Exception e){
//            e.printStackTrace();
//        } 
//        return list;
//    }
//    
//    
//    public List<City> getCityByStateId(int stateId){
//        List<City> list = new ArrayList<>();
//        
//        try {
//        Session ses=this.factory.openSession();
//		Query query=ses.createQuery("from com.ravi.ates.notes.model.City where stateId ="+stateId);
//	    list=query.list();
//
//		for(City sub: list) {
//			System.out.println(sub.getName());
//		}	
//    	
//    }catch(Exception e){
//        e.printStackTrace();
//    } 
//    return list;
//        
//    }
}
