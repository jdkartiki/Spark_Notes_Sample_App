<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
			<h2>Sign Up</h2>
		</div>
	</div>


	<div
		class="col-md-4 offset-md-4 shadow p-3 mb-5 bg-white rounded mt-1 p-3">
		
		<!-- Success message -->
		 <div class="text-center">
          <%@ include file="message.jsp" %>
       
       </div>

		<form action="RegisterServlet" method="post">
		
		   <div class="mb-2 ms-2">
				<label for="userNameId" class="form-label">Enter your User Name: </label> <input
					type="text" class="form-control" id="usernameId" name="unameid" placeholder="Enter the unique user Id"
					aria-describedby="text">
			</div>


			<div class="mb-2 ms-2 mt-4">
				<label for="userName" class="form-label">Enter Your Password: </label>
					<div class="input-group mb-3">
					<input type="password" class="form-control" name="upwd" id="password">
					<div class="input-group-append">
						<span class="input-group-text"><a href="#" id="icon-click"><i class="fas fa-eye mb-1 mt-1 text-dark" id="show_eye"></i></a></span>
					</div>
				</div>
			</div>
			
			<hr style="height:2px;border-width:0;color:gray;background-color:gray">
			<div class="mb-2 ms-2">
				<label for="userName" class="form-label">Enter Your full Name: </label> <input
					type="text" class="form-control" id="username" name="uname" placeholder="firstname middlename lastname"
					aria-describedby="text">
			</div>

			<div class="mb-2 ms-2 mt-4">
				<label for="userEmail" class="form-label">Enter Your Email:
				</label> <input type="email" class="form-control" id="userEmail" name="uemail"
					aria-describedby="emailHelp">
			</div>


			<div class="mb-2 ms-2 mt-4">
				<label for="userName" class="form-label">Enter Mobile Number: </label> <input type="text" class="form-control" id="userMobile" name="umobile">
			</div>
			
			<div class="mb-2 ms-2 mt-4">
				<label for="admissionyear" class="form-label">Enter Admission Year: </label> <input type="text" class="form-control" id="userAdmissionYear" name="uadmiss" placeholder="yyyy">
			</div>


			<div class="mb-2 ms-2 mt-4">
				<label for="userName" class="form-label">Select Your Picture: </label> <input type="file" class="form-control" id="userPicture" name="profilepic">
			</div>

			<div class="mb-2 ms-2">
				<label for="animalName" class="form-label">Enter your One favorite animal name? </label> <input
					type="text" class="form-control" id="animalname" name="animalname" placeholder="(Ex. Tiger, Lion, Elephant etc.)"
					aria-describedby="text">
			</div>


			<div class="container text-center mt-3">
				<button type="submit" class="btn btn-primary "
					data-mdb-ripple-color="dark">Register</button>
				<button type="submit" class="btn btn-warning ms-3"
					data-mdb-ripple-color="dark">Reset</button>
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