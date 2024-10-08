<%@page import="java.text.SimpleDateFormat"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%
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
%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>My Notes Or Question Paper</title>

<%@ include file="comm-css-javascript.jsp" %>
</head>
<body>
 <%@ include file="navbar.jsp" %>
 <span class="m-1"></span>
    <h4 class="card-header text-center p-2 bg-dark text-light m-1 mt-2">My Class Notes Or Question Paper</h4>
 
 	<%@ include file="message.jsp"%>
 
 <div class="card">
  <div class="card-body">
    
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
								<th scope="col">Update</th>
								<th scope="col">Delete</th>
							</tr>
						</thead>
						<tbody>
						   <%
						      for(Documentations document: docList){
						   %>
						   <tr>
						       <td name="title"><%= document.getTitle() %></td>
								<td name="doctype"><%= document.getDocType() %></td>
								<td><%= document.getUserName() %></td>
								<td><%= new SimpleDateFormat("dd MMM yyyy").format(document.getUplodedDate()) %></td>
								<td name="subname"> <%= document.getNewsubject().getSubjectName() %></td>
								<td name="classname"><%= document.getNewsubject().getNewClassObj().getClassName() %></td>
								<td><%= document.getNewsubject().getNewClassObj().getClassYear() %></td>
								<td><a href="update_class_notes_or_question_paper.jsp?id=<%=document.getId() %>"> <button type="submit" class="btn btn-primary">Update</button></a></td>				   
								
								<form action="removedata" method="post">
								 <input type="hidden" name="id" value="<%= document.getId() %>">
								 <input type="hidden" name="type" value="doc">
								 <input type="hidden" name="frompage" value="mainpage">
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

	<!-- -------------------------------------------------------------------------------------------------------------------------------------------------------------------------- -->
     
     <!-- Update The Class Notes or Question Set Details modal -->
	
	<!-- Modal -->
	<div class="modal fade" id="add-notes-questionset" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
			
				<div class="modal-header shadow m-3">
				   <div class="container text-center">
				     <h4 class="modal-title add-category-title" id="exampleModalLabel">Update Class Notes/ QuestionPaper Details</h4>
				   </div>
				</div>
				
				<div class="modal-body">
				
				    <form action="OperationServlet" method="post" enctype="multipart/form-data">
				         <div class="form-group">
				         
				         <input type="hidden" name="operation" value="addNotesOrQuestionSet">
				         <input type="hidden" name="pageFindForReponse" value="adminPage">
				         <input type="hidden" name="userName" value="<%=userName %>">
				         <input type="hidden" name="userId" value="<%= userId %>">
				         
				             <input type="text" class="form-control shadow-sm" name="notesTitle" value="" placeholder="Enter the Notes/Question paper Name" required>			         
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
				                	<option value="Class Notes">Class Notes</option>
				                	<option value="Question Paper Set">Question Paper</option>
				             </select>
				         </div>
				         
				         <div class="form-group mt-3">
				             <select name="classSubjectNameId" class="form-control" id="subjectname">
				               		<option value="" disabled selected>--: Select Class Subject :--</option>
				                	 	 <option value="Class Notes">Class Notes</option>
				                	<option value="Question Paper Set">Question Paper</option>            
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

	<!-- End The Update Class Notes And Question Paper modal -->
 
 <script type="text/javascript">
   

 </script>
 
 
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