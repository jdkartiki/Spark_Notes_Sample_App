package com.ravi.ates.notes.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Documentations {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private long id;
	
	private String title;
	
	private String Description;
	
	@Temporal(TemporalType.DATE)
	private Date uplodedDate=new Date();
	
	private String docType;
	
	@Lob
	private byte[] uploadedDocument;
	
	private String fileName;
	
	@ManyToOne
	@JoinColumn(name="class_subject_fk")
	private NewClassSubject newsubject;
	
	private String uplodadDocType;
	
	private String userName;
	
	private long userId;
	
	//private NewClass newclassObj;

	public Documentations() {
		super();
	}

	

	public Documentations(String title, String description, Date uplodedDate, String docType, byte[] uploadedDocument,
			NewClassSubject newsubject, String uplodadDocType, String userName) {
		super();
		this.title = title;
		Description = description;
		this.uplodedDate = uplodedDate;
		this.docType = docType;
		this.uploadedDocument = uploadedDocument;
		this.newsubject = newsubject;
		this.uplodadDocType = uplodadDocType;
		this.userName = userName;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Date getUplodedDate() {
		return uplodedDate;
	}

	public void setUplodedDate(Date uplodedDate) {
		this.uplodedDate = uplodedDate;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public byte[] getUploadedDocument() {
		return uploadedDocument;
	}

	public void setUploadedDocument(byte[] uploadedDocument) {
		this.uploadedDocument = uploadedDocument;
	}

	public NewClassSubject getNewsubject() {
		return newsubject;
	}

	public void setNewsubject(NewClassSubject newsubject) {
		this.newsubject = newsubject;
	}

	public String getUplodadDocType() {
		return uplodadDocType;
	}

	public void setUplodadDocType(String uplodadDocType) {
		this.uplodadDocType = uplodadDocType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}



	public long getUserId() {
		return userId;
	}



	public void setUserId(long userId) {
		this.userId = userId;
	}



	public String getFileName() {
		return fileName;
	}



	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

		

}
