<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
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

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Account</title>
<%@ include file="comm-css-javascript.jsp"%>
<style>
 body{
    background-image: url("img/sp2.jpg");
    background-repeat : no repeat;
    background-position : center;
    background-attachment: fixed;
    height: 100%;
    width : 100%;
    position: relative;
    background-size:cover;
    display:table;
}
</style>
</head>
<body>
	<%@ include file="navbar.jsp"%>
     <span class="m-3"></span>
	<div class="container2 mt-4">
		<div>
			<img class="reg-photo" src="img/sign_up.png">
		</div>
		<div class=" mt-2 ms-2 reg-form-title ">
			<h2>Update Profile</h2>
		</div>
	</div>


	<div
		class="col-md-4 offset-md-4 shadow p-3 mb-5 bg-white rounded mt-1 p-3">
		
		<!-- Success message -->
		 <div class="text-center">
          <%@ include file="message.jsp" %>
       
       </div>

		<form action="ResetPassword" method="post">
		
		   <input type="hidden" name="userId" value="<%=user.getUserId() %>">
		   <input type="hidden" name="passOperation" value="updateProfile">


			<div class="mb-2 ms-2 mt-4">
				<label for="userName" class="form-label">Enter Your Password: </label>
					<div class="input-group mb-3">
					<input type="password" class="form-control" name="upwd" id="password" value="<%= user.getUserPassword() %> " >
					<div class="input-group-append">
						<span class="input-group-text"><a href="#" id="icon-click"><i class="fas fa-eye mb-1 mt-1 text-dark" id="show_eye"></i></a></span>
					</div>
				</div>
			</div>
			
			<hr style="height:2px;border-width:0;color:gray;background-color:gray ">
			<div class="mb-2 ms-2">
				<label for="userName" class="form-label">Enter Your full Name: </label> 
				<input
					type="text" class="form-control" id="username" name="uname" placeholder="firstname middlename lastname" value="<%=user.getUserFullName() %>"
					aria-describedby="text">
			</div>
			
			<div class="mb-2 ms-2 mt-4">
				<label for="admissionyear" class="form-label">Enter Admission Year: </label> 
				<input type="text" class="form-control" id="userAdmissionYear" name="uadmiss" placeholder="yyyy" value="<%= user.getUserAdmissionYear()  %>">
			</div>

			<div class="container text-center mt-3">
				<button type="submit" class="btn btn-primary "
					data-mdb-ripple-color="dark">Update Profile</button>
			</div>
		</form>

	</div>

<script type="text/javascript">
	
	  $(document).ready(function(){
		$("#icon-click").click(function(){
			$("#show_eye").toggleClass('fa-eye-slash');
			var pass=$("#password");
			if(pass.attr("type")==="password"){
				pass.attr("type","text");
			}
			else{
				pass.attr("type","password");
			}
		});
		 
	  });
	
	</script>
</body>
</html>