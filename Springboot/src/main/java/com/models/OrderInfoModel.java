package com.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OrderInfoModel {
	int orderid;
	int bookid;
	int selleruserid;
	int buyeruserid;
	
	@Id
	@GeneratedValue
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public int getSelleruserid() {
		return selleruserid;
	}
	public void setSelleruserid(int selleruserid) {
		this.selleruserid = selleruserid;
	}
	public int getBuyeruserid() {
		return buyeruserid;
	}
	public void setBuyeruserid(int buyeruserid) {
		this.buyeruserid = buyeruserid;
	}
	
}
