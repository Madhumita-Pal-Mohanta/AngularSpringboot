package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.models.StudentUserInfoModel;
import com.services.AdminUserService;



@RestController
@CrossOrigin(origins = "*")
public class AdminUserController {
	@Autowired
	private AdminUserService adminuserserviceobj;
	
	@GetMapping("/fetchalluserdetails")
	public List<StudentUserInfoModel> getAllUserDetails()
	{
		System.out.println("INSIDE getAllUserDetails Method IN CONTROLLER CLASS");
		
		return adminuserserviceobj.fetchalluserdetails();
	}
	

	@DeleteMapping("/deleterecordbyuserid/{stuuserid}")
	public StudentUserInfoModel deleteRecordByUserId(@PathVariable String stuuserid)
	{
		System.out.println("INSIDE deleteUser Method IN CONTROLLER CLASS");
		System.out.println("RECEIVED FROM URL IN CONTROLLER "+stuuserid);
		
		int userid = Integer.parseInt(stuuserid);
		boolean recorddeletedstatus = adminuserserviceobj.deleteRecordByUserId(userid);
		
		if(recorddeletedstatus)
		    return new StudentUserInfoModel();
		else
			return null;
	}
	
	@GetMapping("/searchrecordbyemailid/{stuuseremailid}")
	public StudentUserInfoModel searchrecordbyemailid(@PathVariable String stuuseremailid)
	{
		return adminuserserviceobj.searchrecordbyemailid(stuuseremailid);
	}

}
