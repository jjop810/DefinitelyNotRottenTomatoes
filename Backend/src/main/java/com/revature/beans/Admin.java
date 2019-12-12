package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="uAdmin")
@PrimaryKeyJoinColumn(name="userId")
public class Admin extends User
{
	@Column(name = "tittle")
	private String title;

	public Admin(Integer id) {
		super(id);
	}
	public Admin() {
		super();
	}
	
	public Admin(Integer id) {
		super(id);
	}
	public Admin(Integer id, String username, String password, String email, String title) {
		super(id, username, password, email);
		this.title = title;
	}
	
	public String getTitle() 
	{
		return title;
	}

	public void setTitle(String title) 
	{
		this.title = title;
	}
}
