<%@page import="com.ravi.ates.notes.dao.NewClassDao" %>
<%@page import="com.ravi.ates.notes.dao.NewClassSubjectDao" %>
<%@page import="com.ravi.ates.notes.model.*" %>
<%@page import="java.util.List" %>
<%@page import="com.ravi.ates.notes.helper.FactoryProvider" %>
<%@page import="java.text.SimpleDateFormat"%>

<%
   User user=(User)session.getAttribute("current_user");
   String userName=null;
   Long selectedClassId=null;
   long userId;
   if(user==null){
	    HttpSession  httpSession=request.getSession();
    	httpSession.setAttribute("message", "Yor are not Logged in!!..Please Login!");
		httpSession.setAttribute("msgStatus", "error");
		response.sendRedirect("login.jsp");
		return; 
   }else{
	   
	   //we get the name of uploaded user name
	     userName=user.getUserName();
	     userId=user.getUserId();
	   
	   if(user.getUserType().equals("normal")){
		    HttpSession  httpSession=request.getSession();
	    	httpSession.setAttribute("message", "Access Denied ! Your are not Admin");
			httpSession.setAttribute("msgStatus", "error");
			response.sendRedirect("login.jsp");
			return;  
		   
	   }
   }
%>

<!-- product Categories select -->

<%
  
    NewClassDao newClassDao1=new NewClassDao(FactoryProvider.getFactory());
    List<NewClass> list= newClassDao1.getNewClasses();
    int noOfClasses=list.size();
    
    NewClassSubjectDao subjectDao=new NewClassSubjectDao(FactoryProvider.getFactory());
    List<NewClassSubject> subList= subjectDao.getSubjectList();
    int noOfClassSubject=subList.size();
    
    DocumentationDao documentationDao = new DocumentationDao(FactoryProvider.getFactory());
    List<Documentations> docList=documentationDao.getDocumentationsList();
    
    List<NewClassSubject> subListById=subjectDao.getSubjectsByClassId(1);
    
   /** UserDao userDao=new UserDao(FactoryProvider.getFactory());
    List<User> userList=userDao.getAllData();
    int userSize=userList.size();
    
	CategoryDao categoryDao = new CategoryDao(FactoryProvider.getFactory());
	List<Category> list = categoryDao.getCategories();
	int catSize=list.size();
	
	ProductDao productDao=new ProductDao(FactoryProvider.getFactory());
	List<Product> plist=productDao.getAllProduct();
	int prodSize=plist.size();
	
	OrderDetailDao orderDao=new OrderDetailDao(FactoryProvider.getFactory());
	List<OrderDetail> orderList=orderDao.getAllOrderDetails(); */
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Panel</title>


<%@ include file="comm-css-javascript.jsp"%>

</head>
<body>
	<%@ include file="navbar.jsp"%>
	<span class="m-3"></span>
	<h2 class="text-center mt-4 admin-head-css">Administration Panel</h2>
				
	<div class="container admin">
	
	<!-- Show message -->
	<div class="row container text-center">
	   <!-- Success message -->
		<div class="col-md-12 text-center">
			<%@ include file="message.jsp"%>

		</div>
	
	</div>
	
		<!-- First row -->
		<div class="row mt-3 m-1">
			<!-- First row of first Column -->
			<div class="col-md-4 mt-2">
				<div class="border border-primary text-center shadow hover-card " data-bs-toggle="modal"
		                                                                         data-bs-target="#add-new-class">
					<div class="container mt-3 mb-2">
						<img alt="Number of users" src="img/classroom.png"
							style="max-height: 90px;">
					</div>

					<h4><%= noOfClasses%></h4>
					<h5 style="color: #BDBDBD">Add The New Class</h5>

				</div>
			</div>


			<!-- First row of Second Column -->
			<div class="col-md-4 mt-2">
				<div class="border border-primary text-center shadow hover-card" data-bs-toggle="modal"
		                                                                         data-bs-target="#add-new-class-subject">
					<div class="container mt-3">
						<img alt="Number of categories" src="img/subject.png"
							style="max-height: 58px;">
					</div>

					<h4 class="mt-3"><%=noOfClassSubject %></h4>
					<h5 style="color: #BDBDBD">Add The New Class Subject</h5>

				</div>

			</div>


			<!-- First row of third Column -->
			<div class="col-md-4 mt-2">				   
				
				
				<div class="border border-primary text-center shadow hover-card" data-bs-toggle="modal"
		                                                                         data-bs-target="#add-notes-questionset">
					<div class="container mt-3">
						<img alt="Number of product" src="img/notes.png"
							style="max-height: 66px;">
					</div>

					<h4 class="mt-2" style="text:black"><%= docList.size()%></h4>
					<h5 style="color: #BDBDBD">Add the New Notes/Question Paper</h5>

				</div>

			</div>

		</div>


		<!-- Second Row -->
		<div class="row mt-4 m-1">
		
			<!-- Second row of first Column -->
			<div class="col-md-4 mt-2">
				<div class="border border-primary text-center shadow hover-card" data-bs-toggle="modal"
		                                                                         data-bs-target="#remove-class">
					<div class="container mt-4 mb-4">
						<img alt="Add the Categories" src="img/classroom.png"
							style="max-height: 90px;">
					</div>

					<h5 class="mt-2" style="color: #BDBDBD">Remove The New Class</h5>

				</div>
			</div>


			<!-- Second row of Second Column -->
			<div class="col-md-4 mt-2">
				<div class="border border-primary text-center shadow hover-card " data-bs-toggle="modal"
		                                                                          data-bs-target="#remove-class-subject">
					<div class="container mt-4 mb-4">
						<img alt="Add the product" src="img/subject.png"
							style="max-height: 73px;">
					</div>

					<h5 class="mt-4" style="color: #BDBDBD">Remove The New Class Subject</h5>

				</div>
			</div>
			
			<!-- Second row of Third Column -->
			<div class="col-md-4 mt-2">
				<div class="border border-primary text-center shadow hover-card " data-bs-toggle="modal"
		                                                                          data-bs-target="#remove-notes-or-question-paper">
					<div class="container mt-4 mb-4">
						<img alt="Order Details" src="img/remove-notes.png"
							style="max-height: 73px;">
					</div>

					<h5 class="mt-4" style="color: #BDBDBD">Remove the New Notes/Question Paper</h5>

				</div>
			</div>
		</div>

	</div>

	<!-- Add The New Class Details modal -->
