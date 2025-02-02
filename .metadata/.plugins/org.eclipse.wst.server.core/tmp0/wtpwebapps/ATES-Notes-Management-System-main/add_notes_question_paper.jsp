<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add notes | Question Paper</title>
<%@ include file="comm-css-javascript.jsp"%>
<style>
 body{
   background-color: #f2f2f2;
}
</style>
</head>
<body>

	<%@ include file="navbar.jsp"%>

	<div class="container col-md-7">
		<div class="container d-flex">
			<div class="container mt-3 container ml-5">
				<div class="ml-3">

					<div class="card border border-right-0 rounded shadow ">
						<h4 class="card-header text-center p-3 add-question-paper-css">Add New Class Notes Or Question Paper</h4>
						<div class="card-body p-3">
							<div class="text-center">
								<%@ include file="message.jsp"%>

							</div>

							<form action="OperationServlet" method="post" enctype="multipart/form-data">
								<div class="form-group">

									<input type="hidden" name="operation" value="addNotesOrQuestionSet">
								    <input type="hidden" name="pageFindForReponse" value="mainpage"> 
								    <input type="hidden" name="userName" value="<%=userName%>">
								    <input type="hidden" name="userId" value="<%= userId %>">

									<input type="text" class="form-control shadow-sm" name="notesTitle" placeholder="Enter the Notes/Question paper Title" required>
								</div>

								<div class="form-group mt-3">
									<textarea class="form-control shadow-sm" name="notesDesc"
										placeholder="Enter notes/Question paper Description" required
										style="height: 80px"></textarea>
								</div>

								<div class="form-group mt-3">
									<label id="notesFile">Choose upload file: </label>
									 <input type="file" class="form-control shadow-sm mt-1" name="notesFiles" id="notesFile"
										placeholder="choose upload file" required>
								</div>

								<div class="form-group mt-3">
									<select name="classNameId" class="form-control" id="classname">
										<option value="" disabled selected>--: Select Class Name :--</option>
										
									</select>
								</div>

								<div class="form-group mt-3">
									<select name="classSubjectNameId" class="form-control"
										id="subjectname">
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
									<button class="btn btn-outline-success text-center"> Add New Documents</button>
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
// =========================================================================================
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