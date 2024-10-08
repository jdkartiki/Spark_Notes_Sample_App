package com.ravi.ates.notes.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ravi.ates.notes.dao.UserDao;
import com.ravi.ates.notes.helper.FactoryProvider;
import com.ravi.ates.notes.model.User;



public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setContentType("text/html");
			
	        String email=request.getParameter("email");
	        String pass=request.getParameter("userpwd");
	        
	        //Check all fields fill or not
	        if(email.isEmpty() || pass.isEmpty()) {
	        	HttpSession  httpSession=request.getSession();
				httpSession.setAttribute("message", "Please fill the all the fields!");
				httpSession.setAttribute("msgStatus", "error");
				response.sendRedirect("login.jsp");
				return; 
	        }
	        
	        //Authentication
	        UserDao userDao=new UserDao(FactoryProvider.getFactory());
	        User user=(User)userDao.getUserByEmailAndPassword(email, pass);
	        
	        
	        if(user==null) {
	        	HttpSession  httpSession=request.getSession();
				httpSession.setAttribute("message", "Invalid Username or Password!");
				httpSession.setAttribute("msgStatus", "error");
				response.sendRedirect("login.jsp");
				return; 
	        }
	        else {
	        	
	        	System.out.println("user :"+user.getUserFullName());
	        	System.out.println("user type :"+user.getUserType());
	        	//Login for Administrator
	        	HttpSession httpSession=request.getSession();
	        	httpSession.setAttribute("current_user", user);
	        	
	        	if(user.getUserType().equals("admin")) {
	        		response.sendRedirect("index.jsp");
	        		return;
	        	}else
	        		//Login for Normal user
	        		if(user.getUserType().equalsIgnoreCase("normal"))
	        	{
	        		response.sendRedirect("index.jsp");
	        		return;
	        	}
	        	else //unexpected occur condition
	        	{
	        		response.sendRedirect("login.jsp");
	        		return; 
	        		
	        	}
	        	  	  	
	       }
	       
	      		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