<!-- -------------------------------------------------------------------------------------------------------------------------------------------------------------------------- -->
	
	<!-- Modal -->
	<div class="modal fade" id="add-new-class" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
			
				<div class="modal-header shadow m-3">
				   <div class="container text-center">
				     <h4 class="modal-title add-category-title" id="exampleModalLabel">Add New Class Details</h4>
				   </div>
				</div>
				
				<div class="modal-body">
				
				    <form action="OperationServlet" method="post">
				         <div class="form-group">
				         <input type="hidden" name="operation" value="addClass">
				             <input type="text" class="form-control shadow-sm" name="className" placeholder="Enter the class Name (MCA, BCA, MBA etc.)" required>			         
				         </div>
				         
				         <div class="form-group mt-3">
				             <input type="text" class="form-control shadow-sm mt-3" name="classYear" placeholder="Enter the class year (first, second, third etc.)" required>			         
				         </div>
				         
				         <div class="container text-center mt-3">
				            <button class="btn btn-outline-success">Add Class Details</button>
				            <button type="button" class="btn btn-outline-secondary"
						data-bs-dismiss="modal">Close</button>
				         
				         </div>
						    
				    </form>			
				</div>
			</div>
		</div>
	</div>

	<!-- End the New Class Details modal -->
	
<!-- -------------------------------------------------------------------------------------------------------------------------------------------------------------------------- -->
<!-- -------------------------------------------------------------------------------------------------------------------------------------------------------------------------- -->
	
	<!-- Add The New Class Subject Details modal -->
