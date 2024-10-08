package com.ravi.ates.notes.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Transaction;

import com.ravi.ates.notes.dao.UserDao;
import com.ravi.ates.notes.helper.FactoryProvider;
import com.ravi.ates.notes.model.User;

public class ResetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ResetPasswordServlet() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		String operation=request.getParameter("passOperation");
		UserDao userDao=new UserDao(FactoryProvider.getFactory());
		
		
		if(operation.trim().equalsIgnoreCase("check_ans")){
			
			//Fetching data from user 
			String userEmail=request.getParameter("email");
			String userAns=request.getParameter("ans");
			
			//Authentication        
	        User user=(User)userDao.checkEmailAndAnswer(userEmail, userAns);
	        
	        
	        if(user==null) {
	        	HttpSession  httpSession=request.getSession();
				httpSession.setAttribute("message", "Invalid Email-Id Or Answer");
				httpSession.setAttribute("msgStatus", "error");
				response.sendRedirect("forgot_password.jsp");
				return; 
	        }
	        else {
	        	
	        	System.out.println("user :"+user.getUserFullName());
	        	System.out.println("user type :"+user.getUserType());
	        	
	        	response.sendRedirect("reset_password.jsp?id="+user.getUserId());	        		        	  	  	
	       }
		}
		else
			if(operation.trim().equalsIgnoreCase("update_password")) {
				String newPassword= request.getParameter("userpwd2");
				System.out.println(newPassword);
				int userId=Integer.parseInt(request.getParameter("id"));
				
				int i= userDao.updateUserPassword(userId, newPassword);
				
				if(i==0) {
					HttpSession  httpSession=request.getSession();
					httpSession.setAttribute("message", "Invalid Email-Id Or Answer");
					httpSession.setAttribute("msgStatus", "error");
					response.sendRedirect("forgot_password.jsp");
					return;
				}
				else {
					System.out.println("Success Update Password");
					
					HttpSession  httpSession=request.getSession();
					httpSession.setAttribute("message", "New Password Updated");
					httpSession.setAttribute("msgStatus", "success");
					
					response.sendRedirect("login.jsp");
					return;
				}
				
			}
			else
				if(operation.trim().equalsIgnoreCase("updateProfile")) {
					String fullName= request.getParameter("uname");
					String password=request.getParameter("upwd");
					int userId=Integer.parseInt(request.getParameter("userId"));
					int admissionYear= Integer.parseInt(request.getParameter("uadmiss"));
					
					int i= userDao.updateUserProfile(userId, fullName, admissionYear, password);
					
					if(i==0) {
						HttpSession  httpSession=request.getSession();
						httpSession.setAttribute("message", "Something Went Wrong");
						httpSession.setAttribute("msgStatus", "error");
						response.sendRedirect("update_user_profile.jsp");
						return;
					}
					else {
						System.out.println("Success Update Password");
						
						HttpSession  httpSession=request.getSession();
						httpSession.setAttribute("message", "Profile Updated");
						httpSession.setAttribute("msgStatus", "success");
						
						response.sendRedirect("update_user_profile.jsp");
						return;
					}
					
				}
	}

}
