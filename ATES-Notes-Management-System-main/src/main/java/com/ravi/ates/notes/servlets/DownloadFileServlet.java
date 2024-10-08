package com.ravi.ates.notes.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import com.ravi.ates.notes.dao.DocumentationDao;
import com.ravi.ates.notes.helper.FactoryProvider;
import com.ravi.ates.notes.model.Documentations;


public class DownloadFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DownloadFileServlet() {
        super();
    }
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		long id=Long.parseLong(request.getParameter("fileid"));
		DocumentationDao docDao=new DocumentationDao(FactoryProvider.getFactory());
		Documentations document=docDao.getDocumentById(id);
		
		String fileName=document.getFileName();
		
		ServletContext context = getServletContext();
		String contentType=context.getMimeType(fileName);
		    
	    if (contentType == null) {        
	    	contentType = "application/octet-stream";
        }

	    response.setHeader("Content-Type", contentType);

        response.setHeader("Content-Length", String.valueOf(document.getUploadedDocument().length));

        response.setHeader("Content-Disposition", "inline; filename=\"" + document.getFileName() + "\"");
        
        Blob fileData=null;
        try {
		    fileData=new SerialBlob(document.getUploadedDocument());
		    InputStream is=fileData.getBinaryStream();
		    System.out.println(is.available());
	        byte[] bytes = new byte[1024];
	        int bytesRead;

	        while ((bytesRead = is.read(bytes)) != -1) {
	            // Write image data to Response.
	            response.getOutputStream().write(bytes, 0, bytesRead);
	        }
	        is.close();
		    
		} catch (SerialException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}           
  
	}

}
