package com.ravi.ates.notes.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class NewClass {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	
	@Column(name="class_name")
	private String className;
	
	@Column(name="class_year")
	private String classYear;

	@OneToMany(mappedBy = "newClassObj", cascade = CascadeType.ALL)
	private List<NewClassSubject> subjectList=new ArrayList<NewClassSubject>();

	
	public NewClass() {
		super();
	}

	public NewClass(String className, String classYear, List<NewClassSubject> subjectList) {
		super();
		this.className = className;
		this.classYear = classYear;
		this.subjectList = subjectList;
	}

	public NewClass(Long id, String className, String classYear, List<NewClassSubject> subjectList) {
		super();
		this.id = id;
		this.className = className;
		this.classYear = classYear;
		this.subjectList = subjectList;
	}
	
	

	public void setId(Long id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassYear() {
		return classYear;
	}

	public void setClassYear(String classYear) {
		this.classYear = classYear;
	}

	public List<NewClassSubject> getSubjectList() {
		return subjectList;
	}

	public void setSubjectList(List<NewClassSubject> subjectList) {
		this.subjectList = subjectList;
	}

	public Long getId() {
		return id;
	}

	

}
