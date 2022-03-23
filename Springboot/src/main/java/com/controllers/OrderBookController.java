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

import com.models.OrderInfoModel;
import com.models.StudentUserInfoModel;
import com.services.OrderService;

@RestController
@CrossOrigin(origins = "*")
public class OrderBookController {

	@Autowired
	public OrderService orderserviceobj;
	
	@PostMapping("/addOrderRecord")
	public OrderInfoModel addOrderRecord(@RequestBody OrderInfoModel orderobj)
	{
		
	  boolean recordinsertionstatus = orderserviceobj.addOrderRecord(orderobj);
			
		if(recordinsertionstatus)
		    return new OrderInfoModel();
		else
			return null;
	}
	
	@GetMapping("/displayallsentorders/{buyerid}")
	public List<OrderInfoModel> displayallsentorders(@PathVariable String buyerid)
	{
		Integer buyeruserid = Integer.parseInt(buyerid);
		return orderserviceobj.searchrecordbyBuyerid(buyeruserid);
	}
	
	
	@GetMapping("/displayallreceivedorders/{sellerid}")
	public List<OrderInfoModel> displayallreceivedorders(@PathVariable String sellerid)
	{
		Integer selleruserid = Integer.parseInt(sellerid);
		return orderserviceobj.searchrecordbyBuyerid(selleruserid);
	}
	
	@DeleteMapping("/deleteorderbyid/{oid}")
	public OrderInfoModel deleteorderbyid(@PathVariable String oid)
	{
		Integer orderid = Integer.parseInt(oid);
		boolean recorddeletedstatus = orderserviceobj.deleteorderbyid(orderid);
		
		if(recorddeletedstatus)
		    return new OrderInfoModel();
		else
			return null;
	}
}
