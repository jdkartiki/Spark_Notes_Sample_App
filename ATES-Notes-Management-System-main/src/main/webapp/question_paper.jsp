<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.ravi.ates.notes.dao.*" %>
<!DOCTYPE html>



<html>
<head>
<meta charset="ISO-8859-1">
<title>Question Paper Set</title>
  <%@ include file="comm-css-javascript.jsp" %>
</head>
<body>

  <%@ include file="navbar.jsp" %>
  
   <%
     long classId=Long.parseLong(request.getParameter("classname"));
     String subject=request.getParameter("subjectid");
     String flag=null;
     long subjectId=0;
     
     NewClass newClass=new NewClassDao(FactoryProvider.getFactory()).getNewClassById(classId);

     NewClassSubjectDao newClassSubjectDao=new NewClassSubjectDao(FactoryProvider.getFactory());
     List<NewClassSubject> classSubjectList=newClassSubjectDao.getSubjectsByClassId(classId);
     
     DocumentationDao documentDao=new DocumentationDao(FactoryProvider.getFactory());
     
     List<Documentations> questionPaperList=null;
     NewClassSubject firstSub=null;
      
     if(classSubjectList.isEmpty()){
    	 firstSub=null;
    	 questionPaperList=null;
     }else
    	//If we call first time or we did't select any subject then by default select first subject
     if(subject== null){
    	 firstSub= classSubjectList.get(0);
    	 subjectId=firstSub.getId();
    	 questionPaperList=documentDao.getQuestionPapersByClassSubjectId(firstSub.getId());    	 
     }
     
     //if we select any subject then get question paper set by according
     else
     {
    	 firstSub=null;
    	 subjectId=Long.parseLong(subject.trim());
    	 questionPaperList=documentDao.getQuestionPapersByClassSubjectId(subjectId); 
     }  
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
%>
   
    <div class="container-fluid">
       <!-- Show all Subject Name by class name -->
	<div class="row mx-auto">
	    <div class="col-sm-3 col-md-2 col-lg-2 mt-3  text-left">
		   <div class="list-group container-fluid">
		   <label class="list-group-item list-group-item-action text-white bg-dark "><strong><%= newClass.getClassName()+"</strong><i> ("+newClass.getClassYear()+" year)</i>"%></label>
		     
		     
		     <%
		      if(classSubjectList.isEmpty()){
		      %>	 
		    	 <label class="list-group-item list-group-item-action  ">No Subject List Available</label>  
		     
		     <%	  
		      }
		      for(NewClassSubject subjectItr: classSubjectList){
		    	  if(subjectItr.getId()==subjectId){
		    		  flag="active";
		    	  }
		    	  else if(subjectItr.getId()==subjectId){
		    		  flag="active";
		    	  }else{
		    		  flag="";
		    	  }
		    	  
		    %>
		      <a href="question_paper.jsp?classname=<%=classId %>&subjectid=<%=subjectItr.getId() %>" class="list-group-item list-group-item-action <%=flag%>""><%= subjectItr.getSubjectName() %></a>
		    <%	  
		      }
		     
		     %>  
		  
          </div>

	</div>
	
	<div class="col-sm-9 col-md-10 col-lg-10 mt-2  ">
	   <div class="container-fluid">
	      <div class="row m-1">
	       <%
	          if(classSubjectList.isEmpty()){
	        %>	  
	          <h4 class="fst-italic text-center" style="color:#BDBDBD">No Question Paper Set Available</h4>
	        <%	  
	          }
	          else	         
	          if(questionPaperList.isEmpty()){
	        %>	  
	          <h4 class="fst-italic text-center" style="color:#BDBDBD">No Question Paper Set Available</h4>
	        <%	  
	          }
	          else{
	        	  for(Documentations questionPaperList1 : questionPaperList)
	        	  {
	        %>
	           <div class="card m-1 shadow" style="width: 14rem;">
                  <div class="text-center container-fluid">
                     <img class="card-img-top img-fluid" src="img/docfile.png" alt="document" style="width:90px">
                  </div>
                  <div class="card-header bg-light">
                     <h6 class="card-title text-left text-dark"><%= questionPaperList1.getTitle() %></h6>
                  </div>
                  <div class="card-body d.flex flex-column bg-light">                    
                     <p class="card-text" style="font-size: 12px;"><%=questionPaperList1.getDescription() %></p>  
                                                
                  </div>
                  <div class="card-footer bg-light" style="background: #FFF">
                     <label class="font-weight-bold text-danger text-left text-bottom" style="font-size:11px;"><i>Uploaded By: </i></label>&nbsp;<b style="font-size:11px;"><%=questionPaperList1.getUserName() %></b> <br>
                     <% SimpleDateFormat sf=new SimpleDateFormat("dd MMM yyyy"); String dateString=sf.format(questionPaperList1.getUplodedDate()); %>
                     <label class="font-weight-bold text-danger text-left text-bottom" style="font-size:11px;"><i>Uploaded On: </i></label>&nbsp;<b style="font-size:11px;"><%=dateString %>  </b> 
                     <a href="DownloadFileServlet?fileid=<%= questionPaperList1.getId() %>" class="btn btn-outline-success mt-1 " target="_blank">Download file</a>
                  </div>
               </div>
	        
	        <%
	        	}
	          }
	        %>
	                 
	      </div>	      
	   </div>	
	</div>
    
    
    </div>




</body>
</html>