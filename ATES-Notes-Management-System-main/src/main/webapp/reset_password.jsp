<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%
      String userid=request.getParameter("id");
	if (userid == null || userid.isEmpty()) {
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("message", "UnAuthorizied Access !");
		httpSession.setAttribute("msgStatus", "error");
		response.sendRedirect("forgot_password.jsp");
		return;
	} 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reset Password Page</title>
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
   <span class="m-4"></span>
	<div class="container2 mt-4">
		<div>
			<img class="reg-photo" src="img/login.png">
		</div>
		<div class=" mt-3 ms-2 log-form-title ">
			<h2>Reset Password</h2>
		</div>
	</div>
	<div
		class="col-md-4 offset-md-4 shadow p-3 mb-5 bg-white rounded mt-1 p-3">

		<!-- Success message -->
		<div class="text-center">
			<%@ include file="message.jsp"%>

		</div>

		<form action="ResetPassword" method="post">
             <input type="hidden" name="passOperation" value="update_password">
             <input type="hidden" name="id" value="<%=userid %>">
			  <div class=" mb-2 ms-2 mt-4">
				<label for="userName" class="form-label">Enter Your
					Password: </label> 
					
				<div class="input-group mb-3">
					<input type="password" class="form-control" name="userpwd1" id="password">
					<div class="input-group-append">
						<span class="input-group-text"><a href="#" id="icon-click"><i class="fas fa-eye mb-1 mt-1 text-dark" id="show_eye"></i></a></span>
					</div>
				</div>
			</div>
			
			<div class=" mb-2 ms-2 mt-4">
				<label for="userName" class="form-label">Enter Your Confirm Password: </label> 
					
				<div class="input-group mb-3">
					<input type="password" class="form-control" name="userpwd2" id="password2">
					<div class="input-group-append">
						<span class="input-group-text"><a href="#" id="icon-click2"><i class="fas fa-eye mb-1 mt-1 text-dark" id="show_eye2"></i></a></span>
					</div>
				</div>
				<div>
					 <p id="passmatch" style="font-size:12px"><i></i></p>
				</div>
			</div>
			
			

			<div class="container text-center mt-3">
				<button type="submit" class="btn btn-success "
					data-mdb-ripple-color="dark">Update Password</button>
				<a class="text-primary" href="login" style="text-decoration: none"><i>Login Account</i></a>
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

	  $(document).ready(function(){
			$("#icon-click2").click(function(){
				$("#show_eye2").toggleClass('fa-eye-slash');
				var pass=$("#password2");
				if(pass.attr("type")==="password"){
					pass.attr("type","text");
				}
				else{
					pass.attr("type","password");
				}
			});
			 
		  });

	  let pass1 = document.querySelector('#password');
	  let pass2 = document.querySelector('#password2');
	  let result = document.querySelector('#passmatch');


	  function checkPassword () {
	      result.innerText = pass1.value == pass2.value ?'Password Matching' : 'Password Not Matching';
	  }

	  pass1.addEventListener('keyup', () => {
	      if (pass2.value.length > 0) checkPassword();
	  })

	  pass2.addEventListener('keyup', checkPassword);
	
	</script>
	
</body>
</html>