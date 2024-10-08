package com.ravi.ates.notes.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.ravi.ates.notes.helper.FactoryProvider;
import com.ravi.ates.notes.model.Documentations;
import com.ravi.ates.notes.model.NewClass;
import com.ravi.ates.notes.model.NewClassSubject;

public class DocumentationDao {
	
	private SessionFactory factory;

	public DocumentationDao(SessionFactory factory) {
		super();
		this.factory = factory;
	}
	
	public void saveDocumentsDetail(Documentations documentations) {
		try {
			Session ses=this.factory.openSession();
			Transaction tx=ses.beginTransaction();
			
		    ses.saveOrUpdate(documentations);
			tx.commit();
			
			ses.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//Update Document
	public void updateDocumentsDetail(Documentations documentations) {
		try {
			Session ses=this.factory.openSession();
			Transaction tx=ses.beginTransaction();
			
		    ses.update(documentations);
			tx.commit();
			
			ses.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	// To Get the All Document List
	public List<Documentations> getDocumentationsList()
	{
		Session ses=this.factory.openSession();
		Query query=ses.createQuery("from "+Documentations.class.getName());
		List<Documentations> list=query.list();
		return list;
	}
	
	// To Get The All Document List By User Id
	public List<Documentations> getDocumentationsListByUserId(long userId)
	{
		Session ses=this.factory.openSession();
		Query query=ses.createQuery("from "+Documentations.class.getName()+" where userId="+userId);
		List<Documentations> list=query.list();
		return list;
	}
	
	
	// Get Question Paper Details by own id
	public Documentations getDocumentById(long docId) {
		Documentations documentObj=null;
		try {
			Session ses=FactoryProvider.getFactory().openSession();
			documentObj=ses.get(Documentations.class, docId);
			ses.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return documentObj;
	}
	
	// Get Question Paper Details by subject id
   public List<Documentations> getQuestionPapersByClassSubjectId(long classSubjectId) {
		
		try {
			Session ses=this.factory.openSession();
			Query query=ses.createQuery("from com.ravi.ates.notes.model.Documentations  where newsubject ="+classSubjectId+" and docType='Question Paper Set'");
			List<Documentations> list=query.list();
			
			for(Documentations questionPaper: list) {
				System.out.println(questionPaper.getTitle());
			}
			return list;		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
				
	}
   
// Get Class Notes Details by subject id
   public List<Documentations> getClassNotesByClassSubjectId(long classSubjectId) {
		System.out.println("Class notes method call..");
		try {
			Session ses=this.factory.openSession();
			Query query=ses.createQuery("from com.ravi.ates.notes.model.Documentations  where newsubject ="+classSubjectId+" and docType='Class Notes'");
			List<Documentations> list=query.list();
			
			return list;		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
				
	}
   
// Get Latest Class Notes Details By Date Desc
   public List<Documentations> getLatestUploadedClassNotes() {
		System.out.println("Latest Uploaded Class notes method call..");
		try {
			Session ses=this.factory.openSession();
			Query query=ses.createQuery("from com.ravi.ates.notes.model.Documentations doc  where doc.docType='Class Notes' order by doc.uplodedDate desc ");
			List<Documentations> list=query.list();
			
			return list;		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
				
	}
   
// Get Latest Class Question Paper Details By Date Desc
   public List<Documentations> getLatestUploadedClassQuestionPaper() {
		System.out.println("Latest Uploaded Class Question Paper method call..");
		try {
			Session ses=this.factory.openSession();
			Query query=ses.createQuery("from com.ravi.ates.notes.model.Documentations doc  where doc.docType='Question Paper Set' order by doc.uplodedDate desc ");
			List<Documentations> list=query.list();
			
			return list;		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
				
	}
   
   public void deleteDataById(long id) {
	   try {
			Session ses=this.factory.openSession();
			Transaction tx=ses.beginTransaction();
			
			 Documentations doc=new Documentations();
			 doc.setId(id);
		    ses.delete(doc);
			tx.commit();
			
			ses.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
   }

}
