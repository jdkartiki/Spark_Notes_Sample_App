package com.ravi.ates.notes.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.ravi.ates.notes.dao.DocumentationDao;
import com.ravi.ates.notes.dao.NewClassDao;
import com.ravi.ates.notes.dao.NewClassSubjectDao;
import com.ravi.ates.notes.helper.FactoryProvider;
import com.ravi.ates.notes.model.Documentations;
import com.ravi.ates.notes.model.NewClass;
import com.ravi.ates.notes.model.NewClassSubject;



@MultipartConfig(maxFileSize = 52428800)  //we set max size of 50 MB
public class OperationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OperationServlet() {
        super();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	try {
    		
    		response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			
			String operation=request.getParameter("operation");
			
			//****To check which operation come for operation
			if(operation.trim().equals("addClass")) 
			{
				
				// To Fetch data from admin panel and store data
				String className=request.getParameter("className");
				String classYear=request.getParameter("classYear");
				
				NewClass classObj=new NewClass();
				classObj.setClassName(className);
				classObj.setClassYear(classYear);
				
				//New Class Details database save
				NewClassDao newClassDao=new NewClassDao(FactoryProvider.getFactory());
				newClassDao.saveNewClassDetail(classObj);
				System.out.println("New Class Details Added :");
				
				HttpSession  httpSession=request.getSession();
				httpSession.setAttribute("message", "New Class Details Added");
				httpSession.setAttribute("msgStatus", "success");
				
				response.sendRedirect("admin.jsp");
				return;
			}else
				//****To check which operation come for operation
				if(operation.trim().equals("addClassSubject")) 
				{
					
					// To Fetch data from Admin panel and store data
					String classSubjectName=request.getParameter("classSubjectName");
					String classSubjectDesc=request.getParameter("classDescription");
					long classNameRef=Long.parseLong(request.getParameter("classId"));
					
					NewClassSubject classSubjectObj=new NewClassSubject();
					classSubjectObj.setSubjectName(classSubjectName);
					classSubjectObj.setDescription(classSubjectDesc);
					
					//First we get the object of class by using id
					NewClassDao newClassDao=new NewClassDao(FactoryProvider.getFactory());
					NewClass newClassObj=newClassDao.getNewClassById(classNameRef);
					
					classSubjectObj.setNewClassObj(newClassObj);
					
					System.out.println(newClassObj);
					
					NewClassSubjectDao newClassSubjectDao=new NewClassSubjectDao(FactoryProvider.getFactory());
					newClassSubjectDao.saveNewClassSubjectDetail(classSubjectObj);
					
					System.out.println("New Class Subject  Added :");
					
					HttpSession  httpSession=request.getSession();
					httpSession.setAttribute("message", "New Class Subject Details Added");
					httpSession.setAttribute("msgStatus", "success");
					
					response.sendRedirect("admin.jsp");
					return;
				}
				else
					if(operation.trim().equals("addNotesOrQuestionSet")) {
						
						//To Fetching data from Admin Panel or JSP page and store data
						String requestFromPage=request.getParameter("pageFindForReponse");
						String notesTitle=request.getParameter("notesTitle");
						String notesDesc=request.getParameter("notesDesc");
						String classNameId=request.getParameter("classNameId");
						long classSubjectNameId=Long.parseLong(request.getParameter("classSubjectNameId"));
						String docTypeId=request.getParameter("docTypeId");
						String studName=request.getParameter("userName");
						long userId=Long.parseLong(request.getParameter("userId"));
						
						//To Fetching blog document from jsp file
						Part part=request.getPart("notesFiles");
						InputStream is=null;
						
						Documentations document=new Documentations();
						document.setTitle(notesTitle);
						document.setDescription(notesDesc);
						document.setDocType(docTypeId);
						document.setUserName(studName);
						document.setUserId(userId);
						
												
						//First we get the Subject Class object by subject id
						NewClassSubjectDao newSubjectDao=new NewClassSubjectDao(FactoryProvider.getFactory());
						NewClassSubject classSubject=newSubjectDao.getClassSubjectById(classSubjectNameId);
						
						//We set the subject class
						document.setNewsubject(classSubject);	
						
						if(part !=null) {
							is=part.getInputStream();
						}
						
						//Give the size of byte 
						byte[] data=new byte[is.available()];
						is.read(data);
						
						//To get the uploaded document type
						String uplodadDocType=part.getContentType();
											
						//To set the uploaded document
						document.setUploadedDocument(data);
						
						//To set the uploaded document type
						document.setUplodadDocType(uplodadDocType);		
						
						document.setFileName(part.getSubmittedFileName());
						
						DocumentationDao documentationDao=new DocumentationDao(FactoryProvider.getFactory());
						documentationDao.saveDocumentsDetail(document);
						
						HttpSession  httpSession=request.getSession();
						httpSession.setAttribute("message", "New "+docTypeId+" Added");
						httpSession.setAttribute("msgStatus", "success");
						
						if(requestFromPage.trim().equalsIgnoreCase("mainpage")) {
							response.sendRedirect("add_notes_question_paper.jsp");
						}else
							if(requestFromPage.trim().equalsIgnoreCase("adminPage")) {
								response.sendRedirect("admin.jsp");
							}
					}
					else
						if(operation.trim().equals("updateNotesOrQuestionSet")) {
							
							String requestFromPage=request.getParameter("pageFindForReponse");
							String notesTitle=request.getParameter("notesTitle");
							String notesDesc=request.getParameter("notesDesc");
							long id=Long.parseLong(request.getParameter("documentId"));
							String classNameId=request.getParameter("classNameId");
							long classSubjectNameId=Long.parseLong(request.getParameter("subjectNameId"));
							String docTypeId=request.getParameter("documentType");
							String studName=request.getParameter("userName");
							long userId=Long.parseLong(request.getParameter("userId"));
							
							System.out.println(notesTitle+"\n"+notesDesc);
							System.out.println(docTypeId);
							System.out.println(classNameId);
							
							
							
							//To Fetching blog document from jsp file
							Part part=request.getPart("notesFiles");
							InputStream is=null;
							
							Documentations document=new Documentations();
							document.setId(id);
							document.setTitle(notesTitle);
							document.setDescription(notesDesc);
							document.setDocType(docTypeId);
							document.setUserName(studName);
							document.setUserId(userId);
							document.setDocType(docTypeId);
							
													
							//First we get the Subject Class object by subject id
							NewClassSubjectDao newSubjectDao=new NewClassSubjectDao(FactoryProvider.getFactory());
							NewClassSubject classSubject=newSubjectDao.getClassSubjectById(classSubjectNameId);
							
							//We set the subject class
							document.setNewsubject(classSubject);	
							
							if(part !=null) {
								is=part.getInputStream();
							}
							
							//Give the size of byte 
							byte[] data=new byte[is.available()];
							is.read(data);
							
							//To get the uploaded document type
							String uplodadDocType=part.getContentType();
												
							//To set the uploaded document
							document.setUploadedDocument(data);
							
							//To set the uploaded document type
							document.setUplodadDocType(uplodadDocType);		
							
							document.setFileName(part.getSubmittedFileName());
							
							DocumentationDao documentationDao=new DocumentationDao(FactoryProvider.getFactory());
							documentationDao.updateDocumentsDetail(document);
							
							HttpSession  httpSession=request.getSession();
							httpSession.setAttribute("message", "Update Your Documentation");
							httpSession.setAttribute("msgStatus", "success");
							
							response.sendRedirect("my_notes_or_question_paper.jsp");
						
							
						}
    		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

}