<!-- -------------------------------------------------------------------------------------------------------------------------------------------------------------------------- -->
	
	<!-- Modal -->
	<div class="modal fade" id="add-new-class-subject" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
			
				<div class="modal-header shadow m-3">
				   <div class="container text-center">
				     <h4 class="modal-title add-category-title" id="exampleModalLabel">Add New Class Subject Details</h4>
				   </div>
				</div>
				
				<div class="modal-body">
				
				    <form action="OperationServlet" method="post">
				         <div class="form-group">
				         <input type="hidden" name="operation" value="addClassSubject">
				             <input type="text" class="form-control shadow-sm" name="classSubjectName" placeholder="Enter the class Subject Name" required>			         
				         </div>
				         
				         <div class="form-group mt-3">
				             <input type="text" class="form-control shadow-sm mt-3" name="classDescription" placeholder="Enter the class Subject Description" required>			         
				         </div>
				         
				         <div class="form-group mt-3">
				             <select name="classId" class="form-control" id="">
				                <%
				                  for(NewClass c:list){
				                %>	  
				                    <option value="<%=c.getId()%>"><%=c.getClassName() %> (<%= c.getClassYear() %> year)</option>
				                <%	  
				                  }
				                %>			             
				             </select>
				         </div>
				         
				         <div class="container text-center mt-3">
				            <button class="btn btn-outline-success">Add Class Subject Details</button>
				            <button type="button" class="btn btn-outline-secondary"
						data-bs-dismiss="modal">Close</button>
				         
				         </div>
						    
				    </form>			
				</div>
			</div>
		</div>
	</div>

	<!-- End the New Class Subject Details modal -->
	
	<!-- -------------------------------------------------------------------------------------------------------------------------------------------------------------------------- -->
     
     <!-- Add The New Notes or Question Set Details modal -->
	
	<!-- Modal -->
	<div class="modal fade" id="add-notes-questionset" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
			
				<div class="modal-header shadow m-3">
				   <div class="container text-center">
				     <h4 class="modal-title add-category-title" id="exampleModalLabel">Add New Notes/ QuestionPaper Details</h4>
				   </div>
				</div>
				
				<div class="modal-body">
				
				    <form action="OperationServlet" method="post" enctype="multipart/form-data">
				         <div class="form-group">
				         
				         <input type="hidden" name="operation" value="addNotesOrQuestionSet">
				         <input type="hidden" name="pageFindForReponse" value="adminPage">
				         <input type="hidden" name="userName" value="<%=userName %>">
				         <input type="hidden" name="userId" value="<%= userId %>">
				         
				             <input type="text" class="form-control shadow-sm" name="notesTitle" placeholder="Enter the Notes/Question paper Name" required>			         
				         </div>
				         
				         <div class="form-group mt-3">
				             <textarea class="form-control shadow-sm" name="notesDesc" placeholder="Enter notes/Question paper Description" required style="height:80px"></textarea>		         
				         </div>
				         
				         <div class="form-group mt-3">
				         <label id="notesFile">Choose upload file: </label>
				             <input type="file" class="form-control shadow-sm mt-1" name="notesFiles" id="notesFile" placeholder="choose upload file" required>			         
				         </div>
				         
				         <div class="form-group mt-3">
				             <select name="classNameId" class="form-control" id="classname">
				               		<option value="" disabled selected>--: Select Class Name :--</option>
				                	         
				             </select>
				         </div>
				         
				         <div class="form-group mt-3">
				             <select name="classSubjectNameId" class="form-control" id="subjectname">
				               		<option value="" disabled selected>--: Select Class Subject :--</option>
				                	 	             
				             </select>
				         </div>		        
				         
				         <div class="form-group mt-3">
				             <select name="docTypeId" class="form-control" id="">
				                   <option value="" disabled selected>--: Select Uploaded Document Type :--</option>
				                	<option value="Class Notes">Class Notes</option>
				                	<option value="Question Paper Set">Question Paper</option>		             
				             </select>
				         </div>
				         				         
				         <div class="container text-center mt-3">
				            <button class="btn btn-outline-success">Add New Document</button>
				            <button type="button" class="btn btn-outline-secondary ms-2"
						data-bs-dismiss="modal">Close</button>
				         
				         </div>
						    
				    </form>			
				</div>
			</div>
		</div>
	</div>

	<!-- End the New Notes And Question Paper modal -->
	
<!-- ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- -->

 <!-- Remove  The Class Notes or Question  Paper Set  modal -->
	
	<!-- Modal -->
	<div class="modal fade" id="remove-notes-or-question-paper" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-xl">
			<div class="modal-content">
			
				<div class="modal-header shadow m-3">
				   <div class="container text-center">
				     <h4 class="modal-title add-category-title" id="exampleModalLabel">Remove the Class Notes Or Question Paper</h4>
				   </div>
				</div>
				
				<div class="modal-body">
					<table class="table">
						<thead class="thead-dark">
							<tr>
								<th scope="col">Title</th>
								<th scope="col">Document Type</th>
								<th scope="col">Uploaded By</th>
								<th scope="col">Uploaded On</th>
								<th scope="col">Subject Name</th>
								<th scope="col">Class Name</th>
								<th scope="col">Class Year</th>
								<th scope="col">Operation</th>
							</tr>
						</thead>
						<tbody>
						   <%
						      for(Documentations document: docList){
						   %>
						   <tr>
								<td><%= document.getTitle() %></td>
								<td><%= document.getDocType() %></td>
								<td><%= document.getUserName() %></td>
								<td><%= new SimpleDateFormat("dd MMM yyyy").format(document.getUplodedDate()) %></td>
								<td><%= document.getNewsubject().getSubjectName() %></td>
								<td><%= document.getNewsubject().getNewClassObj().getClassName() %></td>
								<td><%= document.getNewsubject().getNewClassObj().getClassYear() %></td>
								<form action="removedata" method="post">
								 <input type="hidden" name="id" value="<%= document.getId() %>">
								 <input type="hidden" name="type" value="doc">
								 <input type="hidden" name="frompage" value="adminpage">
								 <td><button type="submit" class="btn btn-danger ">Delete</button></td>
								</form>
								
							</tr>
						   <%
						      }
						   %>
							
						</tbody>
					</table>


				</div>
			</div>
		</div>
	</div>

	<!-- End the Remove Documentations modal -->
	
