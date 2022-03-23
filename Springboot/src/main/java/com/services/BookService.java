package com.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.models.BookInfoModel;
import com.models.StudentUserInfoModel;


@Service
public class BookService {
	
	@Autowired
	private BookRepository bookDBobject;

	public boolean addbookrecord(BookInfoModel bookobj) 
	{
	  
	   
	   boolean recordinserted = false;
		try
		{
			bookDBobject.save(bookobj);
			
			recordinserted = true;
		
		}catch(Exception e) 
		 {
			recordinserted = false;
		 }
		
		return recordinserted;
	  

	}
	
	public List<BookInfoModel> searchbookbyuserid(int stuuserid)
	{
				
		List<BookInfoModel> userbooklistobj= bookDBobject.findByStuuserid(stuuserid);
		
		if (userbooklistobj.size()>0)
			return userbooklistobj;
		else
			return null;
	 }
	
	public List<BookInfoModel> searchbookbyauthor(String author1)
	{
				
		List<BookInfoModel> userbooklistobj= bookDBobject.findByAuthor1(author1);
		
		if (userbooklistobj.size()>0)
			return userbooklistobj;
		else
			return null;
	 }
	
	public List<BookInfoModel> searchbookbytitle(String booktitle)
	{
				
		List<BookInfoModel> userbooklistobj= bookDBobject.findByBooktitle(booktitle);
		
		if (userbooklistobj.size()>0)
			return userbooklistobj;
		else
			return null;
	 }
	
	public BookInfoModel searchbookbyid(String bid)
	{
		int bookid = Integer.parseInt(bid);	
		
		Optional<BookInfoModel> booksearchedobj= bookDBobject.findById(bookid);
		
		BookInfoModel bookobj = booksearchedobj.get();
		
		if (bookobj != null)
			return bookobj;
		else
			return null;
	 }
	
	public boolean deletebookbybookid(Integer bookid)
	{
				
		boolean recorddeleted = false;
		try
		{
				
			bookDBobject.deleteById(bookid);
			
			recorddeleted = true;
		
		}catch(Exception e) 
		 {
			System.out.println("INVALID book NO");
		 }
		
		return recorddeleted;
	 }
	
	public BookInfoModel updatebook(BookInfoModel bookobj)
	{
			
		bookobj = bookDBobject.save(bookobj);
		
		if (bookobj != null)
			return bookobj;
		else
			return null;
	 }
	
}
