package com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.models.StudentUserInfoModel;
import com.services.AdminUserService;
import com.services.StudentUserService;

@RestController
@CrossOrigin(origins = "*")
public class StudentUserController {

     

		@Autowired
		private StudentUserService stuuserserviceobj;
		@Autowired
		private AdminUserService adminuserserviceobj;
		
		@PostMapping("/addstudentuserrecord")
		public StudentUserInfoModel addUserRecord(@RequestBody StudentUserInfoModel studentuserobj)
		{
		  System.out.println(studentuserobj.getEmailid() +"  "+ studentuserobj.getUsername());
				
		  boolean recordinsertionstatus = stuuserserviceobj.addUserRecord(studentuserobj);
				
			if(recordinsertionstatus)
			    return new StudentUserInfoModel();
			else
				return null;
		}
		
		@PostMapping("/userLoginCheck")
		public StudentUserInfoModel userLoginCheck(@RequestBody StudentUserInfoModel userloginobj)
		{
			
			StudentUserInfoModel userobj = adminuserserviceobj.searchrecordbyemailid(userloginobj.getEmailid());
			System.out.println("Login ID for Check ------->>   " +  userloginobj.getEmailid());
			if (userobj != null)
			{
				if(!(userloginobj.getUserpassword().equals(userobj.getUserpassword())))
					userobj=null;
					
			}
			
			return userobj;
		}
		
		@GetMapping("/searchrecordbyid/{stuuserid}")
		public StudentUserInfoModel searchrecordbyid(@PathVariable String stuuserid)
		{
			return stuuserserviceobj.searchrecordbyid(stuuserid);
		}

		@PutMapping("/userupdateprofile")
		public StudentUserInfoModel userupdateprofile(@RequestBody  StudentUserInfoModel userupdatedobj)
		{
			return stuuserserviceobj.userupdateprofile(userupdatedobj);
		}
	
}
