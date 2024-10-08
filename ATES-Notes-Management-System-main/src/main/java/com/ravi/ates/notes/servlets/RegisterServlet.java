package com.ravi.ates.notes.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ravi.ates.notes.helper.FactoryProvider;
import com.ravi.ates.notes.model.User;


public class RegisterServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
    

    public RegisterServlet() {
        super();
     
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out=response.getWriter();
			response.setContentType("text/html");
			
			String nameId=request.getParameter("unameid");
			String password=request.getParameter("upwd");
			String fullname=request.getParameter("uname");
			String email=request.getParameter("uemail");			
			String mobile=request.getParameter("umobile");
			String addmyear=request.getParameter("uadmiss");
			String profilePic=request.getParameter("profilepic");
			String answer=request.getParameter("animalname");
			
			//validations
			if(nameId.isEmpty() || email.isEmpty() || password.isEmpty() || mobile.isEmpty() || profilePic.isEmpty() || answer.isEmpty() || addmyear.isEmpty() || fullname.isEmpty())
			{
				HttpSession  httpSession=request.getSession();
				httpSession.setAttribute("message", "Please fill the all the fields!");
				httpSession.setAttribute("msgStatus", "error");
				response.sendRedirect("Register.jsp");
				return; 
				
			}
			
			//creating user object to store data
			
			int addYear=Integer.parseInt(addmyear);
			User user=new User(nameId, password, fullname,  email,  mobile, addYear, "default.jpg", answer ,"normal");
			
			Session ses=FactoryProvider.getFactory().openSession();
			Transaction tx=ses.beginTransaction();
			
			ses.save(user);
			
			tx.commit();
			System.out.println("Data inserted...");
			ses.close();
			
			HttpSession  httpSession=request.getSession();
			httpSession.setAttribute("message", "Registration has been Successful...!");
			httpSession.setAttribute("msgStatus", "success");
			response.sendRedirect("Register.jsp");
			return;
							
		} catch (Exception e) {
			e.printStackTrace();
			HttpSession  httpSession=request.getSession();
			httpSession.setAttribute("message", "Something was wrong...Please try Again!");
			httpSession.setAttribute("msgStatus", "error");
			response.sendRedirect("Register.jsp");
		}
	}

}
