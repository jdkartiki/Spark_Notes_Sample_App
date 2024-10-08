package com.ravi.ates.notes.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ravi.ates.notes.helper.FactoryProvider;
import com.ravi.ates.notes.model.Documentations;
import com.ravi.ates.notes.model.NewClass;
import com.ravi.ates.notes.model.NewClassSubject;

public class RemoveDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public RemoveDataServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		
		
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id=request.getParameter("id");
		String type=request.getParameter("type");
		String fromPage=request.getParameter("frompage");
		
		System.out.println(id+" : "+type);
		
		Session ses=FactoryProvider.getFactory().openSession();
		Transaction tx=ses.beginTransaction();
		
		if(type.equalsIgnoreCase("doc")) {
			try {
				Documentations document=new Documentations();
				document.setId(Long.parseLong(id));
				ses.delete(document);
				tx.commit();
				ses.close();
				
				HttpSession  httpSession=request.getSession();
				httpSession.setAttribute("message", "Document Data Deleted");
				httpSession.setAttribute("msgStatus", "success");
				
				if(fromPage.equalsIgnoreCase("adminpage"))
					  response.sendRedirect("admin.jsp");
					else
						if(fromPage.equalsIgnoreCase("mainpage"))
							response.sendRedirect("my_notes_or_question_paper.jsp");
				
				return;
			}
			catch(Exception e) {
				e.printStackTrace();
				tx.rollback();
				
				HttpSession  httpSession=request.getSession();
				httpSession.setAttribute("message", " Something Error");
				httpSession.setAttribute("msgStatus", "error");
				
				if(fromPage.equalsIgnoreCase("adminpage"))
					response.sendRedirect("admin.jsp");
				else
					if(fromPage.equalsIgnoreCase("mainpage"))
						response.sendRedirect("my_notes_or_question_paper.jsp");
			}
			
		}
		else
			if(type.equalsIgnoreCase("subject")) {
				try {
					NewClassSubject subject= new NewClassSubject();
					subject.setId(Long.parseLong(id));
					ses.delete(subject);
					tx.commit();
					ses.close();
					System.out.println("Success Delete Subject");
					
					HttpSession  httpSession=request.getSession();
					httpSession.setAttribute("message", "Subject Data Deleted");
					httpSession.setAttribute("msgStatus", "success");
					
					if(fromPage.equalsIgnoreCase("adminpage"))
					  response.sendRedirect("admin.jsp");
					else
						if(fromPage.equalsIgnoreCase("mainpage"))
							response.sendRedirect("my_notes_or_question_paper.jsp");
					return;
				}
				catch(Exception e) {
					e.printStackTrace();
					tx.rollback();
					System.out.println("Error :"+e);
					HttpSession  httpSession=request.getSession();
					httpSession.setAttribute("message", " Something Error");
					httpSession.setAttribute("msgStatus", "error");
					
					if(fromPage.equalsIgnoreCase("adminpage"))
						response.sendRedirect("admin.jsp");
					else
						if(fromPage.equalsIgnoreCase("mainpage"))
							response.sendRedirect("my_notes_or_question_paper.jsp");
				}
				
			}
			else
				if(type.equalsIgnoreCase("class")) {
					try {
						NewClass classObj= new NewClass();
						classObj.setId(Long.parseLong(id));
						ses.delete(classObj);
						tx.commit();
						ses.close();
						
						HttpSession  httpSession=request.getSession();
						httpSession.setAttribute("message", "Class Data Deleted");
						httpSession.setAttribute("msgStatus", "success");
						response.sendRedirect("admin.jsp");
						return;
					}
					catch(Exception e) {
						e.printStackTrace();
						tx.rollback();
						
						HttpSession  httpSession=request.getSession();
						httpSession.setAttribute("message", " Something Error");
						httpSession.setAttribute("msgStatus", "error");
						
						if(fromPage.equalsIgnoreCase("adminpage"))
							response.sendRedirect("admin.jsp");
						else
							if(fromPage.equalsIgnoreCase("mainpage"))
								response.sendRedirect("my_notes_or_question_paper.jsp");
					}
					
				}
		
	}

}
