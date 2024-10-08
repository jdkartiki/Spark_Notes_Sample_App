<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HP Notes | Home</title>

<%@ include file="comm-css-javascript.jsp" %>
<link rel="stylesheet" type="text/css" href="css/index.css">	

<style>
  #home{
    background-image: url("img/notes.jpg");
    background-repeat : no repeat;
    background-position : center;
    background-attachment: fixed;
    height: 600px;
    width : 100%;
    position: relative;
    background-size:cover;
    display:table;
}

.landing-text{
    display: table-cell;
    text-align: center;
    vertical-align: middle;
}

.landing-text h1{
    font-size: 280%;
    font-weight: 600;
    color: #FFF;
}
.landing-text h3{
    font-size: 150%;
    font-weight: 200;
    color: #FAFAFA;
}

footer{
    width: 100%;
    background-color: #23415c;
    padding:1% 5% 10%  5%;
    color: #fff;
    height:40px;
}

.fab, .fa{
    padding:1px 10px 10px 20px;
    font-size: 25px;
    color: #fff;
}

.fa:hover, .fab:hover{
    color: #d5d5d5;
    text-decoration: none;
}

.icon {
    max-width: 200px;
}
#bgimage{
    background-image: url("img/bgg.jpg");
    background-repeat : no repeat;
    background-position : center;
    background-attachment: fixed;
    height: 600px;
    width : 100%;
    position: relative;
    background-size:cover;
    display:table;
}
  
</style>
</head>
<body>
   <%@ include file="navbar.jsp" %>
 
 <%
  DocumentationDao documentDao=new DocumentationDao(FactoryProvider.getFactory());
  List<Documentations> classNotesList=null;
  classNotesList= documentDao.getLatestUploadedClassNotes();
  
  List<Documentations> classQuestionPaperList=null;
  classQuestionPaperList= documentDao.getLatestUploadedClassQuestionPaper();
 %>
  
  <div id="home">
  <div class="landing-text">
    <h1>Get Class Notes And Question Paper</h1>
    <h3>This platform help to find out easily class notes and Question paper Set in a single platform..<br>
        Let Start ... </h3>
  </div>
</div>

<div class="padding">
  <div class="container">
    <div class="row">
       <div class="col-sm-6">
         <img src="img/book _library.png" style="width:80%">
       </div>

       <div class="col-sm-6 text-center">
         <h2>About HP Notes</h2>
         <p class="lead">HP Notes is a idea to store necessary class notes and also Question paper by Class wise.
                         This Platform Help to Student Get And Upload or share our knowledge by notes. as well as
                         the platform help to find out the quickly Question Paper Notes.
         </p>
         <p class="lead">The Online Platform provide for HP Student to grow yourself and save time to find out the
          row material for study. In Student biggest life problem solve this platform because, We believe that we save
          or Store the student study material, we save student life...
       </p>
       </div>
    </div>
  </div>
</div>
    <div >
         
    <div class="container-fluid" >
      <div class="row bg-light">
        <h6 style="font-family:'Bahnschrift'; color:#000"><i>Latest Uploaded Class Notes :</i></h6>
      </div>
        <div class="container-fluid mx-auto ">
       <div class="row">
           <%
           int cn=0;
       for(Documentations classNotes : classNotesList)
	   {   if(cn==6) break;
	         cn++;
	        %>
	           <div class="card m-1 shadow" style="width: 14rem;">
                  <div class="text-center container-fluid">
                     <img class="card-img-top img-fluid" src="img/docfile.png" alt="document" style="width:90px">
                  </div>
                  <div class="card-header bg-light">
                     <h6 class="card-title text-left text-dark"><%= classNotes.getTitle() %></h6>
                  </div>
                  <div class="card-body d.flex flex-column bg-light">                    
                     <p class="card-text" style="font-size: 12px;"><%=classNotes.getDescription() %></p>  
                                                
                  </div>
                  <div class="card-footer bg-light" style="background: #FFF">
                     <label class="font-weight-bold text-danger text-left text-bottom" style="font-size:11px;"><i>Uploaded By: </i></label>&nbsp;<b style="font-size:11px;"><%=classNotes.getUserName() %></b> <br>
                     <% SimpleDateFormat sf=new SimpleDateFormat("dd MMM yyyy"); String dateString=sf.format(classNotes.getUplodedDate()); %>
                     <label class="font-weight-bold text-danger text-left text-bottom" style="font-size:11px;"><i>Uploaded On: </i></label>&nbsp;<b style="font-size:11px;"><%=dateString %>  </b> 
                     <a href="DownloadFileServlet?fileid=<%= classNotes.getId() %>" class="btn btn-outline-success mt-1 ">Download file</a>
                  </div>
               </div>
	        
	        <%
	           
	        	}
            %>
       
       </div>
     </div>   
    </div>
  <hr>
    <div class="container-fluid mb-2">
      <div class="row bg-light">
        <h6 style="font-family:'Bahnschrift'; color:#000"><i>Latest Uploaded Class Question Paper Set :</i></h6>
      </div>
        <div class="container-fluid mx-auto ">
       <div class="row">
           <%
           int cq=0;
       for(Documentations classNotes : classQuestionPaperList)
	   {  
    	   if(cq==6) break;
    	      cq++;
	        %>
	           <div class="card m-1 shadow" style="width: 14rem;">
                  <div class="text-center container-fluid">
                     <img class="card-img-top img-fluid" src="img/docfile.png" alt="document" style="width:90px">
                  </div>
                  <div class="card-header bg-light">
                     <h6 class="card-title text-left text-dark"><%= classNotes.getTitle() %></h6>
                  </div>
                  <div class="card-body d.flex flex-column bg-light">                    
                     <p class="card-text" style="font-size: 12px;"><%=classNotes.getDescription() %></p>  
                                                
                  </div>
                  <div class="card-footer bg-light" style="background: #FFF">
                     <label class="font-weight-bold text-danger text-left text-bottom" style="font-size:11px;"><i>Uploaded By: </i></label>&nbsp;<b style="font-size:11px;"><%=classNotes.getUserName() %></b> <br>
                     <% SimpleDateFormat sf=new SimpleDateFormat("dd MMM yyyy"); String dateString=sf.format(classNotes.getUplodedDate()); %>
                     <label class="font-weight-bold text-danger text-left text-bottom" style="font-size:11px;"><i>Uploaded On: </i></label>&nbsp;<b style="font-size:11px;"><%=dateString %>  </b> 
                     <a href="DownloadFileServlet?fileid=<%= classNotes.getId() %>" class="btn btn-outline-success mt-1 ">Download file</a>
                  </div>
               </div>
	        
	        <%
	        	}
            %>
       
       </div>
     </div>
    
    </div>
    </div>
   


 
 <footer class="container-fluid text-center">
  <div class="row">
    <div class="col-sm-4">
      <h6>&copy; All Copyright reserved</h6><br>
      <p>Privacy Policy &nbsp;&nbsp;Terms Of Use &nbsp;&nbsp; Accessibility

    </div>
    <div class="col-sm-4">
      <h3>Connect Me.</h3>
      <a href="#"><i class="fab fa-facebook-f"></i></a>
	  <a href="#"><i class="fab fa-instagram"></i></a>
	  <a href="mailto:hiteshapatil1407@gmail.com"><i class="fa fa-envelope" aria-hidden="true"></i></a>

    </div>
    <div class="col-sm-4">
     
    </div>
  </div>
</footer>
 
</body>
</html>