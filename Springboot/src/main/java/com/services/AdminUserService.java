package com.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.models.StudentUserInfoModel;

@Service
public class AdminUserService {
	
	@Autowired
	private AdminRepository admindbhandleobj;
	
	public List<StudentUserInfoModel> fetchalluserdetails()
	{
		System.out.println("INSIDE fetchalluserdetails METHOD in SERVICE CLASS \n");
		
		List<StudentUserInfoModel> alluserdetails = new ArrayList<StudentUserInfoModel>();
		
		admindbhandleobj.findAll().forEach(alluserdetails ::add);
		return alluserdetails;
	 }

	public boolean deleteRecordByUserId(Integer stuuserid)
	{
				
		boolean recorddeleted = false;
		try
		{
			System.out.println("INSIDE deleteuserbyemail METHOD in SERVICE CLASS");
			System.out.println("User ID  "+ stuuserid +"\n");
		
			admindbhandleobj.deleteById(stuuserid);
			
			recorddeleted = true;
		
		}catch(Exception e) 
		 {
			System.out.println("INVALID ROLL NO");
		 }
		
		return recorddeleted;
	 }
	
	public StudentUserInfoModel searchrecordbyemailid(String emailid)
	{
				
		StudentUserInfoModel stuusersearchedobj=admindbhandleobj.findByEmailid(emailid);
		
		if (stuusersearchedobj != null)
			return stuusersearchedobj;
		else
			return null;
	 }
}
