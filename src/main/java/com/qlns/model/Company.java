package com.qlns.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Company {

	@Id
	@Column
	private int id;
	@Column
	private String name;
	@Column
	private long revenue;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getRevenue() {
		return revenue;
	}

	public void setRevenue(long revenue) {
		this.revenue = revenue;
	}

	public void displayInfo() {
		System.out.println("Company Name: " + this.name + "; Id: " + this.id
				+ "; Revenue: " + this.revenue);
	}
	
}
