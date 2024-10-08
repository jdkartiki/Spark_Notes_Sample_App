<%@page import="com.ravi.ates.notes.model.*" %>
<%@page import="com.ravi.ates.notes.dao.*" %>
<%@page import="com.ravi.ates.notes.helper.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Question Paper Or Class Notes</title>
<%@ include file="comm-css-javascript.jsp" %>
</head>
<body>
<%@ include file="navbar.jsp" %>

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
	
	String id=request.getParameter("id");
	DocumentationDao documentationDao = new DocumentationDao(FactoryProvider.getFactory());
	Documentations doc=documentationDao.getDocumentById(Long.parseLong(id));
	
%>

 <div class="container col-md-7">
		<div class="container d-flex">
			<div class="container mt-3 container ml-5">
				<div class="ml-3">

					<div class="card border border-right-0 rounded shadow ">
						<h4 class="card-header text-center p-3 add-question-paper-css">Update Class Notes Or Question Paper</h4>
						<div class="card-body p-3">
							<div class="text-center">
								<%@ include file="message.jsp"%>

							</div>
                              
                           <form action="OperationServlet" method="post" enctype="multipart/form-data">
				         <div class="form-group">
				         
				         <input type="hidden" name="operation" value="updateNotesOrQuestionSet">
				         <input type="hidden" name="pageFindForReponse" value="mainPage">
				         <input type="hidden" name="userName" value="<%=userName %>">
				         <input type="hidden" name="documentId" value="<%= doc.getId() %>">
				         <input type="hidden" name="classNameId" value="<%= doc.getNewsubject().getNewClassObj().getId() %>">
				         <input type="hidden" name="subjectNameId" value="<%= doc.getNewsubject().getId() %>">
				         <input type="hidden" name="documentType" value="<%= doc.getDocType() %>">
				         <input type="hidden" name="userId" value="<%= userId %>">
				         
				         
				             <input type="text" class="form-control shadow-sm" name="notesTitle" value="<%= doc.getTitle() %>" placeholder="Enter the Notes/Question paper Name" required>			         
				         </div>
				         
				         <div class="form-group mt-3">
				             <textarea class="form-control shadow-sm" name="notesDesc" placeholder="Enter notes/Question paper Description" required style="height:80px"><%= doc.getDescription() %></textarea>		         
				         </div>
				         
				         <div class="form-group mt-3">
				         <label id="notesFile">Choose upload file: </label>
				             <input type="file" class="form-control shadow-sm mt-1" name="notesFiles"  value="<%= doc.getUploadedDocument() %>" id="notesFile" placeholder="choose upload file" required>			         
				         </div>
				         				         
				         <div class="container text-center mt-3">
				            <button class="btn btn-outline-success">Update Document</button>
				            <form>
                                <input type="button" class="btn btn-outline-primary" value="Go Back" onclick="history.go(-1)">
                            </form>
				         
				         </div>
						    
				    </form>
				    
							

						</div>
					</div>

				</div>
			</div>

		</div>

	</div>
 
 
 
 
 
 

    	
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