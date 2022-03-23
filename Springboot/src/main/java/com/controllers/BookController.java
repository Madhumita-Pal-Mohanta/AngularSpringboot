package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.models.BookInfoModel;
import com.models.StudentUserInfoModel;
import com.services.BookService;

@RestController
@CrossOrigin(origins = "*")
public class BookController {
	
	@Autowired
	private BookService bookserviceobj;
	
	@PostMapping("/addbookrecord")
	public BookInfoModel addbookrecord(@RequestBody BookInfoModel bookobj)
	{
	  
			
	  boolean recordinsertionstatus = bookserviceobj.addbookrecord(bookobj);
			
		if(recordinsertionstatus)
		    return new BookInfoModel();
		else
			return null;
	}
	
	@GetMapping("/searchbookbyuserid/{userid}")
	public List<BookInfoModel> searchbookbyuserid(@PathVariable String userid)
	{
		//System.out.println(userid);
		int stuuserid = Integer.parseInt(userid);
		return bookserviceobj.searchbookbyuserid(stuuserid);
	}
	
	@GetMapping("/searchbookbyauthor/{author1}")
	public List<BookInfoModel> searchbookbyauthor(@PathVariable String author1)
	{
		return bookserviceobj.searchbookbyauthor(author1);
	}
	
	@GetMapping("/searchbookbytitle/{booktitle}")
	public List<BookInfoModel> searchbookbytitle(@PathVariable String booktitle)
	{
		return bookserviceobj.searchbookbytitle(booktitle);
	}
	
	@GetMapping("/searchbookbyid/{bookid}")
	public BookInfoModel searchbookbyid(@PathVariable String bookid)
	{
		return bookserviceobj.searchbookbyid(bookid);
	}
	
	@DeleteMapping("/deletebookbybookid/{bid}")
	public BookInfoModel deletebookbybookid(@PathVariable String bid)
	{
				
		int bookid = Integer.parseInt(bid);
		boolean recorddeletedstatus = bookserviceobj.deletebookbybookid(bookid);
		
		if(recorddeletedstatus)
		    return new BookInfoModel();
		else
			return null;
	}
	
	@PutMapping("/updatebook")
	public BookInfoModel updatebook(@RequestBody  BookInfoModel bookobj)
	{
		return bookserviceobj.updatebook(bookobj);
	}

}
