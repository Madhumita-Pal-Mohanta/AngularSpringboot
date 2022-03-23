package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.models.BookInfoModel;
import com.models.OrderInfoModel;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository OrderDBobj;
	
	public boolean addOrderRecord(OrderInfoModel orderobj) 
	{
	    boolean recordinserted = false;
		try
		{
			OrderDBobj.save(orderobj);
			recordinserted = true;
		
		}catch(Exception e) 
		 { }
		
		return recordinserted;
	}
	
	public List<OrderInfoModel> searchrecordbyBuyerid(Integer buyeruserid)
	{
				
		List<OrderInfoModel> orderedbooklistobj= OrderDBobj.findByBuyeruserid(buyeruserid);
		
		if (orderedbooklistobj.size()>0)
			return orderedbooklistobj;
		else
			return null;
	 }
	
	public List<OrderInfoModel> displayallreceivedorders(Integer buyeruserid)
	{
				
		List<OrderInfoModel> orderedbooklistobj= OrderDBobj.findBySelleruserid(buyeruserid);
		
		if (orderedbooklistobj.size()>0)
			return orderedbooklistobj;
		else
			return null;
	 }
	
	public boolean deleteorderbyid(Integer orderid)
	{
				
		boolean recorddeleted = false;
		try
		{
			
			OrderDBobj.deleteById(orderid);
			
			recorddeleted = true;
		
		}catch(Exception e) 
		 {
			System.out.println("INVALID ORDER ID");
		 }
		
		return recorddeleted;
	 }

}
