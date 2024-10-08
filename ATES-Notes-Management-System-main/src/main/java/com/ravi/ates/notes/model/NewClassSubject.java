package com.ravi.ates.notes.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class NewClassSubject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private long id;

	private String subjectName;

	private String Description;

	@ManyToOne
	@JoinColumn(name="class_fk")
	private NewClass newClassObj;


	@OneToMany(mappedBy = "newsubject", cascade = CascadeType.ALL)
	private List<Documentations> documentObj=new ArrayList<Documentations>();



	public NewClassSubject() {
		super();
	}


	public NewClassSubject(String subjectName, String description, NewClass newClassObj,
			List<Documentations> documentObj) {
		super();
		this.subjectName = subjectName;
		Description = description;
		this.newClassObj = newClassObj;
		this.documentObj = documentObj;
	}





	public long getId() {
		return id;
	}




	public void setId(long id) {
		this.id = id;
	}




	public String getSubjectName() {
		return subjectName;
	}


	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}


	public String getDescription() {
		return Description;
	}


	public void setDescription(String description) {
		Description = description;
	}


	public NewClass getNewClassObj() {
		return newClassObj;
	}


	public void setNewClassObj(NewClass newClassObj) {
		this.newClassObj = newClassObj;
	}




	public List<Documentations> getDocumentObj() {
		return documentObj;
	}




	public void setDocumentObj(List<Documentations> documentObj) {
		this.documentObj = documentObj;
	}
	

}