<!-- ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- -->

 <!-- Remove  The Class Subject  modal -->
	
	<!-- Modal -->
	<div class="modal fade" id="remove-class-subject" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-xl">
			<div class="modal-content">
			
				<div class="modal-header shadow m-3">
				   <div class="container text-center">
				     <h4 class="modal-title add-category-title" id="exampleModalLabel">Remove the Class Subject</h4>
				   </div>
				</div>
				
				<div class="modal-body">
					<table class="table">
						<thead class="thead-dark">
							<tr>
								<th scope="col">Subject Name</th>
								<th scope="col">Description</th>
								<th scope="col">Class Name</th>
								<th scope="col">Class Year</th>
								<th scope="col">Operation</th>
							</tr>
						</thead>
						<tbody>
						   <%
						      for(NewClassSubject subject: subList){
						   %>
						   <tr>
								<td><%= subject.getSubjectName() %></td>
								<td><%= subject.getDescription() %></td>
								<td><%= subject.getNewClassObj().getClassName() %></td>
								<td><%= subject.getNewClassObj().getClassYear() %></td>
								
								<form action="removedata" method="post">
								 <input type="hidden" name="id" value="<%= subject.getId() %>">
								 <input type="hidden" name="type" value="subject">
								 <input type="hidden" name="frompage" value="adminpage">
								 <td><button type="submit" class="btn btn-danger ">Delete</button></td>
								</form>
								
							</tr>
						   <%
						      }
						   %>
							
						</tbody>
					</table>


				</div>
			</div>
		</div>
	</div>

	<!-- End the Remove Subject  modal -->	
	
<!-- ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- -->

 <!-- Remove  The Class Subject  modal -->
	
	<!-- Modal -->
	<div class="modal fade" id="remove-class" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-xl">
			<div class="modal-content">
			
				<div class="modal-header shadow m-3">
				   <div class="container text-center">
				     <h4 class="modal-title add-category-title" id="exampleModalLabel">Remove the Class </h4>
				   </div>
				</div>
				
				<div class="modal-body">
					<table class="table">
						<thead class="thead-dark">
							<tr>
								<th scope="col">Class Name</th>
								<th scope="col">Class Year</th>
								<th scope="col">Operation</th>
							</tr>
						</thead>
						<tbody>
						   <%
						      for(NewClass classObj: list){
						   %>
						   <tr>
								<td><%= classObj.getClassName() %></td>
								<td><%= classObj.getClassYear() %></td>
								
								<form action="removedata" method="post">
								 <input type="hidden" name="id" value="<%= classObj.getId() %>">
								 <input type="hidden" name="type" value="class">
								 <input type="hidden" name="frompage" value="adminpage">
								 <td><button type="submit" class="btn btn-danger ">Delete</button></td>
								</form>
								
							</tr>
						   <%
						      }
						   %>
							
						</tbody>
					</table>


				</div>
			</div>
		</div>
	</div>

	<!-- End the Remove Subject  modal -->		



 <script type="text/javascript">
            $(document).ready(function () {
                $.ajax({
                    url: "GetCountryStateservlet",
                    method: "GET",
                    data: {operation: 'classname'},
                    success: function (data, textStatus, jqXHR) {
                        console.log(data);
                        let obj = $.parseJSON(data);
                        $.each(obj, function (key, value) {
                            $('#classname').append('<option value="' + value.id + '">' + value.className +' ('+ value.classYear +' year)</option>')
                        });
                        $('select').formSelect();
                    },
                    error: function (jqXHR, textStatus, errorThrown) {
                        $('#classname').append('<option>Class not Available</option>');
                    },
                    cache: false
                });

                $('#classname').change(function () {
                    $('#subjectname').find('option').remove();
                    $('#subjectname').append('<option>--: Select Class Subject :--</option>'); 
                   
                    let cid = $('#classname').val();
                    let data = {
                        operation: "subjectname",
                        id: cid
                    };

                    $.ajax({
                        url: "GetCountryStateservlet",
                        method: "GET",
                        data: data,
                        success: function (data, textStatus, jqXHR) {
                            console.log(data);
                            let obj = $.parseJSON(data);
                            $.each(obj, function (key, value) {
                                $('#subjectname').append('<option value="' + value.id + '">' + value.subjectName + '</option>')
                            });
                            $('select').formSelect();
                        },
                        error: function (jqXHR, textStatus, errorThrown) {
                            $('#subjectname').append('<option>Subject Unavailable</option>');
                        },
                        cache: false
                    });
                });
               
                
                

            });
        </script>

</body>
</html>