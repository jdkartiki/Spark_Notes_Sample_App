/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.37
 * Generated at: 2023-12-29 11:09:04 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.SimpleDateFormat;
import com.ravi.ates.notes.model.User;
import com.ravi.ates.notes.dao.*;
import com.ravi.ates.notes.helper.*;
import com.ravi.ates.notes.model.*;
import java.util.List;

public final class my_005fnotes_005for_005fquestion_005fpaper_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/message.jsp", Long.valueOf(1649195032000L));
    _jspx_dependants.put("/navbar.jsp", Long.valueOf(1703843779110L));
    _jspx_dependants.put("/comm-css-javascript.jsp", Long.valueOf(1649195032000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("com.ravi.ates.notes.helper");
    _jspx_imports_packages.add("com.ravi.ates.notes.dao");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_packages.add("com.ravi.ates.notes.model");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("java.text.SimpleDateFormat");
    _jspx_imports_classes.add("com.ravi.ates.notes.model.User");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");

	User user = (User) session.getAttribute("current_user");
	String userName = null;
	Long selectedClassId = null;
	long userId;
	if (user == null) {
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("message", "Yor are not Logged in!!..Please Login!");
		httpSession.setAttribute("msgStatus", "error");
		response.sendRedirect("login.jsp");
		return;
	} else{
		userName=user.getUserName();
	    userId=user.getUserId();
	}
	
	 DocumentationDao documentationDao = new DocumentationDao(FactoryProvider.getFactory());
	 List<Documentations> docList=documentationDao.getDocumentationsListByUserId(userId);

      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"ISO-8859-1\">\n");
      out.write("<title>My Notes Or Question Paper</title>\n");
      out.write("\n");
      out.write("<!-- Bootstrap CSS -->\n");
      out.write("    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("<!-- BootStrap JavaScript  -->\n");
      out.write(" <!-- Option 1: Bootstrap Bundle with Popper -->\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.6.0.min.js\" integrity=\"sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=\" crossorigin=\"anonymous\"></script>\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p\" crossorigin=\"anonymous\"></script>\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://pro.fontawesome.com/releases/v5.10.0/css/all.css\" integrity=\"sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p\" crossorigin=\"anonymous\"/>\n");
      out.write(" <link rel=\"stylesheet\" href=\"css/styles.css\"/>\n");
      out.write(" \n");
      out.write(" \n");
      out.write(" <script src=\"sweetalert2.all.min.js\"></script>\n");
      out.write(" <link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/sweetalert2@10.10.1/dist/sweetalert2.min.css'>\n");
      out.write(" <script src=\"https://cdn.jsdelivr.net/npm/sweetalert2@10.10.1/dist/sweetalert2.all.min.js\"></script>\n");
      out.write(" \n");
      out.write(" <script type=\"text/javascript\" src=\"js/script.js\"></script>\n");
      out.write(" \n");
      out.write(" \n");
      out.write(" \n");
      out.write("    ");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write(" ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

   User userNav=(User)session.getAttribute("current_user");
   String user3=null;
   String userLink=null;
   if(userNav==null){}
   else{
	   user3=userNav.getUserType();
	   /**
	   if(user3.equals("admin")){
		   userLink="index.jsp";
	   }else
		   userLink="user.jsp";
	   */
   }
       

      out.write('\n');
      out.write('\n');


    NewClassDao newClassDao=new NewClassDao(FactoryProvider.getFactory());
    List<NewClass> newClassList= newClassDao.getNewClasses();


      out.write("\n");
      out.write("\n");
      out.write("<div class=\"border shadow mt-1 mb-5 rounded\">\n");
      out.write("\t<nav class=\"navbar navbar-expand-lg fixed-top navbar-dark\" style=\"background-color:#23415c\" >\n");
      out.write("\n");
      out.write("\t\t<div class=\"container2\">\n");
      out.write("\t\t\t<div>\n");
      out.write("\t\t\t\t<a class=\"navbar-brand fs-2 ms-3 fontMycart\" href=\"index.jsp\">HP's Notes</a>\n");
      out.write("\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t<div class=\"container-fluid\">\n");
      out.write("\t\t\t<div class=\"container me-4 ms-4 ml-auto\">\n");
      out.write("\t\t\t\t<button class=\"navbar-toggler\" type=\"button\"\n");
      out.write("\t\t\t\t\tdata-bs-toggle=\"collapse\" data-bs-target=\"#navbarSupportedContent\"\n");
      out.write("\t\t\t\t\taria-controls=\"navbarSupportedContent\" aria-expanded=\"false\"\n");
      out.write("\t\t\t\t\taria-label=\"Toggle navigation\">\n");
      out.write("\t\t\t\t\t<span class=\"navbar-toggler-icon\"></span>\n");
      out.write("\t\t\t\t</button>\n");
      out.write("\t\t\t\t<div class=\"collapse navbar-collapse \" id=\"navbarSupportedContent\">\n");
      out.write("\t\t\t\t\t<ul class=\"navbar-nav me-auto mb-2 mb-lg-0\">\n");
      out.write("\t\t\t\t\t\t<li class=\"nav-item fs-5\"><a class=\"nav-link active\"\n");
      out.write("\t\t\t\t\t\t\taria-current=\"page\" href=\"index.jsp\">Home</a></li>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t<li class=\"nav-item dropdown fs-5\"><a\n");
      out.write("\t\t\t\t\t\t\tclass=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\"\n");
      out.write("\t\t\t\t\t\t\trole=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">\n");
      out.write("\t\t\t\t\t\t\t\tQuestion Paper Set </a>\n");
      out.write("\t\t\t\t\t\t\t<ul class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\n");
      out.write("\t\t\t\t\t\t\t  ");

							    for(NewClass newClass: newClassList){
							  
							  
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t<li><a class=\"dropdown-item\" href=\"question_paper.jsp?classname=");
      out.print( newClass.getId());
      out.write('"');
      out.write('>');
      out.print( newClass.getClassName()+" ("+ newClass.getClassYear()+ " year)" );
      out.write("</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t");

							    }

                                 
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t</ul></li>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t<li class=\"nav-item dropdown fs-5\">\n");
      out.write("\t\t\t\t\t\t<a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\"\n");
      out.write("\t\t\t\t\t\t\trole=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">\n");
      out.write("\t\t\t\t\t\t\t\tClassroom Notes </a>\n");
      out.write("\t\t\t\t\t\t\t<ul class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\n");
      out.write("\t\t\t\t\t\t\t\t");

							    for(NewClass newClass: newClassList){
							  
							  
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t<li><a class=\"dropdown-item\" href=\"class_notes.jsp?classname=");
      out.print( newClass.getId() );
      out.write('"');
      out.write('>');
      out.print( newClass.getClassName()+" ("+ newClass.getClassYear()+ " year)" );
      out.write("</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t");

							    }

                                 
      out.write("\n");
      out.write("\t\t\t\t\t\t\t</ul></li>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\t<ul class=\"navbar-nav ml-auto\">\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t");

					      if(userNav==null){
					    
      out.write("\t \n");
      out.write("\t\t\t\t\t     \n");
      out.write("\t\t\t\t\t\t<li class=\"nav-item dropdown fs-5 ml-auto\"><a\n");
      out.write("\t\t\t\t\t\t\tclass=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\"\n");
      out.write("\t\t\t\t\t\t\trole=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">\n");
      out.write("\t\t\t\t\t\t\t\t Sign Up/Login </a>\n");
      out.write("\t\t\t\t\t\t\t<ul class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\n");
      out.write("\t\t\t\t\t\t\t\t<li><a class=\"dropdown-item \" href=\"Register.jsp\">Sign Up</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t<li><a class=\"dropdown-item\" href=\"login.jsp\">Log In</a></li>\n");
      out.write("\t\t\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t ");
	  
					      }
						 // we check the login user is a admin or not
					      else{
					    	  if(user3.equals("admin")){
					    
      out.write("\t\n");
      out.write("\t\t\t\t\t    \n");
      out.write("\t\t\t\t\t    <li class=\"nav-item fs-5\"><a class=\"nav-link \"\n");
      out.write("\t\t\t\t\t\t\taria-current=\"page\" href=\"add_notes_question_paper.jsp\">Add Notes/Question Paper</a></li>\n");
      out.write("\t\t\t\t\t    \n");
      out.write("\t\t\t\t\t     <li class=\"nav-item dropdown fs-5 ml-auto\"><a\n");
      out.write("\t\t\t\t\t\t\tclass=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\"\n");
      out.write("\t\t\t\t\t\t\trole=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">\n");
      out.write("\t\t\t\t\t\t\t\t ");
      out.print(userNav.getUserName() );
      out.write(" </a>\n");
      out.write("\t\t\t\t\t\t\t<ul class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\n");
      out.write("\t\t\t\t\t\t\t\t<li><a class=\"dropdown-item \" href=\"admin.jsp\">Admin Panel</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t<li><a class=\"dropdown-item \" href=\"my_notes_or_question_paper.jsp\">My Notes/QuestionPaper</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t<li><a class=\"dropdown-item\" href=\"LogOutServlet\">Log Out</a></li>\n");
      out.write("\t\t\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t    \n");
      out.write("\t\t\t\t\t    ");
	  
					      }
					    	  // we check the login user is a normal or not
					    	  else
					    		  if(user3.equals("normal")){
					    	
      out.write("\n");
      out.write("\t\t\t\t\t    \t\n");
      out.write("\t\t\t\t\t    \t<li class=\"nav-item fs-5\"><a class=\"nav-link \"\n");
      out.write("\t\t\t\t\t\t\taria-current=\"page\" href=\"add_notes_question_paper.jsp\">Add Notes/Question Paper</a></li>\n");
      out.write("\t\t\t\t\t    \t\n");
      out.write("\t\t\t\t\t    \t<li class=\"nav-item dropdown fs-5 ml-auto\"><a\n");
      out.write("\t\t\t\t\t\t\tclass=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\"\n");
      out.write("\t\t\t\t\t\t\trole=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">\n");
      out.write("\t\t\t\t\t\t\t\t ");
      out.print(userNav.getUserName() );
      out.write(" </a>\n");
      out.write("\t\t\t\t\t\t\t<ul class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\n");
      out.write("\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t<li><a class=\"dropdown-item \" href=\"update_user_profile.jsp\">Edit Profile</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t<li><a class=\"dropdown-item \" href=\"my_notes_or_question_paper.jsp\">My Notes/QuestionPaper</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t<li><a class=\"dropdown-item\" href=\"LogOutServlet\">Log Out</a></li>\n");
      out.write("\t\t\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\t\t   </li>\n");
      out.write("\t\t\t\t\t    \t\n");
      out.write("\t\t\t\t\t    \t\t\t  \n");
      out.write("\t\t\t\t\t    ");
			  
					    	  }
					      }
					    
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t<li class=\"nav-item fs-5 ml-auto\"><a class=\"nav-link \"\n");
      out.write("\t\t\t\t\t\t\taria-current=\"page\" href=\"about us.jsp\">About Us</a></li>\n");
      out.write("\n");
      out.write("\t\t\t\t\t</ul>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t</div>\n");
      out.write("\t</nav>\n");
      out.write("</div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<!-- \n");
      out.write("\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    $(docuent).ready(function(){\n");
      out.write("\n");
      out.write("        $('.navbar-nav').on('click','a', function(){\n");
      out.write("\n");
      out.write("            $('.navbar-nav a.active').removeClass('active');\n");
      out.write("            $(this).addClass('active');\n");
      out.write("\n");
      out.write("            })\n");
      out.write("\n");
      out.write("        })\n");
      out.write("\n");
      out.write("\n");
      out.write("  </script>\n");
      out.write("\n");
      out.write("\n");
      out.write(" -->\n");
      out.write("\n");
      out.write("\n");
      out.write(" <span class=\"m-1\"></span>\n");
      out.write("    <h4 class=\"card-header text-center p-2 bg-dark text-light m-1 mt-2\">My Class Notes Or Question Paper</h4>\n");
      out.write(" \n");
      out.write(" \t");
      out.write("<svg xmlns=\"http://www.w3.org/2000/svg\" style=\"display: none;\">\n");
      out.write("  <symbol id=\"check-circle-fill\" fill=\"currentColor\" viewBox=\"0 0 16 16\">\n");
      out.write("    <path\n");
      out.write("\t\td=\"M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z\" />\n");
      out.write("  </symbol>\n");
      out.write("  \n");
      out.write("  <symbol id=\"exclamation-triangle-fill\" fill=\"currentColor\"\n");
      out.write("\t\tviewBox=\"0 0 16 16\">\n");
      out.write("    <path\n");
      out.write("\t\td=\"M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z\" />\n");
      out.write("  </symbol>\n");
      out.write("</svg>\n");
      out.write("\n");
      out.write("\n");

	String message = (String) session.getAttribute("message");
    String msgStatus=(String) session.getAttribute("msgStatus");
	if (message != null) {
		if(msgStatus.equals("success")){
		
      out.write("\n");
      out.write("          <div class=\"alert alert-success d-flex align-items-center\" role=\"alert\">\n");
      out.write("\t          <svg class=\"bi flex-shrink-0 me-2\" width=\"24\" height=\"24\" role=\"img\"\n");
      out.write("\t\t              aria-label=\"Success:\">\n");
      out.write("\t\t      <use xlink:href=\"#check-circle-fill\" /></svg>\n");
      out.write("\t        <div>\n");
      out.write("\t\t    ");
 out.println(message); 
      out.write("\n");
      out.write("\t        </div>\n");
      out.write("        </div>\n");

      }  else if(msgStatus.equals("error")){
    	 
      out.write(" \n");
      out.write("    \t  <div class=\"alert alert-danger d-flex align-items-center\" role=\"alert\">\n");
      out.write("\t\t\t<svg class=\"bi flex-shrink-0 me-2\" width=\"24\" height=\"24\" role=\"img\"\n");
      out.write("\t\t         aria-label=\"Danger:\">\n");
      out.write("\t        \t<use xlink:href=\"#exclamation-triangle-fill\" /></svg>\n");
      out.write("\t         <div> ");
 out.println(message); 
      out.write("</div>\n");
      out.write("\t       </div>\t  \n");
      out.write("    \t");
  
      }	
		
      out.write('\n');

	session.removeAttribute("message");
    session.removeAttribute("msgStatus");
	}

      out.write('\n');
      out.write('\n');
      out.write("\n");
      out.write(" \n");
      out.write(" <div class=\"card\">\n");
      out.write("  <div class=\"card-body\">\n");
      out.write("    \n");
      out.write("    <table class=\"table\">\n");
      out.write("\t\t\t\t\t\t<thead class=\"thead-dark\">\n");
      out.write("\t\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t\t<th scope=\"col\">Title</th>\n");
      out.write("\t\t\t\t\t\t\t\t<th scope=\"col\">Document Type</th>\n");
      out.write("\t\t\t\t\t\t\t\t<th scope=\"col\">Uploaded By</th>\n");
      out.write("\t\t\t\t\t\t\t\t<th scope=\"col\">Uploaded On</th>\n");
      out.write("\t\t\t\t\t\t\t\t<th scope=\"col\">Subject Name</th>\n");
      out.write("\t\t\t\t\t\t\t\t<th scope=\"col\">Class Name</th>\n");
      out.write("\t\t\t\t\t\t\t\t<th scope=\"col\">Class Year</th>\n");
      out.write("\t\t\t\t\t\t\t\t<th scope=\"col\">Update</th>\n");
      out.write("\t\t\t\t\t\t\t\t<th scope=\"col\">Delete</th>\n");
      out.write("\t\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t</thead>\n");
      out.write("\t\t\t\t\t\t<tbody>\n");
      out.write("\t\t\t\t\t\t   ");

						      for(Documentations document: docList){
						   
      out.write("\n");
      out.write("\t\t\t\t\t\t   <tr>\n");
      out.write("\t\t\t\t\t\t       <td name=\"title\">");
      out.print( document.getTitle() );
      out.write("</td>\n");
      out.write("\t\t\t\t\t\t\t\t<td name=\"doctype\">");
      out.print( document.getDocType() );
      out.write("</td>\n");
      out.write("\t\t\t\t\t\t\t\t<td>");
      out.print( document.getUserName() );
      out.write("</td>\n");
      out.write("\t\t\t\t\t\t\t\t<td>");
      out.print( new SimpleDateFormat("dd MMM yyyy").format(document.getUplodedDate()) );
      out.write("</td>\n");
      out.write("\t\t\t\t\t\t\t\t<td name=\"subname\"> ");
      out.print( document.getNewsubject().getSubjectName() );
      out.write("</td>\n");
      out.write("\t\t\t\t\t\t\t\t<td name=\"classname\">");
      out.print( document.getNewsubject().getNewClassObj().getClassName() );
      out.write("</td>\n");
      out.write("\t\t\t\t\t\t\t\t<td>");
      out.print( document.getNewsubject().getNewClassObj().getClassYear() );
      out.write("</td>\n");
      out.write("\t\t\t\t\t\t\t\t<td><a href=\"update_class_notes_or_question_paper.jsp?id=");
      out.print(document.getId() );
      out.write("\"> <button type=\"submit\" class=\"btn btn-primary\">Update</button></a></td>\t\t\t\t   \n");
      out.write("\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t<form action=\"removedata\" method=\"post\">\n");
      out.write("\t\t\t\t\t\t\t\t <input type=\"hidden\" name=\"id\" value=\"");
      out.print( document.getId() );
      out.write("\">\n");
      out.write("\t\t\t\t\t\t\t\t <input type=\"hidden\" name=\"type\" value=\"doc\">\n");
      out.write("\t\t\t\t\t\t\t\t <input type=\"hidden\" name=\"frompage\" value=\"mainpage\">\n");
      out.write("\t\t\t\t\t\t\t\t <td><button type=\"submit\" class=\"btn btn-danger \">Delete</button></td>\n");
      out.write("\t\t\t\t\t\t\t\t</form>\n");
      out.write("\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t   ");

						      }
						   
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t</tbody>\n");
      out.write("\t\t</table>\n");
      out.write("    \n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\t<!-- -------------------------------------------------------------------------------------------------------------------------------------------------------------------------- -->\n");
      out.write("     \n");
      out.write("     <!-- Update The Class Notes or Question Set Details modal -->\n");
      out.write("\t\n");
      out.write("\t<!-- Modal -->\n");
      out.write("\t<div class=\"modal fade\" id=\"add-notes-questionset\" tabindex=\"-1\"\n");
      out.write("\t\taria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n");
      out.write("\t\t<div class=\"modal-dialog modal-lg\">\n");
      out.write("\t\t\t<div class=\"modal-content\">\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t\t<div class=\"modal-header shadow m-3\">\n");
      out.write("\t\t\t\t   <div class=\"container text-center\">\n");
      out.write("\t\t\t\t     <h4 class=\"modal-title add-category-title\" id=\"exampleModalLabel\">Update Class Notes/ QuestionPaper Details</h4>\n");
      out.write("\t\t\t\t   </div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t<div class=\"modal-body\">\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t    <form action=\"OperationServlet\" method=\"post\" enctype=\"multipart/form-data\">\n");
      out.write("\t\t\t\t         <div class=\"form-group\">\n");
      out.write("\t\t\t\t         \n");
      out.write("\t\t\t\t         <input type=\"hidden\" name=\"operation\" value=\"addNotesOrQuestionSet\">\n");
      out.write("\t\t\t\t         <input type=\"hidden\" name=\"pageFindForReponse\" value=\"adminPage\">\n");
      out.write("\t\t\t\t         <input type=\"hidden\" name=\"userName\" value=\"");
      out.print(userName );
      out.write("\">\n");
      out.write("\t\t\t\t         <input type=\"hidden\" name=\"userId\" value=\"");
      out.print( userId );
      out.write("\">\n");
      out.write("\t\t\t\t         \n");
      out.write("\t\t\t\t             <input type=\"text\" class=\"form-control shadow-sm\" name=\"notesTitle\" value=\"\" placeholder=\"Enter the Notes/Question paper Name\" required>\t\t\t         \n");
      out.write("\t\t\t\t         </div>\n");
      out.write("\t\t\t\t         \n");
      out.write("\t\t\t\t         <div class=\"form-group mt-3\">\n");
      out.write("\t\t\t\t             <textarea class=\"form-control shadow-sm\" name=\"notesDesc\" placeholder=\"Enter notes/Question paper Description\" required style=\"height:80px\"></textarea>\t\t         \n");
      out.write("\t\t\t\t         </div>\n");
      out.write("\t\t\t\t         \n");
      out.write("\t\t\t\t         <div class=\"form-group mt-3\">\n");
      out.write("\t\t\t\t         <label id=\"notesFile\">Choose upload file: </label>\n");
      out.write("\t\t\t\t             <input type=\"file\" class=\"form-control shadow-sm mt-1\" name=\"notesFiles\" id=\"notesFile\" placeholder=\"choose upload file\" required>\t\t\t         \n");
      out.write("\t\t\t\t         </div>\n");
      out.write("\t\t\t\t         \n");
      out.write("\t\t\t\t         <div class=\"form-group mt-3\">\n");
      out.write("\t\t\t\t             <select name=\"classNameId\" class=\"form-control\" id=\"classname\">\n");
      out.write("\t\t\t\t               \t\t<option value=\"\" disabled selected>--: Select Class Name :--</option>\n");
      out.write("\t\t\t\t                \t<option value=\"Class Notes\">Class Notes</option>\n");
      out.write("\t\t\t\t                \t<option value=\"Question Paper Set\">Question Paper</option>\n");
      out.write("\t\t\t\t             </select>\n");
      out.write("\t\t\t\t         </div>\n");
      out.write("\t\t\t\t         \n");
      out.write("\t\t\t\t         <div class=\"form-group mt-3\">\n");
      out.write("\t\t\t\t             <select name=\"classSubjectNameId\" class=\"form-control\" id=\"subjectname\">\n");
      out.write("\t\t\t\t               \t\t<option value=\"\" disabled selected>--: Select Class Subject :--</option>\n");
      out.write("\t\t\t\t                \t \t <option value=\"Class Notes\">Class Notes</option>\n");
      out.write("\t\t\t\t                \t<option value=\"Question Paper Set\">Question Paper</option>            \n");
      out.write("\t\t\t\t             </select>\n");
      out.write("\t\t\t\t         </div>\t\t        \n");
      out.write("\t\t\t\t         \n");
      out.write("\t\t\t\t         <div class=\"form-group mt-3\">\n");
      out.write("\t\t\t\t             <select name=\"docTypeId\" class=\"form-control\" id=\"\">\n");
      out.write("\t\t\t\t                   <option value=\"\" disabled selected>--: Select Uploaded Document Type :--</option>\n");
      out.write("\t\t\t\t                \t<option value=\"Class Notes\">Class Notes</option>\n");
      out.write("\t\t\t\t                \t<option value=\"Question Paper Set\">Question Paper</option>\t\t             \n");
      out.write("\t\t\t\t             </select>\n");
      out.write("\t\t\t\t         </div>\n");
      out.write("\t\t\t\t         \t\t\t\t         \n");
      out.write("\t\t\t\t         <div class=\"container text-center mt-3\">\n");
      out.write("\t\t\t\t            <button class=\"btn btn-outline-success\">Add New Document</button>\n");
      out.write("\t\t\t\t            <button type=\"button\" class=\"btn btn-outline-secondary ms-2\"\n");
      out.write("\t\t\t\t\t\tdata-bs-dismiss=\"modal\">Close</button>\n");
      out.write("\t\t\t\t         \n");
      out.write("\t\t\t\t         </div>\n");
      out.write("\t\t\t\t\t\t    \n");
      out.write("\t\t\t\t    </form>\t\t\t\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("\t<!-- End The Update Class Notes And Question Paper modal -->\n");
      out.write(" \n");
      out.write(" <script type=\"text/javascript\">\n");
      out.write("   \n");
      out.write("\n");
      out.write(" </script>\n");
      out.write(" \n");
      out.write(" \n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("            $(document).ready(function () {\n");
      out.write("                $.ajax({\n");
      out.write("                    url: \"GetCountryStateservlet\",\n");
      out.write("                    method: \"GET\",\n");
      out.write("                    data: {operation: 'classname'},\n");
      out.write("                    success: function (data, textStatus, jqXHR) {\n");
      out.write("                        console.log(data);\n");
      out.write("                        let obj = $.parseJSON(data);\n");
      out.write("                        $.each(obj, function (key, value) {\n");
      out.write("                            $('#classname').append('<option value=\"' + value.id + '\">' + value.className +' ('+ value.classYear +' year)</option>')\n");
      out.write("                        });\n");
      out.write("                        $('select').formSelect();\n");
      out.write("                    },\n");
      out.write("                    error: function (jqXHR, textStatus, errorThrown) {\n");
      out.write("                        $('#classname').append('<option>Class not Available</option>');\n");
      out.write("                    },\n");
      out.write("                    cache: false\n");
      out.write("                });\n");
      out.write("\n");
      out.write("                $('#classname').change(function () {\n");
      out.write("                    $('#subjectname').find('option').remove();\n");
      out.write("                    $('#subjectname').append('<option>--: Select Class Subject :--</option>'); \n");
      out.write("                   \n");
      out.write("                    let cid = $('#classname').val();\n");
      out.write("                    let data = {\n");
      out.write("                        operation: \"subjectname\",\n");
      out.write("                        id: cid\n");
      out.write("                    };\n");
      out.write("\n");
      out.write("                    $.ajax({\n");
      out.write("                        url: \"GetCountryStateservlet\",\n");
      out.write("                        method: \"GET\",\n");
      out.write("                        data: data,\n");
      out.write("                        success: function (data, textStatus, jqXHR) {\n");
      out.write("                            console.log(data);\n");
      out.write("                            let obj = $.parseJSON(data);\n");
      out.write("                            $.each(obj, function (key, value) {\n");
      out.write("                                $('#subjectname').append('<option value=\"' + value.id + '\">' + value.subjectName + '</option>')\n");
      out.write("                            });\n");
      out.write("                            $('select').formSelect();\n");
      out.write("                        },\n");
      out.write("                        error: function (jqXHR, textStatus, errorThrown) {\n");
      out.write("                            $('#subjectname').append('<option>Subject Unavailable</option>');\n");
      out.write("                        },\n");
      out.write("                        cache: false\n");
      out.write("                    });\n");
      out.write("                });\n");
      out.write("               \n");
      out.write("                \n");
      out.write("                \n");
      out.write("\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("        \n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
