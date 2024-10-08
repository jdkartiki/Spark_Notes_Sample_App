package com.ravi.ates.notes.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ravi.ates.notes.dao.CountryStateDao;
import com.ravi.ates.notes.helper.FactoryProvider;
import com.ravi.ates.notes.model.NewClass;
import com.ravi.ates.notes.model.NewClassSubject;

/**
 * Servlet implementation class GetCountryStateservlet
 */
public class GetCountryStateservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	    @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        try (PrintWriter out = response.getWriter()) {

	            CountryStateDao csd = new CountryStateDao(FactoryProvider.getFactory());
	            
	            String op = request.getParameter("operation");
	            System.out.println("welcome bhai..");
	            
	            if (op.equals("classname")) {
	            	System.out.println("classname method called...");
	                List<NewClass> clist = csd.getNewClasses();
	                Gson json = new Gson();
	                String countryList = json.toJson(clist);
	                response.setContentType("text/html");
	                response.getWriter().write(countryList);
	            }

	            if (op.equals("subjectname")) {
	            	System.out.println("subject method called...");
	                long id = Long.parseLong(request.getParameter("id"));
	                List<NewClassSubject> slist = csd.getSubjectsByClassId(id);
	                Gson json = new Gson();
	                String countryList = json.toJson(slist);
	                response.setContentType("text/html");
	                response.getWriter().write(countryList);
	            }

//	            if (op.equals("city")) {
//	                int id = Integer.parseInt(request.getParameter("id"));
//	                List<City> citylist = csd.getCityByStateId(id);
//	                Gson json = new Gson();
//	                String countryList = json.toJson(citylist);
//	                response.setContentType("text/html");
//	                response.getWriter().write(countryList);
//	            }
	        }
	    }
	}
