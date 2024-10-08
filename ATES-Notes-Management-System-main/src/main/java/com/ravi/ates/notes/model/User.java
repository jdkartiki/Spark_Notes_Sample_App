package com.ravi.ates.notes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userId;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="user_pwd")
	private String userPassword;
	
	@Column(name="user_full_name")
	private String userFullName;
	
	@Column(name="user_email")
	private String userEmail;
			
	@Column(name="user_phone")
	private String userPhone;
	
	@Column(name="use_admission_year")
	private Integer userAdmissionYear;
	
	@Column(name="user_pic")
	private String userPic;
	
	@Column(length = 1500, name="user_Answer")
	private String userAnswer;
	
	@Column(name="user_type")
	private String userType;

	public User() {
		super();
	}

	public User(String userName, String userPassword, String userFullName, String userEmail, String userPhone,
			Integer userAdmissionYear, String userPic, String userAnswer, String userType) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.userFullName = userFullName;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.userAdmissionYear = userAdmissionYear;
		this.userPic = userPic;
		this.userAnswer = userAnswer;
		this.userType = userType;
	}

	public User(int userId, String userName, String userPassword, String userFullName, String userEmail,
			String userPhone, Integer userAdmissionYear, String userPic, String userAnswer, String userType) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userFullName = userFullName;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.userAdmissionYear = userAdmissionYear;
		this.userPic = userPic;
		this.userAnswer = userAnswer;
		this.userType = userType;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserFullName() {
		return userFullName;
	}

	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public Integer getUserAdmissionYear() {
		return userAdmissionYear;
	}

	public void setUserAdmissionYear(Integer userAdmissionYear) {
		this.userAdmissionYear = userAdmissionYear;
	}

	public String getUserPic() {
		return userPic;
	}

	public void setUserPic(String userPic) {
		this.userPic = userPic;
	}

	public String getUserAnswer() {
		return userAnswer;
	}

	public void setUserAnswer(String userAnswer) {
		this.userAnswer = userAnswer;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
	
		
	
}
