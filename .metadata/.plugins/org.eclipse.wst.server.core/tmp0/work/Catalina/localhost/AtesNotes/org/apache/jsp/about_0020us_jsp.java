/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.37
 * Generated at: 2023-12-29 10:03:42 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.ravi.ates.notes.model.User;
import com.ravi.ates.notes.dao.*;
import com.ravi.ates.notes.helper.*;
import com.ravi.ates.notes.model.*;
import java.util.List;

public final class about_0020us_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"ISO-8859-1\">\n");
      out.write("<title>HP NOTES | About Us</title>\n");
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
      out.write("<style>\n");
      out.write("@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400&display=swap');\n");
      out.write(".container-bg{\n");
      out.write("\tfont-family: 'Poppins', sans-serif;\n");
      out.write("}\n");
      out.write(" .about-us{\n");
      out.write("\ttext-transform: uppercase;\n");
      out.write("\tfont-size:32px;\n");
      out.write("}\n");
      out.write(".content-section .content h3{\n");
      out.write("\tmargin-top: 20px;\n");
      out.write("\tcolor:#5d5d5d;\n");
      out.write("\tfont-size: 21px;\n");
      out.write("}\n");
      out.write(".content-section .content p{\n");
      out.write("\tmargin-top: 10px;\n");
      out.write("\tfont-family: sans-serif;\n");
      out.write("\tfont-size: 18px;\n");
      out.write("\tline-height: 1.5;\n");
      out.write("}\n");
      out.write("body{\n");
      out.write(" background-color: #ddd;\n");
      out.write("}\n");
      out.write(".content-section .social{\n");
      out.write("\tmargin: 40px 40px;\n");
      out.write("}\n");
      out.write(".content-section .social i{\n");
      out.write("\tcolor:#884dff;\n");
      out.write("\tfont-size: 30px;\n");
      out.write("\tpadding:0px 10px;\n");
      out.write("}\n");
      out.write(".content-section .social i:hover{\n");
      out.write("\tcolor:#3d3d3d;\n");
      out.write("}\n");
      out.write(".image-section h5{\n");
      out.write("\tmargin-top: 15px;\n");
      out.write("\tcolor:#884dff;\n");
      out.write("\tfont-size: 18px;\n");
      out.write("\tmargin-left:20px;\n");
      out.write("}\n");
      out.write(".image-section h6{\n");
      out.write("\tmargin-top: 8px;\n");
      out.write("\tcolor:#5d5d5d;\n");
      out.write("\tfont-size: 14px;\n");
      out.write("\tmargin-left:20px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("</style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("  ");
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
      out.write("  <span class=\"m-4\"></span>\n");
      out.write("  <div class=\"container mt-4 container-bg\">\n");
      out.write("   <div class=\"container\">\n");
      out.write("     <div class=\"content-section\">\n");
      out.write("        <div class=\"title\">\n");
      out.write("         <h2 class=\" m-2 about-us\">&nbsp;&nbsp;About Us</h2>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("       <div class=\"row\">\n");
      out.write("         <div class=\"row\">\n");
      out.write("    <div class=\"col-sm-9 col-md-6 col-lg-8\" >\n");
      out.write("      <div class=\"content\">\n");
      out.write("\t\t\t\t\t<h3>To Collect College Notes And Question Paper <br> &nbsp;&nbsp;&nbsp; On Digital World !</h3>\n");
      out.write("\t\t\t\t\t<p>This is New Journey With Us, We Help you to And provide one of the best platform where we easily reach out the necessary \n");
      out.write("\t\t\t\t\t    College Notes And Question Paper And Give the power to share your own knowledge by the notes...</p>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<div class=\"social ml-4\">\n");
      out.write("\t\t\t\t\t<a href=\"#\"><i class=\"fab fa-facebook-f\"></i></a>\n");
      out.write("\t\t\t\t\t<a href=\"#\"><i class=\"fab fa-instagram\"></i></a>\n");
      out.write("\t\t\t\t\t<a href=\"mailto:hiteshapatil1407@gmail.com\"><i class=\"fa fa-envelope\" aria-hidden=\"true\"></i></a>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"col-sm-3 col-md-6 col-lg-4\">\n");
      out.write("      <div class=\"image-section text-center\">\n");
      out.write("\t\t\t<img src=\"img/hp.jpg\" class=\"rounded-circle img-fluid\" alt=\"Hitesh patil img\" style=\"width:40%;height:auto;\">\n");
      out.write("\t\t\t<h5>&nbsp;Hitesh Patil</h5>\t\n");
      out.write("\t\t\t<h6><i>&nbsp;&nbsp;Student Of Spark Institute, <br>&nbsp;&nbsp;&nbsp;Pune</i></h6>\n");
      out.write("\t </div>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("          \n");
      out.write("       </div>\n");
      out.write("     </div>\n");
      out.write("   \n");
      out.write("   </div>\n");
      out.write("  \n");
      out.write("  </div>\n");
      out.write("    \n");
      out.write(" \n");
      out.write("    \n");
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
