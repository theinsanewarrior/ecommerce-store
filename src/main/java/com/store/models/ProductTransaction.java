package com.store.models;

import java.util.*;

import javax.persistence.*;


@Entity
public class ProductTransaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tid;
	private String uid;
	private int pid;
	private int quantity;
	private int price;
	public ProductTransaction() {}
	public ProductTransaction(String uid, int pid, int quantity, int price, Date date) {
		super();
		this.uid = uid;
		this.pid = pid;
		this.quantity = quantity;
		this.price = price;
		this.date = date;
	}
	private Date date;
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
