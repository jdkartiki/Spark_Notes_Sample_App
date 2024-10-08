<%@page import="com.ravi.ates.notes.model.User" %>
<%@page import="com.ravi.ates.notes.dao.*" %>
<%@page import="com.ravi.ates.notes.helper.*" %>
<%@page import="com.ravi.ates.notes.model.*" %>
<%@page import="java.util.List" %>
<%
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
       
%>

<%

    NewClassDao newClassDao=new NewClassDao(FactoryProvider.getFactory());
    List<NewClass> newClassList= newClassDao.getNewClasses();

%>

<div class="border shadow mt-1 mb-5 rounded">
	<nav class="navbar navbar-expand-lg fixed-top navbar-dark" style="background-color:#23415c" >

		<div class="container2">
			<div>
				<a class="navbar-brand fs-2 ms-3 fontMycart" href="index.jsp">HP's Notes</a>
			</div>

		</div>



		<div class="container-fluid">
			<div class="container me-4 ms-4 ml-auto">
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse " id="navbarSupportedContent">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item fs-5"><a class="nav-link active"
							aria-current="page" href="index.jsp">Home</a></li>

						<li class="nav-item dropdown fs-5"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-bs-toggle="dropdown" aria-expanded="false">
								Question Paper Set </a>
							<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
							  <%
							    for(NewClass newClass: newClassList){
							  
							  %>
								<li><a class="dropdown-item" href="question_paper.jsp?classname=<%= newClass.getId()%>"><%= newClass.getClassName()+" ("+ newClass.getClassYear()+ " year)" %></a></li>
								
								<%
							    }

                                 %>
								
							</ul></li>

						<li class="nav-item dropdown fs-5">
						<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-bs-toggle="dropdown" aria-expanded="false">
								Classroom Notes </a>
							<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
								<%
							    for(NewClass newClass: newClassList){
							  
							  %>
								<li><a class="dropdown-item" href="class_notes.jsp?classname=<%= newClass.getId() %>"><%= newClass.getClassName()+" ("+ newClass.getClassYear()+ " year)" %></a></li>
								
								<%
							    }

                                 %>
							</ul></li>



					</ul>
					<ul class="navbar-nav ml-auto">
						
						<%
					      if(userNav==null){
					    %>	 
					     
						<li class="nav-item dropdown fs-5 ml-auto"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-bs-toggle="dropdown" aria-expanded="false">
								 Sign Up/Login </a>
							<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
								<li><a class="dropdown-item " href="Register.jsp">Sign Up</a></li>
								<li><a class="dropdown-item" href="login.jsp">Log In</a></li>
							</ul>
						</li>
						
						 <%	  
					      }
						 // we check the login user is a admin or not
					      else{
					    	  if(user3.equals("admin")){
					    %>	
					    
					    <li class="nav-item fs-5"><a class="nav-link "
							aria-current="page" href="add_notes_question_paper.jsp">Add Notes/Question Paper</a></li>
					    
					     <li class="nav-item dropdown fs-5 ml-auto"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-bs-toggle="dropdown" aria-expanded="false">
								 <%=userNav.getUserName() %> </a>
							<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
								<li><a class="dropdown-item " href="admin.jsp">Admin Panel</a></li>
								<li><a class="dropdown-item " href="my_notes_or_question_paper.jsp">My Notes/QuestionPaper</a></li>
								<li><a class="dropdown-item" href="LogOutServlet">Log Out</a></li>
							</ul>
						</li>
					    
					    <%	  
					      }
					    	  // we check the login user is a normal or not
					    	  else
					    		  if(user3.equals("normal")){
					    	%>
					    	
					    	<li class="nav-item fs-5"><a class="nav-link "
							aria-current="page" href="add_notes_question_paper.jsp">Add Notes/Question Paper</a></li>
					    	
					    	<li class="nav-item dropdown fs-5 ml-auto"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-bs-toggle="dropdown" aria-expanded="false">
								 <%=userNav.getUserName() %> </a>
							<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
								
								<li><a class="dropdown-item " href="update_user_profile.jsp">Edit Profile</a></li>
								<li><a class="dropdown-item " href="my_notes_or_question_paper.jsp">My Notes/QuestionPaper</a></li>
								<li><a class="dropdown-item" href="LogOutServlet">Log Out</a></li>
							</ul>
						   </li>
					    	
					    			  
					    <%			  
					    	  }
					      }
					    %>

						<li class="nav-item fs-5 ml-auto"><a class="nav-link "
							aria-current="page" href="about us.jsp">About Us</a></li>

					</ul>



				</div>

			</div>
	</nav>
</div>
</div>

<!-- 

<script type="text/javascript">
    $(docuent).ready(function(){

        $('.navbar-nav').on('click','a', function(){

            $('.navbar-nav a.active').removeClass('active');
            $(this).addClass('active');

            })

        })


  </script>


 -->

