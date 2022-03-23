package com.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.models.StudentUserInfoModel;

@Service
public class StudentUserService {
	@Autowired
	private UserRepository userdbhandleobj;

	public boolean addUserRecord(StudentUserInfoModel studentuserobj) 
	{
	  
	   
	   boolean recordinserted = false;
		try
		{
			System.out.println("INSIDE addUserRecord METHOD in SERVICE CLASS");
			System.out.println("User ID  "+ studentuserobj.getEmailid() +"\n");
		
			userdbhandleobj.save(studentuserobj);
			
			recordinserted = true;
		
		}catch(Exception e) 
		 {
			System.out.println("USER ALREADY EXIT");
		 }
		
		return recordinserted;
	  

	}
	
	public StudentUserInfoModel searchrecordbyid(String userid)
	{
		int stuuserid = Integer.parseInt(userid);		
		Optional<StudentUserInfoModel> stuusersearchedobj= userdbhandleobj.findById(stuuserid);
		
		StudentUserInfoModel stuobj = stuusersearchedobj.get();
		
		if (stuobj != null)
			return stuobj;
		else
			return null;
	 }
	
	public StudentUserInfoModel userupdateprofile(StudentUserInfoModel studentuserobj)
	{
			
		studentuserobj = userdbhandleobj.save(studentuserobj);
		
		if (studentuserobj != null)
			return studentuserobj;
		else
			return null;
	 }

}
