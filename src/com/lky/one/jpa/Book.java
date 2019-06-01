package com.lky.one.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the books database table.
 * 
 */
@Entity
@Table(name="books")
@NamedQuery(name="Book.findAll", query="SELECT b FROM Book b")
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;

	private String authers;

	private int bid;

	private String bname;

	@Id
	private String bnum;

	private int kind;

	private double price;

	@Temporal(TemporalType.DATE)
	private Date pubDate;

	public Book() {
	}

	public String getAuthers() {
		return this.authers;
	}

	public void setAuthers(String authers) {
		this.authers = authers;
	}

	public int getBid() {
		return this.bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBname() {
		return this.bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getBnum() {
		return this.bnum;
	}

	public void setBnum(String bnum) {
		this.bnum = bnum;
	}

	public int getKind() {
		return this.kind;
	}

	public void setKind(int kind) {
		this.kind = kind;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getPubDate() {
		return this.pubDate;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}

}