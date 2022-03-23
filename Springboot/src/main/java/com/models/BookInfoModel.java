package com.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BookInfoModel {
	int bookid;
	int stuuserid;
	String booktitle ;
	String author1;	
	String marketprice;	
	String sellingprice;
	String quantity;
	
	@Id
	@GeneratedValue
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public int getStuuserid() {
		return stuuserid;
	}
	public void setStuuserid(int stuuserid) {
		this.stuuserid = stuuserid;
	}
	public String getBooktitle() {
		return booktitle;
	}
	public void setBooktitle(String booktitle) {
		this.booktitle = booktitle;
	}
	public String getAuthor1() {
		return author1;
	}
	public void setAuthor1(String author1) {
		this.author1 = author1;
	}
	public String getMarketprice() {
		return marketprice;
	}
	public void setMarketprice(String marketprice) {
		this.marketprice = marketprice;
	}
	public String getSellingprice() {
		return sellingprice;
	}
	public void setSellingprice(String sellingprice) {
		this.sellingprice = sellingprice;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

  
}
