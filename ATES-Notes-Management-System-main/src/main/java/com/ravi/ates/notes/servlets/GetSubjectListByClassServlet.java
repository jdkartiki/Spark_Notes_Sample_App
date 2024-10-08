package com.ravi.ates.notes.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ravi.ates.notes.dao.GetSubjectNameByClassDao;
import com.ravi.ates.notes.helper.FactoryProvider;
import com.ravi.ates.notes.model.NewClass;
import com.ravi.ates.notes.model.NewClassSubject;

/**
 * Servlet implementation class GetSubjectListByClassServlet
 */
public class GetSubjectListByClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetSubjectListByClassServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		GetSubjectNameByClassDao subByClassDao=new GetSubjectNameByClassDao(FactoryProvider.getFactory());
		
		String userName = request.getParameter("userName").trim();
		if(userName == null || "".equals(userName)){
			userName = "Guest";
		}
		
		String greetings = "Hello " + userName;
		
		response.setContentType("text/plain");
		response.getWriter().write(greetings);
		
		
		String operation=request.getParameter("operation");
		
//		try {
//			System.out.println("Sbu called...");
//			
//			if (operation.equals("classlist")) {
//				
//				System.out.println("Class list called...");
//				List<NewClass> classList=subByClassDao.getNewClasses();
//				Gson json=new Gson();
//				String classList1=json.toJson(classList);
//				response.getWriter().write(classList1);
//            }
//					
//			if(operation.equals("sublist")) {
//				long id=Long.parseLong(request.getParameter("id"));
//				List<NewClassSubject> classList=subByClassDao.getSubjectsByClassId(id);
//				Gson json=new Gson();
//				String subjList=json.toJson(classList);
//				response.getWriter().write(subjList);
//				
//			}
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}         
		
	}

}
