package com.models;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;




@Entity
public class StudentUserInfoModel //implements Serializable 
{
	   
		int stuuserid;
		String emailid ;
		String userpassword;	
		String username;	
		String gender;
		String userqualification;
	  	String  userphone;
	  	String useraddress;
	  	
	  	@Id
	  	@GeneratedValue
		public int getStuuserid() {
			return stuuserid;
		}
		public void setStuuserid(int stuuserid) {
			this.stuuserid = stuuserid;
		}
		
		@Column(unique=true)
	  	public String getEmailid() {
			return emailid;
		}
		public void setEmailid(String emailid) {
			this.emailid = emailid;
		}
		public String getUserpassword() {
			return userpassword;
		}
		public void setUserpassword(String userpassword) {
			this.userpassword = userpassword;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getUserqualification() {
			return userqualification;
		}
		public void setUserqualification(String userqualification) {
			this.userqualification = userqualification;
		}
	
		public String getUserphone() {
			return userphone;
		}
		public void setUserphone(String userphone) {
			this.userphone = userphone;
		}
		public String getUseraddress() {
			return useraddress;
		}
		public void setUseraddress(String useraddress) {
			this.useraddress = useraddress;
		}
		

}
